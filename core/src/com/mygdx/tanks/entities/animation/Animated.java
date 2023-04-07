package com.mygdx.tanks.entities.animation;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public interface Animated {
    public enum ANIMATIONS{
        up,
        down,
        left,
        right,
        northEast,
        southEast,
        northWest,
        southWest,
        idle
    }
    public Animation<TextureRegion> getActiveAnimation();
}
