package com.magewars.gdx;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.*;
import com.badlogic.gdx.scenes.scene2d.actions.MoveByAction;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Stack;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.Value;
import com.badlogic.gdx.utils.Scaling;

public class BattleTileView  extends Table {
    public BattleTileView(GdxGame gdxGame){
       // debug();
        setFillParent(true);
        pad(new Value.Fixed(1f));
        defaults().space(new Value.Fixed(1f)).fill();

        //  stageLayout.defaults().space(new Value.Fixed(1f));
        // stageLayout.row();
        row().expand();
        Stack stack=new Stack(new Image(gdxGame.getFloorAtlas().getTiledDrawable("cobble_blood_10_new")),new Image(gdxGame.getFloorAtlas().getDrawable("sand_1"), Scaling.none));
        //add(new Image(gdxGame.getFloorAtlas().getTiledDrawable("cobble_blood_10_new")));
       // add(new Image(gdxGame.getFloorAtlas().getTiledDrawable("cobble_blood_3_new")));
        add(stack);
        add(new Image(gdxGame.getFloorAtlas().getTiledDrawable("crypt_10")));
        add(new Image(gdxGame.getFloorAtlas().getTiledDrawable("marble_floor_1")));
        add(new Image(gdxGame.getFloorAtlas().getTiledDrawable("swamp_1_new")));
        add(new Image(gdxGame.getFloorAtlas().getTiledDrawable("cobble_blood_3_new")));
    }
}
