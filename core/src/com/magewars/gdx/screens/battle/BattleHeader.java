package com.magewars.gdx.screens.battle;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.magewars.game.MainGame;
import com.magewars.gdx.GdxGame;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.atomic.AtomicReference;

public class BattleHeader extends Table {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    Container<WidgetGroup> centralPanel;
    BattleTileView battleTileView;

    public BattleHeader(BattleTileView battleField, GdxGame gdxGame, Viewport viewport) {
        Skin skin = new Skin(Gdx.files.internal("skin/craftacular-ui.json"));
        Button button2 = new TextButton("Button2", skin, "small");
        button2.setWidth(200);
        button2.setHeight(20);
        AtomicReference<MainGame> ref = new AtomicReference<>();
        button2.addListener(new InputListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                logger.info("Pressed Button2");
                //  ref.get().getBattle().processTurn();
                //    battleField.get().
                //   battleField.get().refreshTime(Gdx.graphics.getDeltaTime());
                battleField.addEffect(ref.get().getBattle().getAttackers().getTeam().getUnits().get(0), ref.get().getBattle().getDefenders().getTeam().getUnits().get(0));
                battleField.refreshUnits();
                return true;
            }
        });
        add(button2);
        add().expand();
        this.battleTileView = battleTileView;
    }
}
