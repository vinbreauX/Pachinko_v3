package com.paranoidalien.prototype.pachinko3.main.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.paranoidalien.prototype.pachinko3.main.PachinkoGame;

/**
 * Project: Pachinko_3
 * Created by Vin on 15 11 2014 at 7:58 PM.
 */

public class MenuScreen implements Screen {

    final PachinkoGame GAME;

    private OrthographicCamera camera;

    private SpriteBatch batch;
    private Sprite bgSprite;
    private Texture bgTexture = new Texture(Gdx.files.internal("backgrounds/pachinkoBack_01.png"));

    static final int W_WIDTH = 30;
    static final int W_HEIGHT = 50;

    public MenuScreen(final PachinkoGame gam) {
        GAME = gam;

        batch = new SpriteBatch();

        camera = new OrthographicCamera(30, 50);
        camera.position.set(camera.viewportWidth / 2f, camera.viewportHeight / 2f, 0);
        camera.update();

        bgSprite = new Sprite(bgTexture);
        bgSprite.setSize(30, 50);
        bgSprite.setPosition(0, 0);

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        handleInput();

        camera.update();
        batch.setProjectionMatrix(camera.combined);

        batch.begin();
        bgSprite.draw(batch);
        batch.end();

    }

    private void handleInput() {

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
