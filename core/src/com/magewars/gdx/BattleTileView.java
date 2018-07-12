package com.magewars.gdx;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.magewars.game.BattleField;
import com.magewars.game.entity.UnitWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

public class BattleTileView extends Widget {
    private static class Target {
        float x, y, originX, originY, start;
        public Target(float x, float y, float originX, float originY, float start) {
            this.x = x;
            this.y = y;
            this.originX = originX;
            this.originY = originY;
            this.start = start;
        }
    }
    private static class EffectAnimation {
        Animation animation;
        float x, y, originX, originY, start, time;
        public EffectAnimation(float x, float y, float originX, float originY, float start) {
            this.x = x;
            this.y = y;
            this.originX = originX;
            this.originY = originY;
            this.start = start;
        }

        public EffectAnimation(Animation animation, float originX, float originY, float x, float y, float start, float time) {
            this.animation = animation;
            this.x = x;
            this.y = y;
            this.originX = originX;
            this.originY = originY;
            this.start = start;
            this.time = time;
        }
    }


    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private Table table;
    private ArrayList<UnitWrapper> players = new ArrayList<>();
    private BattleField battleField;
    private GdxGame gdxGame;
    private Interpolation inter = Interpolation.linear;
    private HashMap<UnitWrapper, Target> targets = new HashMap<>();
    private ArrayList<EffectAnimation> effects=new ArrayList<>();
    private float offsetX, offsetY;
    private float stateTime;


    public BattleTileView(GdxGame gdxGame, float x, float y, float width, float height) {
        logger.info("{}", inter.apply(0f, 100f, 0.1f));

        this.gdxGame = gdxGame;
        offsetX = x;
        offsetY = y;
        setHeight(height);
        setWidth(width);
        setFillParent(true);
        table = new Table();
        debug();
        addListener(new InputListener() {
            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
//                outputLabel.setText("Press a Button");
                logger.info("table x {}, y {}", x, y);
            }

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
        });

        table.pad(new Value.Fixed(1f));
        table.defaults().space(new Value.Fixed(1f)).fill();

        table.row().expand();
        table.add(new Image(gdxGame.getManager().getFloorAtlas().getTiledDrawable("cobble_blood_10_new")));
        table.add(new Image(gdxGame.getManager().getFloorAtlas().getTiledDrawable("cobble_blood_3_new")));
        table.add(new Image(gdxGame.getManager().getFloorAtlas().getTiledDrawable("crypt_10")));
        table.add(new Image(gdxGame.getManager().getFloorAtlas().getTiledDrawable("marble_floor_1")));
        table.add(new Image(gdxGame.getManager().getFloorAtlas().getTiledDrawable("swamp_1_new")));
        table.add(new Image(gdxGame.getManager().getFloorAtlas().getTiledDrawable("cobble_blood_3_new")));

