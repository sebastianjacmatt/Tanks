package com.mygdx.tanks.entities.animation;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public interface Animated {
    public Animation<TextureRegion> getActiveAnimation();
}
