package com.mygdx.tanks.controller;

public interface Controller {
    /**
     * An input handler returning directions(enum)
     * @return the enum directions 
     */
    public Move registerInput();
    /**
     * checks if player wants to fire bullet or not
     * @return true if player fires
     */
    public boolean fire();
}
