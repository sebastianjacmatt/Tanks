package com.mygdx.tanks.player;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;

public class Player2Controller implements Controllable {
    public Player2Controller(){}
    public Controllable.DIRECTIONS registerInput(){
        if (Gdx.input.isKeyPressed(Keys.UP)) {
            return Controllable.DIRECTIONS.up;
        }
        
        if (Gdx.input.isKeyPressed(Keys.DOWN)) {
            return Controllable.DIRECTIONS.down;
        }
        
        if (Gdx.input.isKeyPressed(Keys.LEFT)) {
            return Controllable.DIRECTIONS.left;
        }
        
        if (Gdx.input.isKeyPressed(Keys.RIGHT)) {
            return Controllable.DIRECTIONS.right;
        }
        return Controllable.DIRECTIONS.idle;
    }
}
