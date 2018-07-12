package com.magewars.gdx;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.FitViewport;

public class GameAssetManager {
    Skin floorAtlas;
    Skin playerAtlas;
    Skin effectAtlas;
    Animation knightRun;
    Animation knightStay;
    Animation knightHit;
    Animation knightDead;

    Animation arrow;
    Animation arrow1;
    private AssetManager manager=new AssetManager();
    private TextureRegion getScaled(String name){
        Pixmap pixmap512 = new Pixmap(Gdx.files.internal(name));
        Pixmap pixmap64 = new Pixmap(64, 64, pixmap512.getFormat());
        pixmap64.drawPixmap(pixmap512,
                0, 0, pixmap512.getWidth(), pixmap512.getHeight(),
                0, 0, pixmap64.getWidth(), pixmap64.getHeight()
        );
        Texture texture = new Texture(pixmap64);
        pixmap512.dispose();
        pixmap64.dispose();
        return new TextureRegion(texture);

    }

    public  GameAssetManager() {
        TextureRegion[] frames = new TextureRegion[10];
        for (int i = 0; i < 10; i++) {
            frames[i]=getScaled("knight/Run/"+Integer.toString(i)+".png");
        }
        knightRun=new Animation<TextureRegion>(0.1f, frames);
        frames = new TextureRegion[10];
        for (int i = 0; i < 10; i++) {
            frames[i]=getScaled("knight/Stand/"+Integer.toString(i)+".png");
        }
        knightStay=new Animation<TextureRegion>(0.1f, frames);
        frames = new TextureRegion[10];
        for (int i = 0; i < 10; i++) {
            frames[i]=getScaled("knight/Hit/"+Integer.toString(i)+".png");
        }
        knightHit=new Animation<TextureRegion>(0.03f, frames);
        frames = new TextureRegion[10];
        for (int i = 0; i < 10; i++) {
            frames[i]=getScaled("knight/Die/"+Integer.toString(i)+".png");
        }
        knightDead=new Animation<TextureRegion>(0.03f, frames);

        manager.load("floor-atlas/floor.atlas",TextureAtlas.class);
        manager.load("player-atlas/player.atlas",TextureAtlas.class);
        manager.load("effect-atlas/effect.atlas",TextureAtlas.class);
        manager.update(1000);
        floorAtlas = new Skin(manager.get("floor-atlas/floor.atlas",TextureAtlas.class));
        playerAtlas = new Skin(manager.get("player-atlas/player.atlas",TextureAtlas.class));
        effectAtlas = new Skin(manager.get("effect-atlas/effect.atlas",TextureAtlas.class));

        Array<TextureRegion> arrowReg = effectAtlas.getRegions("arrow");
        Array<TextureRegion> arrayReg1=new Array<>(3);
        arrayReg1.add(arrowReg.get(1));
        arrayReg1.add(arrowReg.get(2));
        arrayReg1.add(arrowReg.get(3));
        arrow=new Animation<>(0.04f, arrowReg);
        arrow1=new Animation<>(1f, arrayReg1);
    }

    public Animation getKnightRun() {
        return knightRun;
    }

    public Animation getKnightStay() {
        return knightStay;
    }

    public Animation getKnightHit() {
        return knightHit;
    }

    public Animation getKnightDead() {
        return knightDead;
    }

    public Skin getFloorAtlas(){
        return floorAtlas;
    }

    public Skin getPlayerAtlas() {
        return playerAtlas;
    }

    public Skin getEffectAtlas() {
        return effectAtlas;
    }

    public Animation getArrow() {
        return arrow;
    }

    public Animation getArrow1() {
        return arrow1;
    }
}
