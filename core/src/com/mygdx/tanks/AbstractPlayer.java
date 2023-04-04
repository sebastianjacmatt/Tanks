package com.mygdx.tanks;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;

public abstract class AbstractPlayer extends Sprite{
    public AbstractPlayer(Sprite sprite){
        super(sprite);
    }
    @Override
    public void draw(Batch batch) {
        update(Gdx.graphics.getDeltaTime());
        super.draw(batch);
    }
    private void update(float delta){
        //collision handling
        move();
    }
    protected void move(){
        //left for implimentation of each player, for each own controller input
    }
    public void moveUp(){setY((getY() + 1));}
    public void moveDown(){setY((getY() - 1));}
    public void moveLeft(){setX((getX() - 1));}
    public void moveRight(){setX((getX() + 1));}
}
