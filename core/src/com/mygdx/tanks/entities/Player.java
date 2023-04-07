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
        setSize(16,24);
        dir = Directions.north;
        this.animations = new PlayerAnimation(this);
    }
    public void move() {
        switch (controller.registerInput()) {
            case north:
            dir = Directions.north;
            this.moveUp();
            break;
            case south:
            dir = Directions.south;
            this.moveDown();
            break;
            case west:
            dir = Directions.west;
            this.moveLeft();
            break;
            case east:
            dir = Directions.east;
            this.moveRight();
            break;
            default:
            this.idle();
            dir = Directions.idle;
            break;
        }
    }
    public Directions getDirection(){
        try {
            return dir;
        } catch (Exception e) {
            return Directions.north;
        }
    }
    @Override
    public Animation<TextureRegion> getActiveAnimation() {
        return animations.getActiveAnimation();
    }
}
