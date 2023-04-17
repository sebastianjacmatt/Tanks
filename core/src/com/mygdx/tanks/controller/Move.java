package com.mygdx.tanks.controller;

public class Move {
    private final float x;
    private final float y;
    public Move(float x, float y) {
        this.x = x;
        this.y = y;
    }
    public float getDeltaX(){
        return x;
    }
    public float getDeltaY(){
        return y;
    }
}
