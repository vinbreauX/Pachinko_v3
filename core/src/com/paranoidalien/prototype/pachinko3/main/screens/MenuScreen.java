package com.paranoidalien.prototype.pachinko3.main.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.paranoidalien.prototype.pachinko3.main.PachinkoGame;

/**
 * Project: Pachinko_3
 * Created by Vin on 15 11 2014 at 7:58 PM.
 */

public class MenuScreen implements Screen {

    final PachinkoGame GAME;

    private OrthographicCamera camera;
    private Viewport viewport;

    static final int W_WIDTH = 480;
    static final int W_HEIGHT = 800;

    public MenuScreen(final PachinkoGame gam) {
        GAME = gam;

        GAME.musicBox.playBGAmbient1();

        GAME.titleFont.setColor(0.9f, 0.5f, 0.2f, 1);
        GAME.bodyFont.setColor(0.7f, 0.3f, 0, 1);

        camera = new OrthographicCamera(W_WIDTH, W_HEIGHT);
        viewport = new FitViewport(480, 800, camera);
        camera.position.set(camera.viewportWidth / 2f, camera.viewportHeight / 2f, 0);
        camera.update();

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        handleInput();

        camera.update();
        GAME.batch.setProjectionMatrix(camera.combined);

        GAME.batch.begin();
        GAME.titleFont.draw(GAME.batch, GAME.TITLE, 5, (W_HEIGHT - GAME.titleFont.getScaleY()) - 10);
        GAME.bodyFont.draw(GAME.batch, "Click anywhere to play", 5, (W_HEIGHT - GAME.titleFont.getScaleY()) - 50);
        GAME.batch.end();

    }

    private void handleInput() {
        if (Gdx.input.isTouched()) {
            GAME.musicBox.stopBGAmbient1();
            GAME.musicBox.playMouseClick();

            GAME.setScreen(new GameScreen(GAME));

            dispose();
        }
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height);
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
