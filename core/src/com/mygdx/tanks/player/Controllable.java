package com.mygdx.tanks.player;

public interface Controllable {
    public enum DIRECTIONS {
        up,down,left,right,idle
    }
    /**
     * An input handler returning directions(enum)
     * @return the enum directions 
     */
    public DIRECTIONS registerInput();
}
