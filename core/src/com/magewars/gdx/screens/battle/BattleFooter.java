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

import java.io.IOException;
import java.util.concurrent.atomic.AtomicReference;

public class BattleFooter extends Table {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    Container<WidgetGroup> centralPanel;
    Button button1, button2;
    BattleTileView battleTileView;

    public BattleFooter(BattleTileView battleField, GdxGame gdxGame, Viewport viewport) {
        Skin skin = new Skin(Gdx.files.internal("skin/craftacular-ui.json"));
        Button button1 = new TextButton("Button12", skin, "default");
        Button button2 = new TextButton("Button2", skin, "default");
        AtomicReference<MainGame> ref = new AtomicReference<>();
        button1.addListener(new InputListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                logger.info("Pressed Button");
                try {
                    MainGame mainGame = new MainGame();
                    ref.set(mainGame);
                    battleField.setBattleField(mainGame.getBattle().getBattleField());
                } catch (IOException e) {

                }
                return true;
            }
        });
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

        row();
        add(button1);
        add(button2);
        this.button1 = button1;
        this.button2 = button2;
        this.battleTileView = battleTileView;
    }
}
