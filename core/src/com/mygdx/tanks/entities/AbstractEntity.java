package com.mygdx.tanks.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.mygdx.tanks.Collidable;
import com.mygdx.tanks.entities.animation.Animated;

public abstract class AbstractEntity extends Sprite implements Collidable, Animated{
    private float elapsedtime;
    private Sprite sprite;
    public AbstractEntity(Sprite sprite){
        super(sprite);
        this.sprite = sprite;
    }
    @Override
    public void draw(Batch batch) {
        elapsedtime += Gdx.graphics.getDeltaTime();
        batch.draw(getActiveAnimation().getKeyFrame(elapsedtime, true), getX(), getY());
    }
    public void move(){    
        //left for implimentation of each player, for each own controller input
    }
    protected void moveUp(){
        setY((getY() + 1));
    }
    protected void moveDown(){
        setY((getY() - 1));
    }
    protected void moveLeft(){
        setX((getX() - 1));
    }
    protected void moveRight(){
        setX((getX() + 1));
    }
    protected void idle(){
        setX(getX());
        setY(getY());
        //TODO : Implement and create idle animation
        //activeAnimation = idleAnim;
    }
    public Sprite getSprite(){
        return sprite;
    }
    @Override
    public Rectangle getRectangle() {
        return this.getBoundingRectangle();
    }
}
