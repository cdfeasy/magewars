package com.magewars.gdx.screens.global;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.magewars.game.MainGame;
import com.magewars.gdx.GdxGame;
import com.magewars.gdx.screens.battle.BattleTileView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.atomic.AtomicReference;

public class GlobalHeader extends Table {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private Container<WidgetGroup> centralPanel;
    private BattleTileView battleTileView;
    private GdxGame gdxGame;

    public GlobalHeader(GdxGame gdxGame, Viewport viewport) {
        Skin skin = new Skin(Gdx.files.internal("skin/craftacular-ui.json"));
        this.gdxGame=gdxGame;
        Button button2 = new TextButton("<-", skin, "small");
        button2.setWidth(200);
        button2.setHeight(20);
        AtomicReference<MainGame> ref = new AtomicReference<>();
        button2.addListener(new InputListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                gdxGame.gotoLoading();
                return true;
            }
        });
        add(button2);
        add().expand();
        this.battleTileView = battleTileView;
    }
}