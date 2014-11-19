package com.paranoidalien.prototype.pachinko3.main.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.Align;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Scaling;
import com.paranoidalien.prototype.pachinko3.main.managers.GameVars;
import com.paranoidalien.prototype.pachinko3.main.managers.GameWorld;

/**
 * Project: Pachinko_3
 * Created by Vin on 16 11 2014 at 8:39 PM.
 */

public class GameBall extends Image {

    public static final float RADIUS = 1;

    public Texture texture;
    public final Body body;

    public GameBall(GameWorld world, float xPos, float yPos) {

        // load the ball graphic
        texture = new Texture(Gdx.files.internal("graphics/GameBall.png"));
        this.setDrawable(new TextureRegionDrawable(new TextureRegion(texture, 50, 500, 32, 32)));

        // generate the ball's box2d body
        CircleShape circle = new CircleShape();
        circle.setRadius(RADIUS);

        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        bodyDef.position.x = 2f;
        bodyDef.position.y = 2f;
        bodyDef.linearDamping = 0.1f;
        bodyDef.angularDamping = 0.5f;

        this.body = world.box2dWorld.createBody(bodyDef);
        this.body.setUserData("ball");

        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = circle;
        fixtureDef.filter.categoryBits = GameVars.BIT_BALL;
        fixtureDef.filter.maskBits = GameVars.BIT_WALLS | GameVars.BIT_BALL;
        fixtureDef.restitution = 0.8f;
        fixtureDef.density = 0.9f;
        fixtureDef.friction = 0.6f;

        circle.dispose();

        // generate the ball's actor
        this.setPosition(body.getPosition().x - RADIUS, body.getPosition().y - RADIUS); // Set the actor position at the box2d body position
        this.setSize(RADIUS * 2, RADIUS * 2);           // scale the actor to the body's size
        this.setScaling(Scaling.stretch);           // stretch the texture
        this.setAlign(Align.center);
    }

    @Override
    public void act(float delta) {
        // here we override Actor's act() method to make the actor follow the box2d body
        super.act(delta);
        setOrigin(RADIUS, RADIUS);
        setRotation(MathUtils.radiansToDegrees * body.getAngle());
        setPosition(body.getPosition().x - RADIUS, body.getPosition().y - RADIUS);
    }

}