        table.setWidth(width);
        table.setHeight(height);
    }

    private ReentrantLock lock = new ReentrantLock();

    public void setBattleField(BattleField battleField) {
        lock.lock();
        this.battleField = battleField;
        Random r = new Random();
        for (int i = 0; i < battleField.getTiles().size(); i++) {
            for (int j = 0; j < battleField.getTiles().get(i).getUnits().size(); j++) {
                UnitWrapper wrapper = battleField.getTiles().get(i).getUnits().get(j);
                wrapper.setUnitGraphics(new UnitGraphics(gdxGame));
                float posx = getWidth() / 6 * i + (getWidth() / 6) / 2 - wrapper.getUnitGraphics().getImage().getRegionWidth() / 2;
                float posY = getHeight() / battleField.getTiles().get(i).getUnits().size() * j + 50 - wrapper.getUnitGraphics().getImage().getRegionHeight() / 2;

                wrapper.getUnitGraphics().setX(posx);
                wrapper.getUnitGraphics().setY(posY);

                players.add(wrapper);
            }
        }
        lock.unlock();
    }

    public void refreshUnits() {
        if (battleField != null) {
            Random r = new Random();
            for (UnitWrapper entry : players) {
                float targetX = getWidth() / 6 * entry.getTile().getId() + (getWidth() / 6) / 2 + r.nextInt(20) - entry.getUnitGraphics().getImage().getRegionWidth() / 2;
                float targetY = getHeight() / entry.getTile().getUnits().size() * entry.getTile().getUnits().indexOf(entry) + 50 - entry.getUnitGraphics().getImage().getRegionHeight() / 2;
                if (!MathUtils.isEqual(targetX, entry.getUnitGraphics().getX()) || !MathUtils.isEqual(targetY, entry.getUnitGraphics().getY())) {
                    targets.put(entry, new Target(targetX, targetY, entry.getUnitGraphics().getX(), entry.getUnitGraphics().getY(), stateTime));
                    logger.info("target for {} set to {} {}", entry.getUnit().getName(), targetX, targetY);
                }
            }
        }
    }
    public void refreshTime(float time){
        stateTime += time;
    }

    public void addEffect(UnitWrapper from, UnitWrapper to) {
        float fromX = from.getUnitGraphics().getX()+from.getUnitGraphics().getImage().getRegionWidth() / 2;
        float fromY = from.getUnitGraphics().getY()+from.getUnitGraphics().getImage().getRegionHeight() / 2;
        float toX = to.getUnitGraphics().getX()+to.getUnitGraphics().getImage().getRegionWidth() / 2;
        float toY = to.getUnitGraphics().getY()+to.getUnitGraphics().getImage().getRegionHeight() / 2;
        logger.info("arrow from  {} {}  to {} {}", fromX,fromY,toX,toY);


        EffectAnimation effectAnimation=new EffectAnimation(gdxGame.getManager().getArrow1(),fromX,fromY,toX,toY,stateTime,3f);
        effects.add(effectAnimation);
    }
    public void showEffects(Batch batch){
        ArrayList<EffectAnimation> toDel=new ArrayList<>();
        for(EffectAnimation effect:effects){
            float x = inter.apply(effect.originX, effect.x, (stateTime - effect.start)/effect.time);
            float y = inter.apply(effect.originY, effect.y, (stateTime - effect.start)/effect.time);
            TextureRegion keyFrame = (TextureRegion) effect.animation.getKeyFrame(stateTime, true);
            batch.draw(keyFrame, x+offsetX, y+offsetY, 0, 0, keyFrame.getRegionWidth(), keyFrame.getRegionHeight(), 1f, 1f, 0f);
            if(effect.start+effect.time<stateTime){
                toDel.add(effect);
            }
        }
        for(EffectAnimation effect:toDel){
            logger.info("arrow deleted  {} {} {}", effect.start,effect.time,stateTime);
            effects.remove(effect);
        }
    }


    public void refresh() {
        ArrayList<UnitWrapper> toDel = new ArrayList<>();
        for (UnitWrapper player : players) {
            if (targets.containsKey(player)) {
                Target coord = targets.get(player);
                int i = 0;
                if (!MathUtils.isEqual(player.getUnitGraphics().getX(), coord.x)) {
                    float apply = inter.apply(coord.originX, coord.x, (stateTime - coord.start));
                    player.getUnitGraphics().setX(apply);
                    i++;
                    if (Math.abs(player.getUnitGraphics().getX() - coord.x) <= 1f) {
                        player.getUnitGraphics().setX(coord.x);
                        i--;
                    }
                }

                if (!MathUtils.isEqual(player.getUnitGraphics().getY(), coord.y)) {
                    float apply = inter.apply(coord.originY, coord.y, stateTime - coord.start);
                    player.getUnitGraphics().setY(apply);
                    i++;
                    if (Math.abs(player.getUnitGraphics().getY() - coord.y) <= 1f) {
                        player.getUnitGraphics().setY(coord.y);
                        i--;
                    }
                }
                if (i == 0) {
                    logger.info("target removed {} {}- {} {}", player.getUnitGraphics().getX(), player.getUnitGraphics().getY(), coord.x, coord.y);
                    toDel.add(player);
                }
                player.getUnitGraphics().run(stateTime);
            } else {
                player.getUnitGraphics().stay(stateTime);
            }
        }

        for (UnitWrapper image : toDel) {
            targets.remove(image);
        }
    }

    @Override
    protected void setStage(Stage stage) {
        super.setStage(stage);
    }

    @Override
    protected void setParent(Group parent) {
        super.setParent(parent);
    }

    public void draw(Batch batch, float parentAlpha) {
        //  player.setX(player.getX()+1);
        float tx = table.getX(), ty = table.getY();
        refreshTime(Gdx.graphics.getDeltaTime());
        table.setPosition(tx + offsetX, ty + offsetY);
        table.draw(batch, parentAlpha);
        table.setPosition(tx, ty);
        showEffects(batch);
        refresh();



        for (UnitWrapper player : players) {
            UnitGraphics gr = player.getUnitGraphics();
            gr.getImage().flip(gr.getImage().isFlipX(), gr.getImage().isFlipY());
            float ix = gr.getX(), iy = gr.getY();
            gr.setPosition(ix + offsetX, iy + offsetY);
            batch.draw(gr.getImage(), gr.getX(), gr.getY(), gr.getOriginX(), gr.getOriginY(), gr.getImage().getRegionWidth(), gr.getImage().getRegionHeight(), 1f, 1f, gr.getRotate());
            gr.setPosition(ix, iy);
        }
        super.draw(batch, parentAlpha);
    }

}
