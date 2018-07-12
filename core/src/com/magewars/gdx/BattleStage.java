package com.magewars.gdx;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.TiledDrawable;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.magewars.game.MainGame;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicReference;

public class BattleStage extends Stage {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private Label label;
    private Image backgroundImage;
    private Table stageLayout;
    private GdxGame gdxGame;
    private UUID h=UUID.randomUUID();
    private AtomicReference<BattleTileView> battleField=new AtomicReference<>();

    public BattleStage(Viewport viewport, GdxGame gdxGame) {
        super(viewport);
        this.gdxGame = gdxGame;
        backgroundImage = new Image(new Texture("badlogic.jpg"));
        Image backgroundImage = new Image(new Texture("badlogic.jpg"));
        BitmapFont font = new BitmapFont();
        label = new Label("blabla1", new Label.LabelStyle(font, Color.RED));


        Skin skin = new Skin(Gdx.files.internal("skin/craftacular-ui.json"));
        Button button1 = new TextButton("Button12", skin, "default");
        Button button2 = new TextButton("Button2", skin, "default");
        battleField.set(new BattleTileView(gdxGame, 0, 100, viewport.getScreenWidth(), viewport.getScreenHeight() - 100));
        AtomicReference<MainGame> ref = new AtomicReference<>();
        button1.addListener(new InputListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                logger.info("Pressed Button");
                try {
                    MainGame mainGame = new MainGame();
                    ref.set(mainGame);
                    battleField.get().setBattleField(mainGame.getBattle().getBattleField());
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
                battleField.get().addEffect(ref.get().getBattle().getAttackers().getTeam().getUnits().get(0),ref.get().getBattle().getDefenders().getTeam().getUnits().get(0));
                battleField.get().refreshUnits();
                return true;
            }
        });


        Container footer = new Container<WidgetGroup>();
        footer.setActor(new BattleFooter(button1, button2));
        footer.fill();

        //TiledMapRenderer renderer=new

        Container field = new Container<WidgetGroup>();


        stageLayout = new Table();
        stageLayout.debug();
        //  stageLayout.setScaleX(100f);
        stageLayout.setFillParent(true);
        stageLayout.defaults().fill();

        //  stageLayout.defaults().space(new Value.Fixed(1f));
        // stageLayout.row();
        stageLayout.row().expand();
        stageLayout.add(field).left();
        field.setActor(battleField.get());
        field.fill();


        stageLayout.row();
        stageLayout.add(footer).height(100f).expandX();

        addActor(stageLayout);
    }
}
