package com.mygdx.tanks.entities;

import com.badlogic.gdx.graphics.g2d.Sprite;

public class Bullet extends AbstractEntity {
    private float speed;
    public Bullet(Sprite sprite,float x, float y,float speed, Directions dir) {
        super(sprite);
        setX(x);
        setY(y);
        setDirection(dir);
    }
}
