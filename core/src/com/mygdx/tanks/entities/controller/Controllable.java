package com.mygdx.tanks.entities.controller;

import com.mygdx.tanks.entities.Directions;

public interface Controllable {
    /**
     * An input handler returning directions(enum)
     * @return the enum directions 
     */
    public Directions registerInput();
}
