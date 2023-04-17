package com.mygdx.tanks.controller;

public interface Controller {
    /**
     * An input handler returning directions(enum)
     * @return the enum directions 
     */
    public Move registerInput();
}
