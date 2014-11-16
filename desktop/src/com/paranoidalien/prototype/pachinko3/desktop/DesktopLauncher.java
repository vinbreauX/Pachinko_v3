package com.paranoidalien.prototype.pachinko3.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.paranoidalien.prototype.pachinko3.main.PachinkoGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();

        config.title = PachinkoGame.TITLE;
        config.width = PachinkoGame.WIDTH;
        config.height = PachinkoGame.HEIGHT;
        config.resizable = false;

		new LwjglApplication(new PachinkoGame(), config);
	}
}
