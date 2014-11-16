package com.paranoidalien.prototype.pachinko3.main;

/* MASTER */

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.paranoidalien.prototype.pachinko3.main.screens.MenuScreen;

public class PachinkoGame extends Game {

    public static final String TITLE = "Pachinko 3";
    public static final int WIDTH = 480;
    public static final int HEIGHT = 800;

    private SpriteBatch batch;
    public static BitmapFont font24;

    @Override
    public void create() {
        batch = new SpriteBatch();
        font24 = new BitmapFont(Gdx.files.internal("fonts/pixelGosub_24.fnt"), false);
        this.setScreen(new MenuScreen(this));
    }

    public void render() { super.render(); }

    public void dispose() {
        batch.dispose();
        font24.dispose();
    }

}
