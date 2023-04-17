package com.mygdx.tanks.entities;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.tanks.entities.animation.PlayerAnimation;
import com.mygdx.tanks.entities.controller.Controllable;
public class Player extends AbstractEntity{
    protected Controllable controller;
    protected Directions dir;
    private PlayerAnimation animations;
    public Player(Sprite sprite, Controllable controller){
        super(sprite);
        this.controller = controller;
        setSize(24,26);
        dir = Directions.north;
        this.animations = new PlayerAnimation(this);
        this.setOrigin(this.getWidth() / 2, this.getHeight() / 2);
    }
    /**
     * A function handling input from Controllable player
     */
    public void move() {
        Directions input = controller.registerInput();
        if (input == Directions.north) {
            dir = Directions.north;
            this.moveNorth();
        }
        else if (input == Directions.east) {
            dir = Directions.east;
            this.moveEast();
        }
        else if (input == Directions.south) {
            dir = Directions.south;
            this.moveSouth();
        }
        else if (input == Directions.west) {
            dir = Directions.west;
            this.moveWest();
        }
        else if (input == Directions.northEast) {
            dir = Directions.northEast;
            this.moveNorthEast();
        }
        else if (input == Directions.southEast) {
            dir = Directions.southEast;
            this.moveSouthEast();
        }
        else if (input == Directions.southWest) {
            dir = Directions.southWest;
            this.moveSouthWest();
        }
        else if (input == Directions.northWest) {
            dir = Directions.northWest;
            this.moveNorthWest();
        }
        else {
            this.idle();
            dir = Directions.idle;
        }
    }    
    public Directions getDirection(){
        try {
            return dir;
        } catch (Exception e) {
            return Directions.north;
        }
    }
}
