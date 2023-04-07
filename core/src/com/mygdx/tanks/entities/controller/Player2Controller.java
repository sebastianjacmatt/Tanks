package com.mygdx.tanks.entities.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.mygdx.tanks.entities.Directions;

public class Player2Controller implements Controllable {
    public Player2Controller(){}
    public Directions registerInput(){
        if (Gdx.input.isKeyPressed(Keys.UP)) {
            return Directions.north;
        }
        if (Gdx.input.isKeyPressed(Keys.UP) && Gdx.input.isKeyPressed(Keys.RIGHT)) {
            return Directions.northEast;
        }
        if (Gdx.input.isKeyPressed(Keys.RIGHT)) {
            return Directions.east;
        }
        if (Gdx.input.isKeyPressed(Keys.DOWN) && Gdx.input.isKeyPressed(Keys.RIGHT)) {
            return Directions.southEast;
        }
        if (Gdx.input.isKeyPressed(Keys.DOWN)) {
            return Directions.south;
        }
        if (Gdx.input.isKeyPressed(Keys.DOWN) && Gdx.input.isKeyPressed(Keys.LEFT)) {
            return Directions.southWest;
        }
        if (Gdx.input.isKeyPressed(Keys.LEFT)) {
            return Directions.west;
        }
        if (Gdx.input.isKeyPressed(Keys.UP) && Gdx.input.isKeyPressed(Keys.LEFT)) {
            return Directions.northWest;
        }
        return Directions.idle;
    }
}
