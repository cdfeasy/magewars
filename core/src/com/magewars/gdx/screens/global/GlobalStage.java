package com.magewars.gdx.screens.global;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.IsometricTiledMapRenderer;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.*;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.utils.Pools;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.magewars.gdx.GdxGame;
import com.magewars.gdx.screens.battle.BattleFooter;
import com.magewars.gdx.screens.battle.BattleHeader;
import com.magewars.gdx.screens.battle.BattleTileView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.UUID;

public class GlobalStage extends Stage {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private Image backgroundImage;
    private Table stageLayout;
    private GdxGame gdxGame;
    private OrthographicCamera camera1;
    private TiledMap tiledMap;
    private OrthogonalTiledMapRenderer tiledMapRenderer;
    private float scale = 1;
    //private AtomicReference<BattleTileView> battleField = new AtomicReference<>();

    public GlobalStage(Viewport viewport, GdxGame gdxGame) {
        tiledMap = new TmxMapLoader().load("map/test3.tmx");

        float unitScale = 1 / 1f;
        tiledMapRenderer = new OrthogonalTiledMapRenderer(tiledMap, unitScale);
        GlobalFooter battleFooter = new GlobalFooter(gdxGame, viewport);
        Container footer = new Container<WidgetGroup>();
        footer.setActor(battleFooter);
        footer.fill();

        GlobalHeader globalHeader = new GlobalHeader(gdxGame, viewport);
        Container header = new Container<WidgetGroup>();
        header.setActor(globalHeader);
        header.fill();

        camera1 = new OrthographicCamera(viewport.getScreenWidth(), viewport.getScreenHeight());
        camera1.setToOrtho(false);
        camera1.position.x = ((Integer) tiledMap.getProperties().get("width") * (Integer) tiledMap.getProperties().get("tilewidth")) / 2f * unitScale;
        camera1.position.y = ((Integer) tiledMap.getProperties().get("height") * (Integer) tiledMap.getProperties().get("tileheight")) / 2f * unitScale;
        camera1.update();

        // camera1.setToOrtho(false,30,20);
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
        stageLayout.add(header).height(50f).expandX();

        // stageLayout.row();
//        stageLayout.add(header).height(50f).expandX();
        stageLayout.row();
        stageLayout.add().expand();

        stageLayout.row().bottom();
        stageLayout.add(footer).height(50f).expandX();
        //  ((OrthographicCamera) getCamera()).setToOrtho(false,10,10);
        addActor(stageLayout);
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
    public void act(float delta) {
        super.act(delta);

        tiledMapRenderer.setView((OrthographicCamera) camera1);
        tiledMapRenderer.render();
        //camera1.update();
        // super.act(delta);
    }

    public void draw() {
        super.draw();
        camera1.update();
    }


    /**
     * Applies a touch down event to the stage and returns true if an actor in the scene {@link Event#handle() handled} the
     * event.
     */
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        //camera1.update();
        super.touchDown(screenX, screenY, pointer, button);
        float unitScale = 1 / scale;
        float posX = screenX;
        float posY = screenY;
        Vector3 unproject = camera1.unproject(new Vector3(posX, posY, 0f));
        float x = (unproject.x / unitScale) / (Integer) tiledMap.getProperties().get("tilewidth");
        float y = (unproject.y / unitScale) / (Integer) tiledMap.getProperties().get("tileheight");
        System.out.println((int) x + "//" + (int) y);
        System.out.println(unproject.x + "///" + unproject.y);

        return true;
    }


    @Override
    public boolean keyDown(int keycode) {
        super.keyDown(keycode);
        System.out.println(keycode);
        if (keycode == Input.Keys.LEFT)
            camera1.translate(-32f, 0f, 0f);
        if (keycode == Input.Keys.RIGHT)
            camera1.translate(32f, 0f, 0f);
        if (keycode == Input.Keys.UP)
            camera1.translate(0, 32f, 0f);
        if (keycode == Input.Keys.DOWN)
            camera1.translate(0, -32f, 0f);
        if (keycode == Input.Keys.PLUS || keycode == Input.Keys.EQUALS) {
            if (scale > 0) {
                float unitScale = 1 / scale;
                float posX = camera1.position.x / unitScale;
                float posY = camera1.position.y / unitScale;
                if (scale > 1)
                    scale--;
                else {
                    scale = scale / 2;
                }
                unitScale = 1 / scale;

                camera1.position.x = posX * unitScale;
                camera1.position.y = posY * unitScale;
                tiledMapRenderer = new OrthogonalTiledMapRenderer(tiledMap, unitScale);
            }
        }
        if (keycode == Input.Keys.MINUS) {
            if (scale < 16) {
                float unitScale = 1 / scale;
                float posX = camera1.position.x / unitScale;
                float posY = camera1.position.y / unitScale;
                if (scale >= 1)
                    scale++;
                else {
                    scale = 1;
                }
                unitScale = 1 / scale;
                camera1.position.x = posX * unitScale;
                camera1.position.y = posY * unitScale;
                tiledMapRenderer = new OrthogonalTiledMapRenderer(tiledMap, unitScale);
            }
        }
        System.out.println(camera1.position.x + "/" + camera1.position.y);
//        if(keycode == Input.Keys.NUM_1)
//            tiledMap.getLayers().get(0).setVisible(!tiledMap.getLayers().get(0).isVisible());
//        if(keycode == Input.Keys.NUM_2)
//            tiledMap.getLayers().get(1).setVisible(!tiledMap.getLayers().get(1).isVisible());
        return false;
    }

}
