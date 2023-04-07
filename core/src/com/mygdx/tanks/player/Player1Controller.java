package com.mygdx.tanks.player;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;

public class Player1Controller implements Controllable {
    public Player1Controller(){}
    public Controllable.DIRECTIONS registerInput(){
        if (Gdx.input.isKeyPressed(Keys.W)) {
            return Controllable.DIRECTIONS.up;
        }
        
        if (Gdx.input.isKeyPressed(Keys.S)) {
            return Controllable.DIRECTIONS.down;
        }
        
        if (Gdx.input.isKeyPressed(Keys.A)) {
            return Controllable.DIRECTIONS.left;
        }
        
        if (Gdx.input.isKeyPressed(Keys.D)) {
            return Controllable.DIRECTIONS.right;
        }
        return Controllable.DIRECTIONS.idle;
    }
}
