package com.mygdx.tanks.entities;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.mygdx.tanks.Collidable;
import com.mygdx.tanks.Directions;

public abstract class AbstractEntity extends Sprite implements Collidable{
    private Sprite sprite;
    private Directions dir;
    public AbstractEntity(Sprite sprite){
        super(sprite);
        this.sprite = sprite;
        dir = Directions.north;
    }
    @Override
    public void draw(Batch batch) {
        batch.draw(sprite, getX(), getY());
    }
    /**
     * A function to handle movement of entity, is left to inheriting entity to implement
     * TODO : Should maybe be an interface, movable
     */
    public void move(int deltaX, int deltaY) {
        if (deltaY > 0 && deltaX == 0) {
            dir = Directions.north;
            setY((getY() + deltaY));
            super.setRotation(0);
        }
        else if (deltaX > 0 && deltaY == 0) {
            dir = Directions.east;
            setX((getX() + deltaX));
            super.setRotation(270);
        }
        else if (deltaY < 0 && deltaX == 0) {
            dir = Directions.south;
            setY((getY() + deltaY));
            super.setRotation(180);
        }
        else if (deltaX < 0 && deltaY == 0) {
            dir = Directions.west;
            setX((getX() + deltaX));
            super.setRotation(90);
        }
        else if (deltaX > 0 && deltaY > 0) {
            dir = Directions.northEast;
            setY((getY() + deltaY));
            setX((getX() + deltaX));
            super.setRotation(315);
        }
        else if (deltaX > 0 && deltaY < 0) {
            dir = Directions.southEast;
            setY((getY() + deltaY));
            setX((getX() + deltaX));
            super.setRotation(225);
        }
        else if (deltaX < 0 && deltaY < 0) {
            dir = Directions.southWest;
            setY((getY() + deltaY));
            setX((getX() + deltaX));
            super.setRotation(135);
        }
        else if (deltaX < 0 && deltaY > 0) {
            dir = Directions.northWest;
            setY((getY() + deltaY));
            setX((getX() + deltaX));
            super.setRotation(45);
        }
        else {
            dir = Directions.idle;
            setX(getX());
            setY(getY());
        }
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
