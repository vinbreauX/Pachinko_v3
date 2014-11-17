package com.paranoidalien.prototype.pachinko3.main.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.paranoidalien.prototype.pachinko3.main.PachinkoGame;
import com.paranoidalien.prototype.pachinko3.main.actors.GameBall;

/**
 * Project: Pachinko_3
 * Created by Vin on 16 11 2014 at 2:13 PM.
 */

public class GameScreen implements Screen {

    final PachinkoGame GAME;

    private OrthographicCamera camera;
    private Viewport viewport;

    static final int W_WIDTH = 480;
    static final int W_HEIGHT = 800;

    public Stage gameStage;

    public GameScreen(final PachinkoGame g) {
        this.GAME = g;

        viewport = new FitViewport(480, 800, camera);

        GAME.musicBox.playBGAmbient2();

        camera = new OrthographicCamera(W_WIDTH, W_HEIGHT);
        viewport = new ExtendViewport(W_WIDTH, W_HEIGHT, camera);
        camera.position.set(camera.viewportWidth / 2f, camera.viewportHeight / 2f, 0);

        gameStage = new Stage(viewport);

        BackgroundImage backgroundImage = new BackgroundImage();

        GameBall gameBall = new GameBall();

        gameStage.addActor(backgroundImage);
        gameStage.addActor(gameBall);

        camera.update();
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        handleInput();

        camera.update();

        gameStage.draw();
    }

    public void handleInput() {
        if (Gdx.input.justTouched()) {
            GAME.musicBox.playMouseClickAlt();
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
        gameStage.dispose();
    }

    public class BackgroundImage extends Actor {
        Texture texture = new Texture(Gdx.files.internal("backgrounds/PopbotPinkBG.png"));

        @Override
        public  void draw(Batch batch, float alpha) {
            batch.draw(texture, 0, 0);
        }
    }

}
