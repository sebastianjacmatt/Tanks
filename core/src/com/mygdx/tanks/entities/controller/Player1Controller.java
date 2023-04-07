package com.mygdx.tanks.entities.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.mygdx.tanks.entities.Directions;

public class Player1Controller implements Controllable {
    public Player1Controller(){}
    public Directions registerInput(){
        if (Gdx.input.isKeyPressed(Keys.W) && Gdx.input.isKeyPressed(Keys.D)) {
            return Directions.northEast;
        }
        if (Gdx.input.isKeyPressed(Keys.D) && Gdx.input.isKeyPressed(Keys.S)) {
            return Directions.southEast;
        }
        if (Gdx.input.isKeyPressed(Keys.S) && Gdx.input.isKeyPressed(Keys.A)) {
            return Directions.southWest;
        }
        if (Gdx.input.isKeyPressed(Keys.A) && Gdx.input.isKeyPressed(Keys.W)) {
            return Directions.northWest;
        }
        if (Gdx.input.isKeyPressed(Keys.W)) {
            return Directions.north;
        }
        if (Gdx.input.isKeyPressed(Keys.D)) {
            return Directions.east;
        }
        if (Gdx.input.isKeyPressed(Keys.S)) {
            return Directions.south;
        }
        if (Gdx.input.isKeyPressed(Keys.A)) {
            return Directions.west;
        }
        return Directions.idle;
    }
}
