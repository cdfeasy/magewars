package com.magewars.gdx;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.*;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.utils.Scaling;
import com.badlogic.gdx.utils.viewport.Viewport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class LoadingStage extends Stage {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private Label label;
    private Image backgroundImage;
    private Table stageLayout;
    private GdxGame gdxGame;
    public LoadingStage(Viewport viewport, GdxGame gdxGame) {
        super(viewport);
        this.gdxGame=gdxGame;
        backgroundImage = new Image(new Texture("badlogic.jpg"));
        Image backgroundImage = new Image(new Texture("badlogic.jpg"));
        BitmapFont font=new BitmapFont();
        label=new Label("blabla1",new Label.LabelStyle(font, Color.RED));
    //   label.setPosition(0,0);
       // backgroundImage.setScaling(Scaling.fill);


        Skin skin = new Skin(Gdx.files.internal("skin/craftacular-ui.json"));
        Button button = new TextButton("Button1", skin,"default");
//        button.addListener(new EventListener() {
//            @Override
//            public boolean handle(Event event) {
//                logger.info("{}",event);
//                return false;
//            }
//        });
        button.addListener(new InputListener(){
            @Override
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
//                outputLabel.setText("Press a Button");
                logger.info("Press a Button");
            }
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                logger.info("Pressed Button");
                gdxGame.gotoBattle();
                gdxGame.render();

                return true;
            }
        });

        stageLayout=new Table();
        stageLayout.debug();
      //  stageLayout.setScaleX(100f);
        stageLayout.setFillParent(true);
     //   stageLayout.pad(Value.percentHeight(90));
        stageLayout.defaults().expand().space(new Value.Fixed(1f));

        stageLayout.row().height(Value.percentHeight(0.6f,stageLayout)).width(Value.percentWidth(1f,stageLayout));
        stageLayout.add(backgroundImage).fill().top();
        stageLayout.row();
        stageLayout.add(label).expand().left();
        stageLayout.row();
        stageLayout.add(button);


        addActor(stageLayout);

    }


}
