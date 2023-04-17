package com.mygdx.tanks.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.tanks.Directions;

public class Bullet extends AbstractEntity {
    private Vector2 velocity;
    public Bullet(Sprite sprite,float x, float y,Vector2 velocity, Directions dir) {
        super(sprite);
        setX(x);
        setY(y);
        setDirection(dir);
        this.velocity = velocity;

        //TODO : remove debugging
        setScale(4, 4);
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
        setX(getX() + velocity.x * delta);
        setY(getY() + velocity.y * delta);
    }
}
