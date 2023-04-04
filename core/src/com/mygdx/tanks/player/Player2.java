package com.mygdx.tanks;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Player2 extends AbstractPlayer {

    public Player2(Sprite sprite) {
        super(sprite);
    }
    @Override
    protected void move() {
        if (Gdx.input.isKeyPressed(Keys.UP)) {moveUp();}
        if (Gdx.input.isKeyPressed(Keys.DOWN)) {moveDown();}
        if (Gdx.input.isKeyPressed(Keys.LEFT)) {moveLeft();}
        if (Gdx.input.isKeyPressed(Keys.RIGHT)) {moveRight();}
    }
}
