package com.paranoidalien.prototype.pachinko3.main.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.paranoidalien.prototype.pachinko3.main.PachinkoGame;

/**
 * Project: Pachinko_3
 * Created by Vin on 16 11 2014 at 2:13 PM.
 */

public class GameScreen implements Screen {

    final PachinkoGame GAME;

    public GameScreen(final PachinkoGame g) {
        this.GAME = g;
        GAME.musicBox.playBGAmbient2();
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        handleInput();
    }

    public void handleInput() {
        if (Gdx.input.justTouched()) {
            GAME.musicBox.playMouseClickAlt();
        }
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void show() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {

    }
}
