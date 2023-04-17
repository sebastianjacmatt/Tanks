package com.mygdx.tanks.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;

public class Player2Controller implements Controller {
    public Player2Controller(){}
    public Move registerInput(){
        if (Gdx.input.isKeyPressed(Keys.UP) && Gdx.input.isKeyPressed(Keys.RIGHT)) {
            return new Move(1, 1);
        }
        if (Gdx.input.isKeyPressed(Keys.DOWN) && Gdx.input.isKeyPressed(Keys.RIGHT)) {
            return new Move(1, -1);
        }
        if (Gdx.input.isKeyPressed(Keys.DOWN) && Gdx.input.isKeyPressed(Keys.LEFT)) {
            return new Move(-1, -1);
        }
        if (Gdx.input.isKeyPressed(Keys.UP) && Gdx.input.isKeyPressed(Keys.LEFT)) {
            return new Move(-1, 1);
        }
        if (Gdx.input.isKeyPressed(Keys.UP)) {
            return new Move(0, 1);
        }
        if (Gdx.input.isKeyPressed(Keys.RIGHT)) {
            return new Move(1, 0);
        }
        if (Gdx.input.isKeyPressed(Keys.DOWN)) {
            return new Move(0, -1);
        }
        if (Gdx.input.isKeyPressed(Keys.LEFT)) {
            return new Move(-1, 0);
        }
        return new Move(0, 0);
    }
    @Override
    public boolean fire() {
        if (Gdx.input.isKeyJustPressed(Keys.ENTER)) {
            return true;
        }
        return false;
    }
}
