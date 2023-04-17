package com.mygdx.tanks.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mygdx.tanks.Directions;

public class Bullet extends AbstractEntity {
    public Bullet(Sprite sprite,float x, float y,float speed, Directions dir) {
        super(sprite);
        setX(x);
        setY(y);
        setDirection(dir);

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
        //setPosition(getX() + velocity.x, getY() + velocity.y);
    }
}
