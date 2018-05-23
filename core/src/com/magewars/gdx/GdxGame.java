package com.magewars.gdx;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.Game;

public class GdxGame extends Game {
    FitViewport viewport;
    LoadingScreen loadingScreen;
    BattleScreen battleScreen;
    GameAssetManager manager;



    @Override
    public void create() {
        viewport = new FitViewport(640, 480);
        manager=new GameAssetManager();
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

    public GameAssetManager getManager() {
        return manager;
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
