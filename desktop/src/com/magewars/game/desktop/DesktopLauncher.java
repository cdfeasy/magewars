package com.magewars.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.magewars.gdx.GdxGame;

import java.awt.*;

public class DesktopLauncher {
	public static void main (String[] arg) {
		System.setProperty("org.lwjgl.opengl.Display.allowSoftwareOpenGL", "true");
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();

		config.width=1366;
		config.height=768;

		new LwjglApplication(new GdxGame(), config);
	}
}
