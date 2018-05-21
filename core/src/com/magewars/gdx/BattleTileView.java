package com.magewars.gdx;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.Scaling;
import com.magewars.game.BattleField;
import com.magewars.game.entity.UnitWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.ReentrantLock;

import static com.badlogic.gdx.utils.Align.*;

public class BattleTileView extends Widget {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private Table table;
    private ArrayList<UnitWrapper> players = new ArrayList<>();
    private BattleField battleField;
    private GdxGame gdxGame;
    private Interpolation inter = Interpolation.linear;
    private HashMap<UnitWrapper, Vector3> targets = new HashMap<>();
    private float offsetX, offsetY;
    private float stateTime;
    ;


    public BattleTileView(GdxGame gdxGame, float x, float y, float width, float height) {
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
        table.add(new Image(gdxGame.getFloorAtlas().getTiledDrawable("cobble_blood_10_new")));
        table.add(new Image(gdxGame.getFloorAtlas().getTiledDrawable("cobble_blood_3_new")));
        table.add(new Image(gdxGame.getFloorAtlas().getTiledDrawable("crypt_10")));
        table.add(new Image(gdxGame.getFloorAtlas().getTiledDrawable("marble_floor_1")));
        table.add(new Image(gdxGame.getFloorAtlas().getTiledDrawable("swamp_1_new")));
        table.add(new Image(gdxGame.getFloorAtlas().getTiledDrawable("cobble_blood_3_new")));

        table.setWidth(width);
        table.setHeight(height);
        //player = new Image(gdxGame.getPlayerAtlas().getDrawable("base/minotaur_male"), Scaling.none);
        //player.setFillParent(true);
        //player.setPosition(x, y);

        // add(player1);
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
                ;
                float targetY = getHeight() / entry.getTile().getUnits().size() * entry.getTile().getUnits().indexOf(entry) + 50 - entry.getUnitGraphics().getImage().getRegionHeight() / 2;
                ;
                if (MathUtils.isEqual(targetX, entry.getUnitGraphics().getX()) && MathUtils.isEqual(targetY, entry.getUnitGraphics().getY())) {

                } else {
                    targets.put(entry, new Vector3(targetX, targetY, Gdx.graphics.getDeltaTime()));
                    logger.info("tatget for {} set to {} {}", entry.getUnit().getName(), targetX, targetY);
                }
            }
        }
    }


    public void refresh(float time) {
        stateTime += time;
        ArrayList<UnitWrapper> toDel = new ArrayList<>();
        for (UnitWrapper player : players) {
            if (targets.containsKey(player)) {
                Vector3 coord = targets.get(player);
                int i = 0;
                if (!MathUtils.isEqual(player.getUnitGraphics().getX(), coord.x)) {
                    i++;
                    if (player.getUnitGraphics().getX() < coord.x) {
                        player.getUnitGraphics().setX(player.getUnitGraphics().getX() + 0.5f);
                    } else {
                        player.getUnitGraphics().setX(player.getUnitGraphics().getX() - 0.5f);
                    }
                    if (Math.abs(player.getUnitGraphics().getX() - coord.x) <= 0.51f) {
                        player.getUnitGraphics().setX(coord.x);
                        i--;
                    }
                }

                if (!MathUtils.isEqual(player.getUnitGraphics().getY(), coord.y)) {
                    i++;
                    if (player.getUnitGraphics().getY() < coord.y) {
                        player.getUnitGraphics().setY(player.getUnitGraphics().getY() + 0.5f);
                    } else {
                        player.getUnitGraphics().setY(player.getUnitGraphics().getY() - 0.5f);
                    }
                    if (Math.abs(player.getUnitGraphics().getY() - coord.y) <= 0.51f) {
                        player.getUnitGraphics().setY(coord.y);
                        i--;
                    }
                }
                if (i == 0) {
                    logger.info("target removed {} {}- {} {}", player.getUnitGraphics().getX(), player.getUnitGraphics().getY(), coord.x, coord.y);
                    toDel.add(player);
                }
                player.getUnitGraphics().run(time);
            } else {
                player.getUnitGraphics().stay(time);
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
        refresh(Gdx.graphics.getDeltaTime());
        float tx = table.getX(), ty = table.getY();
        table.setPosition(tx + offsetX, ty + offsetY);
        table.draw(batch, parentAlpha);
        table.setPosition(tx, ty);
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
