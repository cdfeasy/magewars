package com.magewars.gdx;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Scaling;

public class UnitGraphics {
    private TextureRegion image;
    private float x,y;
    private boolean flipX,flipY;
    private float originX=0,originY=0;
    private float rotate;
    private float time=0;
    private GdxGame gdxGame;

    public UnitGraphics() {
    }

    public UnitGraphics(GdxGame gdxGame) {
        this.gdxGame = gdxGame;
        image=(TextureRegion) gdxGame.getKnightStay().getKeyFrame(time,true);
    }

    public void stay(float delta){
        time+=delta;
        image=(TextureRegion) gdxGame.getKnightStay().getKeyFrame(time,true);
    }

    public void run(float delta){
        time+=delta;
        image=(TextureRegion) gdxGame.getKnightRun().getKeyFrame(time,true);
    }

    public TextureRegion getImage() {
        return image;
    }

    public void setImage(TextureRegion image) {
        this.image = image;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public void setPosition(float x,float y){
        this.x=x;
        this.y=y;
    }

    public boolean isFlipX() {
        return flipX;
    }

    public void setFlipX(boolean flipX) {
        this.flipX = flipX;
    }

    public boolean isFlipY() {
        return flipY;
    }

    public void setFlipY(boolean flipY) {
        this.flipY = flipY;
    }

    public float getRotate() {
        return rotate;
    }

    public void setRotate(float rotate) {
        this.rotate = rotate;
    }

    public float getOriginX() {
        return originX;
    }

    public void setOriginX(float originX) {
        this.originX = originX;
    }

    public float getOriginY() {
        return originY;
    }

    public void setOriginY(float originY) {
        this.originY = originY;
    }
}
