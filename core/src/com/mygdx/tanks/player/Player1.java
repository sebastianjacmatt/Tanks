package com.mygdx.tanks.player;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mygdx.tanks.Map;

public class Player1 extends AbstractPlayer{
    public Player1(Sprite sprite, Map map){
        super(sprite, map);
    }
    
    public void move() {
        if (Gdx.input.isKeyPressed(Keys.W)) {moveUp();}
        if (Gdx.input.isKeyPressed(Keys.S)) {moveDown();}
        if (Gdx.input.isKeyPressed(Keys.A)) {moveLeft();}
        if (Gdx.input.isKeyPressed(Keys.D)) {moveRight();}
    }
}
