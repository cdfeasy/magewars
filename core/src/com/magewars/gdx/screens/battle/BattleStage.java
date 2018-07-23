package com.magewars.gdx.screens.battle;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.magewars.gdx.GdxGame;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.UUID;

public class BattleStage extends Stage {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private Label label;
    private Image backgroundImage;
    private Table stageLayout;
    private GdxGame gdxGame;
    private UUID h = UUID.randomUUID();
    //private AtomicReference<BattleTileView> battleField = new AtomicReference<>();

    public BattleStage(Viewport viewport, GdxGame gdxGame) {
        super(viewport);
        this.gdxGame = gdxGame;
        backgroundImage = new Image(new Texture("badlogic.jpg"));
        BitmapFont font = new BitmapFont();
        label = new Label("blabla1", new Label.LabelStyle(font, Color.RED));


        Skin skin = new Skin(Gdx.files.internal("skin/craftacular-ui.json"));
        final BattleTileView battleField=new BattleTileView(gdxGame,viewport.getScreenWidth(), viewport.getScreenHeight() - 150);

        BattleHeader battleHeader = new BattleHeader(battleField, gdxGame, viewport);
        Container header = new Container<WidgetGroup>();
        header.setActor(battleHeader);
        header.fill();


        BattleFooter battleFooter = new BattleFooter(battleField, gdxGame, viewport);
        Container footer = new Container<WidgetGroup>();
        footer.setActor(battleFooter);
        footer.fill();

        stageLayout = new Table();
        stageLayout.debug();
     //   stageLayout.setScaleX(100f);
        stageLayout.setFillParent(true);
        stageLayout.defaults().fill();

        stageLayout.row();
        stageLayout.add(header).height(50f).expandX();


        Container field = new Container<WidgetGroup>();
        stageLayout.row().expand();
        stageLayout.add(field).left();
        field.setActor(battleField);
        field.fill();

        stageLayout.row();
        stageLayout.add(footer).height(100f).expandX();

        addActor(stageLayout);
    }
}
