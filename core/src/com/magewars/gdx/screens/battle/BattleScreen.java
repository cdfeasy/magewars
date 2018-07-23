package com.magewars.gdx.screens.battle;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.magewars.gdx.GdxGame;

public class BattleScreen extends ScreenAdapter {
    Viewport viewport;
    private GdxGame gdxGame;

    public BattleScreen(Viewport viewport,GdxGame gdxGame) {
        this.viewport = viewport;
        this.gdxGame=gdxGame;
        battleStage = new BattleStage(viewport,gdxGame);
    }

    private BattleStage battleStage;

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0f, 0f, 0f, 0f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        battleStage.act();
        battleStage.draw();
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(battleStage);
    }

    public void resize(int width, int height) {
        viewport.update(width, height);
    }
}
