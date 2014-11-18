package com.paranoidalien.prototype.pachinko3.main.managers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;

/**
 * Project: Pachinko_3
 * Created by Vin on 18 11 2014 at 3:26 PM.
 */

public class GameRenderer {

    GameWorld world;
    OrthographicCamera camera;
    Box2DDebugRenderer renderer;

    public GameRenderer(GameWorld world) {
        this.world = world;
        this.renderer = new Box2DDebugRenderer();

        // we obtain a reference to the game stage camera. The camera is scaled to box2d meter units
        this.camera = (OrthographicCamera) world.stage.getCamera();

        // Camera centering, etc would go here next
    }

    public void render() {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // box2d debug rendering (optional)
        camera.update();
        renderer.render(world.box2dWorld, camera.combined);

        // game stage rendering
        world.stage.draw();
    }

}
