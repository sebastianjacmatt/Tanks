package com.mygdx.tanks.player;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mygdx.tanks.Map;

public class Player2 extends AbstractPlayer {

    public Player2(Sprite sprite, Map map) {
        super(sprite, map);
    }
    @Override
    public void move() {
        if (Gdx.input.isKeyPressed(Keys.UP)) {moveUp();}
        if (Gdx.input.isKeyPressed(Keys.DOWN)) {moveDown();}
        if (Gdx.input.isKeyPressed(Keys.LEFT)) {moveLeft();}
        if (Gdx.input.isKeyPressed(Keys.RIGHT)) {moveRight();}
    }
}
