package com.magewars.gdx.screens.loading;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.magewars.gdx.GdxGame;

public class LoadingScreen extends ScreenAdapter {
    Viewport viewport;
    private GdxGame gdxGame;

    public LoadingScreen(Viewport viewport, GdxGame gdxGame) {
        this.viewport = viewport;
        this.gdxGame = gdxGame;
        loadingStage = new LoadingStage(viewport,gdxGame);
    }


    private LoadingStage loadingStage;

    @Override
    public void show() {
        Gdx.input.setInputProcessor(loadingStage);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0f, 0f, 0f, 0f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        loadingStage.act();
        loadingStage.draw();
    }

    public void resize(int width, int height) {
        viewport.update(width, height);
    }
}
