package com.magewars.gdx.screens.global;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.magewars.gdx.GdxGame;
import com.magewars.gdx.screens.battle.BattleStage;

public class GlobalScreen extends ScreenAdapter {
    Viewport viewport;
    private GdxGame gdxGame;
    private GlobalStage globalStage;


    public GlobalScreen(Viewport viewport, GdxGame gdxGame) {
        this.viewport = viewport;
        this.gdxGame = gdxGame;
        this.globalStage = new GlobalStage(viewport, gdxGame);
    }

    @Override
    public void render(float delta) {
        //Gdx.gl.glClearColor(0f, 0f, 0f, 0f);
       // Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        globalStage.act(delta);
        globalStage.draw();

    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(globalStage);
    }

    public void resize(int width, int height) {
        viewport.update(width, height);
    }
}