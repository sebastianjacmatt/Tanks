package com.mygdx.tanks;

import com.badlogic.gdx.math.Rectangle;

public interface Collidable {
    public void move(float deltaX, float deltaY);
    public Rectangle getRectangle();
}
