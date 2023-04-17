package com.mygdx.tanks.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.tanks.Collidable;
import com.mygdx.tanks.Directions;

public abstract class AbstractEntity extends Sprite implements Collidable{
    private Vector2 velocity;
    private Sprite sprite;
    private Directions dir;
    private float speed;
    public AbstractEntity(Sprite sprite){
        super(sprite);
        this.sprite = sprite;
        dir = Directions.north;
        this.speed = 100f;
        this.velocity = new Vector2(0f,0f);

    }
    @Override
    public void draw(Batch batch) {
        update(Gdx.graphics.getDeltaTime());
        batch.draw(sprite, getX(), getY());
    }
    public void update(float delta){
        setPosition(getX() + velocity.x * delta, getY() + velocity.y * delta);
    }
    /**
     * A function to handle movement of entity, is left to inheriting entity to implement
     * TODO : Should maybe be an interface, movable
     */
    public void move(float deltaX, float deltaY) {
        if (deltaY > 0 && deltaX == 0) {
            dir = Directions.north;
            setVelocity(new Vector2(0 * getSpeed(), 1 * getSpeed()));
            super.setRotation(0);
        } else if (deltaX > 0 && deltaY == 0) {
            dir = Directions.east;
            setVelocity(new Vector2(1 * getSpeed(), 0 * getSpeed()));
            super.setRotation(270);
        } else if (deltaY < 0 && deltaX == 0) {
            dir = Directions.south;
            setVelocity(new Vector2(0 * getSpeed(), -1 * getSpeed()));
            super.setRotation(180);
        } else if (deltaX < 0 && deltaY == 0) {
            dir = Directions.west;
            setVelocity(new Vector2(-1 * getSpeed(), 0 * getSpeed()));
            super.setRotation(90);
        } else if (deltaX > 0 && deltaY > 0) {
            dir = Directions.northEast;
            setVelocity(new Vector2(1 * getSpeed(), 1 * getSpeed()));
            super.setRotation(315);
        } else if (deltaX > 0 && deltaY < 0) {
            dir = Directions.southEast;
            setVelocity(new Vector2(1 * getSpeed(), -1 * getSpeed()));
            super.setRotation(225);
        } else if (deltaX < 0 && deltaY < 0) {
            dir = Directions.southWest;
            setVelocity(new Vector2(-1 * getSpeed(), -1 * getSpeed()));
            super.setRotation(135);
        } else if (deltaX < 0 && deltaY > 0) {
            dir = Directions.northWest;
            setVelocity(new Vector2(-1 * getSpeed(), 1 * getSpeed()));
            super.setRotation(45);
        } else {
            dir = Directions.idle;
            setVelocity(new Vector2(0, 0));
        }
    }
    public float getSpeed(){
        return speed;
    }
    public void setSpeed(float speed) {
        this.speed = speed;
    }
    public void setVelocity(Vector2 velocity) {
        this.velocity = velocity;
    }
    public Vector2 getVelocity() {
        return velocity;
    }
    public Sprite getSprite(){
        return sprite;
    }
    public Directions getDirection(){
        try {
            return dir;
        } catch (Exception e) {
            return Directions.north;
        }
    }
    public void setDirection(Directions dir){
        this.dir = dir;
    }
    @Override
    public Rectangle getRectangle() {
        return this.getBoundingRectangle();
    }
}
