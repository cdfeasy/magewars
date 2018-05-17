package com.magewars.gdx;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.*;
import com.badlogic.gdx.scenes.scene2d.actions.MoveByAction;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.Scaling;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BattleTileView extends Widget {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private Table table;
    private Image player;
    public BattleTileView(GdxGame gdxGame, float x, float y, float width, float height ) {
        // debug();
        setX(x);
        setY(y);
        setHeight(height);
        setWidth(width);
        setFillParent(true);
        table = new Table();
        Skin skin = new Skin(Gdx.files.internal("skin/craftacular-ui.json"));
        debug();


        addListener(new InputListener(){
            @Override
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
//                outputLabel.setText("Press a Button");
                logger.info("table x {}, y {}", x,y);
            }
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
        });

//        Tree tree=new Tree(skin);
//
//        final Tree.Node n1 = new Tree.Node(new Image(gdxGame.getFloorAtlas().getTiledDrawable("cobble_blood_10_new")));
//        final Tree.Node n2 = new Tree.Node(new Image(gdxGame.getFloorAtlas().getTiledDrawable("cobble_blood_3_new")));
//        final Tree.Node n3 = new Tree.Node(new Image(gdxGame.getFloorAtlas().getTiledDrawable("crypt_10")));
//        final Tree.Node n4 = new Tree.Node(new Image(gdxGame.getFloorAtlas().getTiledDrawable("marble_floor_1")));
//        final Tree.Node n5 = new Tree.Node(new Image(gdxGame.getFloorAtlas().getTiledDrawable("swamp_1_new")));
//        final Tree.Node n6 = new Tree.Node(new Image(gdxGame.getFloorAtlas().getTiledDrawable("cobble_blood_3_new")));
//
//        tree.add(n1);
//        tree.add(n2);
//        tree.add(n3);
//        tree.add(n4);
//        tree.add(n5);
//        tree.add(n6);

        table.pad(new Value.Fixed(1f));
        table.defaults().space(new Value.Fixed(1f)).fill();

        //  stageLayout.defaults().space(new Value.Fixed(1f));
        // stageLayout.row();
        table.row().expand();
        //  Stack stack=new Stack(new Image(gdxGame.getFloorAtlas().getTiledDrawable("cobble_blood_10_new")),new Image(gdxGame.getFloorAtlas().getDrawable("sand_1"), Scaling.none));
        table.add(new Image(gdxGame.getFloorAtlas().getTiledDrawable("cobble_blood_10_new")));
        table.add(new Image(gdxGame.getFloorAtlas().getTiledDrawable("cobble_blood_3_new")));
        // add(stack);
        table.add(new Image(gdxGame.getFloorAtlas().getTiledDrawable("crypt_10")));
        table.add(new Image(gdxGame.getFloorAtlas().getTiledDrawable("marble_floor_1")));
        table.add(new Image(gdxGame.getFloorAtlas().getTiledDrawable("swamp_1_new")));
        table.add(new Image(gdxGame.getFloorAtlas().getTiledDrawable("cobble_blood_3_new")));

        table.setWidth(width);
        table.setHeight(height);
        table.setPosition(x,y);

        //add(table);
        player = new Image(gdxGame.getPlayerAtlas().getDrawable("base/minotaur_male"), Scaling.none);
        player.setFillParent(true);
        player.setPosition(x, y);

        // add(player1);
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
        table.draw(batch,parentAlpha);
        player.draw(batch,parentAlpha);
        super.draw(batch, parentAlpha);
    }

}
