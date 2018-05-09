package com.magewars.gdx;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.Game;

public class GdxGame extends Game {
    FitViewport viewport;
    LoadingScreen loadingScreen;
    BattleScreen battleScreen;
    Skin floorAtlas;
    Skin playerAtlas;
    Skin effectAtlas;


    @Override
    public void create() {
        floorAtlas = new Skin(new TextureAtlas(Gdx.files.internal("floor-atlas/floor.atlas")));
        playerAtlas = new Skin(new TextureAtlas(Gdx.files.internal("player-atlas/player.atlas")));
        effectAtlas = new Skin(new TextureAtlas(Gdx.files.internal("effect-atlas/effect.atlas")));
       // viewport = new FitViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        viewport = new FitViewport(640, 480);
        loadingScreen = new LoadingScreen(viewport, this);
        battleScreen = new BattleScreen(viewport, this);
        screen = loadingScreen;
        screen.show();
    }

    public void gotoBattle() {
        screen = battleScreen;
        screen.show();
    }

    public void gotoLoading() {
        screen = loadingScreen;
        screen.show();
    }

    public Skin getFloorAtlas(){
        return floorAtlas;
    }

    public Skin getPlayerAtlas() {
        return playerAtlas;
    }

    public Skin getEffectAtlas() {
        return effectAtlas;
    }
    //	@Override
//	public void render () {
//		Gdx.gl.glClearColor(1, 0, 0, 1);
//		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
//		batch.begin();
//		batch.draw(img, 0, 0);
//		batch.end();
//	}
//
//	@Override
//	public void dispose () {
//		batch.dispose();
//		img.dispose();
//	}
}
