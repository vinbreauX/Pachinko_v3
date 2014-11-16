package com.paranoidalien.prototype.pachinko3.main;

/* MASTER */

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.paranoidalien.prototype.pachinko3.main.screens.MenuScreen;

public class PachinkoGame extends Game {

    public static final String TITLE = "Pachinko 3";
    public static final int WIDTH = 480;
    public static final int HEIGHT = 800;

    public SpriteBatch batch;
    public BitmapFont titleFont;
    public BitmapFont bodyFont;

    private FreeTypeFontGenerator.FreeTypeFontParameter parameter;

    @Override
    public void create() {
        batch = new SpriteBatch();

        createFonts();

        this.setScreen(new MenuScreen(this));
    }

    private void createFonts() {
        FileHandle fontFile = Gdx.files.internal("fonts/journey.ttf");
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(fontFile);
        titleFont = generator.generateFont(64);
        bodyFont = generator.generateFont(32);
        generator.dispose();
    }

    public void render() { super.render(); }

    public void dispose() {
        batch.dispose();
        titleFont.dispose();
    }

}
