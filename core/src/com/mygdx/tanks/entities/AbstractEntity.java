package com.mygdx.tanks.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.mygdx.tanks.Collidable;
import com.mygdx.tanks.entities.animation.Animated;

public abstract class AbstractEntity extends Sprite implements Collidable{
    private float elapsedtime;
    private Sprite sprite;
    public AbstractEntity(Sprite sprite){
        super(sprite);
        this.sprite = sprite;
    }
    @Override
    public void draw(Batch batch) {
        elapsedtime += Gdx.graphics.getDeltaTime();
        batch.draw(getActiveAnimation().getKeyFrame(elapsedtime, true), getX(), getY(), getOriginX(), getOriginY(), getWidth(), getHeight(), getScaleX(), getScaleY(), getRotation());
    }
    /**
     * A function to handle movement of entity, is left to inheriting entity to implement
     * TODO : Should maybe be an interface, movable
     */
    public void move(){    
        //left for implimentation of each player, for each own controller input
    }
    protected void moveNorth(){
        setY((getY() + 1));
        super.setRotation(0);
    }
    protected void moveEast(){
        setX((getX() + 1));
        super.setRotation(270);
    }
    protected void moveSouth(){
        setY((getY() - 1));
        super.setRotation(180);
    }
    protected void moveWest(){
        setX((getX() - 1));
        super.setRotation(90);
    }
    protected void moveNorthEast(){
        setY((getY() + 1));
        setX((getX() + 1));
        super.setRotation(315);
    }
    protected void moveSouthEast(){
        setY((getY() - 1));
        setX((getX() + 1));
        super.setRotation(225);
    }
    protected void moveNorthWest(){
        setY((getY() + 1));
        setX((getX() - 1));
        super.setRotation(45);
    }
    protected void moveSouthWest(){
        setY((getY() - 1));
        setX((getX() - 1));
        super.setRotation(135);
    }
    protected void idle(){
        setX(getX());
        setY(getY());
    }
    public Sprite getSprite(){
        return sprite;
    }
    @Override
    public Rectangle getRectangle() {
        return this.getBoundingRectangle();
    }
}
