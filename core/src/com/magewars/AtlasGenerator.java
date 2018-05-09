package com.magewars;

import com.badlogic.gdx.tools.texturepacker.TexturePacker;

public class AtlasGenerator {
    public static void main(String[] args){
        TexturePacker.Settings settings = new TexturePacker.Settings();
        settings.useIndexes=false;
        settings.maxWidth = 4096;
        settings.maxHeight = 4096;
        TexturePacker.process(settings, "android/assets/floor", "android/assets/floor-atlas", "floor");
    }
}
