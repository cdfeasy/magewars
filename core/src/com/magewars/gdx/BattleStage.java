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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BattleStage  extends Stage {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private Label label;
    private Image backgroundImage;
    private Table stageLayout;
    private GdxGame gdxGame;
    public BattleStage(Viewport viewport, GdxGame gdxGame) {
        super(viewport);
        this.gdxGame=gdxGame;
        backgroundImage = new Image(new Texture("badlogic.jpg"));
        Image backgroundImage = new Image(new Texture("badlogic.jpg"));
        BitmapFont font=new BitmapFont();
        label=new Label("blabla1",new Label.LabelStyle(font, Color.RED));


        Skin skin = new Skin(Gdx.files.internal("skin/craftacular-ui.json"));
        Button button = new TextButton("Button1", skin,"default");
        button.addListener(new InputListener(){
            @Override
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
//                outputLabel.setText("Press a Button");
                logger.info("Press a Button");
            }
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                logger.info("Pressed Button");
                gdxGame.gotoLoading();
                gdxGame.render();

                return true;
            }
        });
        Container footer =new Container<WidgetGroup>();
        footer.setActor(new BattleFooter(button));
        footer.fill();

        //TiledMapRenderer renderer=new

        Container field =new Container<WidgetGroup>();




        stageLayout=new Table();
        stageLayout.debug();
        //  stageLayout.setScaleX(100f);
        stageLayout.setFillParent(true);
        stageLayout.defaults().fill();

      //  stageLayout.defaults().space(new Value.Fixed(1f));
       // stageLayout.row();
        stageLayout.row().expand();
        stageLayout.add(field).left();
        BattleTileView battleField=new BattleTileView(gdxGame,0,100,viewport.getScreenWidth(), viewport.getScreenHeight()-100 );
        field.setActor(battleField);
        field.fill();


        stageLayout.row();
        stageLayout.add(footer).height(100f).expandX();

        addActor(stageLayout);
    }
}
