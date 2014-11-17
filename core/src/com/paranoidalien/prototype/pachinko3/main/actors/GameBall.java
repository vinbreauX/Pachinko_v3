package com.paranoidalien.prototype.pachinko3.main.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

/**
 * Project: Pachinko_3
 * Created by Vin on 16 11 2014 at 8:39 PM.
 */

public class GameBall extends Actor {

    Texture texture = new Texture(Gdx.files.internal("graphics/GameBall.png"));

    @Override
    public void draw(Batch batch, float alpha) {
        batch.draw(texture, 200, 400);
    }

}
