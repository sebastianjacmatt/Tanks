package com.mygdx.tanks.player;

import com.badlogic.gdx.graphics.g2d.Sprite;
public class Player extends AbstractPlayer{
    Controllable controller;
    int playerID;
    public Player(Sprite sprite, Controllable controller){
        super(sprite);
        this.controller = controller;
    }
    public void move() {
        switch (controller.registerInput()) {
            case up:
            this.moveUp();
            break;
            case down:
            this.moveDown();
            break;
            case left:
            this.moveLeft();
            break;
            case right:
            this.moveRight();
            break;
            default:
            this.idle();
            break;
        }
    }
    public int getPlayerID(){
        return playerID;
    }
}
