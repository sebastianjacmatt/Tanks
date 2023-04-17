package com.mygdx.tanks.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;

public class Bullet extends AbstractEntity {
    public Bullet(Sprite sprite,float x, float y, float rotation, Vector2 velocity) {
        super(sprite);
        setX(x);
        setY(y);
        setRotation(rotation);
        setVelocity(velocity);

    }
    @Override
    public void draw(Batch batch) {
        update(Gdx.graphics.getDeltaTime());
        super.draw(batch);
    }
    /**
     * A method that keep the bullet moving
     */
    public void update(float delta) {
        setPosition(getX() + getVelocity().x, getY() + getVelocity().y);
    }
}
