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
import com.badlogic.gdx.utils.viewport.Viewport;
import com.paranoidalien.prototype.pachinko3.main.PachinkoGame;
import com.paranoidalien.prototype.pachinko3.main.managers.GameRenderer;
import com.paranoidalien.prototype.pachinko3.main.managers.GameWorld;

/**
 * Project: Pachinko_3
 * Created by Vin on 16 11 2014 at 2:13 PM.
 */

public class GameScreen implements Screen {

    final PachinkoGame GAME;

    private Stage guiStage;
    private GameWorld world;
    private GameRenderer renderer;
    private OrthographicCamera guiCamera;
    private Viewport viewport;

    public static final int SCREEN_WIDTH = 480;
    public static final int SCREEN_HEIGHT = 800;


    public GameScreen(final PachinkoGame g) {
        this.GAME = g;
        this.viewport = new ExtendViewport(SCREEN_WIDTH, SCREEN_HEIGHT);

        this.guiStage = new Stage();
        this.guiStage.setViewport(viewport);

        guiCamera = (OrthographicCamera) guiStage.getCamera();
        world = new GameWorld();
        renderer = new GameRenderer(world);

        // add GUI actors to stage here
    }

    @Override
    public void show() {


    }

    @Override
    public void render(float delta) {

        guiCamera.position.set(SCREEN_WIDTH / 2, SCREEN_HEIGHT / 2, 0);

        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        guiCamera.update();

        handleInput();

        world.update(delta);    // update the box2D world
        guiStage.act(delta);    // update the GUI

        renderer.render();      // draw the box2d world
        guiStage.draw();        // draw the GUI
    }

    public void handleInput() {
        if (Gdx.input.justTouched()) {
            GAME.musicBox.playMouseClickAlt();
        }
    }

    @Override
    public void resize(int width, int height) {
        //viewport.update(width, height);
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
        guiStage.dispose();
    }


    public class BackgroundImage extends Actor {
        Texture texture = new Texture(Gdx.files.internal("backgrounds/PopbotPinkBG.png"));

        @Override
        public void draw(Batch batch, float alpha) {
            batch.draw(texture, 0, 0);
        }
    }

}
