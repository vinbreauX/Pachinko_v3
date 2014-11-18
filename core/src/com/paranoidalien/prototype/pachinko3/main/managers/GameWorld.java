package com.paranoidalien.prototype.pachinko3.main.managers;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.paranoidalien.prototype.pachinko3.main.screens.GameScreen;

/**
 * Project: Pachinko_3
 * Created by Vin on 18 11 2014 at 2:59 PM.
 */

public class GameWorld {

    // set up actual viewport size of the game in meters
    public static float UNIT_WIDTH = GameScreen.SCREEN_WIDTH / 160;     // 3 meters wide
    public static float UNIT_HEIGHT = GameScreen.SCREEN_HEIGHT / 160;   // 50 meters tall

    public static final Vector2 GRAVITY = new Vector2(0, -9.8f);

    public final Stage stage;   // stage containing game actors, not GUI elements
    public World box2dWorld;    // box2d world

    private Viewport viewport;

    public GameWorld() {
        box2dWorld = new World(GRAVITY, true);
        viewport = new ExtendViewport(UNIT_WIDTH, UNIT_HEIGHT);

        stage = new Stage();    // create the game stage
        stage.setViewport(viewport);

        createWorld();
    }

    private void createWorld() {

        // create box2d bodies and the respective actors here.
        // EXAMPLE:
        // bob = new Bob(this);
        // stage.addActor(bob)

        // Add more actor elements here
    }

    public void update(float delta) {

        // perform game logic here
        box2dWorld.step(delta, 3, 3);   // update the box2d world
        stage.act(delta);               // update the game stage
    }

}
