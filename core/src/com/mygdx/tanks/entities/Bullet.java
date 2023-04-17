package com.mygdx.tanks.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mygdx.tanks.Directions;

public class Bullet extends AbstractEntity {
    private float speed;
    public Bullet(Sprite sprite,float x, float y,float speed, Directions dir) {
        super(sprite);
        setX(x);
        setY(y);
        setDirection(dir);
        this.speed = speed;

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
        if (getDirection() == Directions.north) {
            setY(getY() + speed);
        } else if (getDirection() == Directions.south) {
            setY(getY() - speed);
        } else if (getDirection() == Directions.east) {
            setX(getX() + speed);
        } else if (getDirection() == Directions.west) {
            setX(getX() - speed);
        } else if (getDirection() == Directions.northEast) {
            setX(getX() + speed);
            setY(getY() + speed);
        } else if (getDirection() == Directions.northWest) {
            setX(getX() - speed);
            setY(getY() + speed);
        } else if (getDirection() == Directions.southEast) {
            setX(getX() + speed);
            setY(getY() - speed);
        } else if (getDirection() == Directions.southWest) {
            setX(getX() - speed);
            setY(getY() - speed);
        }
    }
    
}
