package com.mygdx.tanks.controller;

public class Move {
    private final int x;
    private final int y;
    public Move(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public int getDeltaX(){
        return x;
    }
    public int getDeltaY(){
        return y;
    }
}
