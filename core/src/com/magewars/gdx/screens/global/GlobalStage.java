package com.magewars.gdx.screens.global;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.magewars.gdx.GdxGame;
import com.magewars.gdx.screens.battle.BattleFooter;
import com.magewars.gdx.screens.battle.BattleHeader;
import com.magewars.gdx.screens.battle.BattleTileView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.UUID;

public class GlobalStage extends Stage  {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private Image backgroundImage;
    private Table stageLayout;
    private GdxGame gdxGame;
    private OrthographicCamera camera;
    private TiledMap tiledMap;
    private TiledMapRenderer tiledMapRenderer;
    //private AtomicReference<BattleTileView> battleField = new AtomicReference<>();

    public GlobalStage(Viewport viewport, GdxGame gdxGame) {
     //   super(viewport);
        float w = Gdx.graphics.getWidth();
        float h = Gdx.graphics.getHeight();

        new OrthographicCamera();
       // camera.setToOrtho(false,w,h);
      //  camera.update();
        tiledMap = new TmxMapLoader().load("map/test3.tmx");
        tiledMapRenderer = new OrthogonalTiledMapRenderer(tiledMap);

        this.gdxGame = gdxGame;
        backgroundImage = new Image(new Texture("badlogic.jpg"));
        BitmapFont font = new BitmapFont();
        Skin skin = new Skin(Gdx.files.internal("skin/craftacular-ui.json"));
        stageLayout = new Table();
        stageLayout.debug();
        //   stageLayout.setScaleX(100f);
        stageLayout.setFillParent(true);
        stageLayout.defaults().fill();

        stageLayout.row();
//        stageLayout.add(header).height(50f).expandX();
        stageLayout.row();
       // addActor(stageLayout);
    }

//    @Override
//    public void render (float delta) {
//        Gdx.gl.glClearColor(1, 0, 0, 1);
//        Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
//        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
//        camera.update();
//        tiledMapRenderer.setView(camera);
//        tiledMapRenderer.render();
//    }


    @Override
    public void act (float delta) {
        super.act(delta);
        tiledMapRenderer.setView((OrthographicCamera) getCamera());
        tiledMapRenderer.render();
    }


    @Override
    public boolean keyDown(int keycode) {
        if(keycode == Input.Keys.LEFT)
            getCamera().translate(-32f,0f,0f);
        if(keycode == Input.Keys.RIGHT)
            getCamera().translate(32,0,0f);
        if(keycode == Input.Keys.UP)
            getCamera().translate(0,-32,0f);
        if(keycode == Input.Keys.DOWN)
            getCamera().translate(0,32,0f);
//        if(keycode == Input.Keys.NUM_1)
//            tiledMap.getLayers().get(0).setVisible(!tiledMap.getLayers().get(0).isVisible());
//        if(keycode == Input.Keys.NUM_2)
//            tiledMap.getLayers().get(1).setVisible(!tiledMap.getLayers().get(1).isVisible());
        return false;
    }

}
