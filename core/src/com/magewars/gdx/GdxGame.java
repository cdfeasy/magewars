package com.magewars.gdx;

import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.Game;
import com.magewars.gdx.screens.battle.BattleScreen;
import com.magewars.gdx.screens.global.GlobalScreen;
import com.magewars.gdx.screens.loading.LoadingScreen;

public class GdxGame extends Game {
    FitViewport viewport;
    com.magewars.gdx.screens.loading.LoadingScreen loadingScreen;
    com.magewars.gdx.screens.battle.BattleScreen battleScreen;
    GlobalScreen globalScreen;
    GameAssetManager manager;



    @Override
    public void create() {
        viewport = new FitViewport(640, 480);
        manager=new GameAssetManager();
        loadingScreen = new LoadingScreen(viewport, this);
        battleScreen = new BattleScreen(viewport, this);
        globalScreen=new GlobalScreen(viewport,this);

        screen = loadingScreen;
        screen.show();
    }

    public void gotoBattle() {
        screen = battleScreen;
        screen.show();
    }

    public void gotoGlobal() {
        screen = globalScreen;
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
