package com.mygdx.tanks.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;

public class Player1Controller implements Controller {
    public Player1Controller(){}
    public Move registerInput(){
        if (Gdx.input.isKeyPressed(Keys.W) && Gdx.input.isKeyPressed(Keys.D)) {
            return new Move(1, 1);
        }
        if (Gdx.input.isKeyPressed(Keys.D) && Gdx.input.isKeyPressed(Keys.S)) {
            return new Move(1, -1);
        }
        if (Gdx.input.isKeyPressed(Keys.S) && Gdx.input.isKeyPressed(Keys.A)) {
            return new Move(-1, -1);
        }
        if (Gdx.input.isKeyPressed(Keys.A) && Gdx.input.isKeyPressed(Keys.W)) {
            return new Move(-1, 1);
        }
        if (Gdx.input.isKeyPressed(Keys.W)) {
            return new Move(0, 1);
        }
        if (Gdx.input.isKeyPressed(Keys.D)) {
            return new Move(1, 0);
        }
        if (Gdx.input.isKeyPressed(Keys.S)) {
            return new Move(0, -1);
        }
        if (Gdx.input.isKeyPressed(Keys.A)) {
            return new Move(-1, 0);
        }
        return new Move(0, 0);
    }
    @Override
    public boolean fire() {
        if (Gdx.input.isKeyJustPressed(Keys.SPACE)) {
            return true;
        }
        return false;
    }
}
