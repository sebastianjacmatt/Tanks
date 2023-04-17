package com.mygdx.tanks;

import com.badlogic.gdx.math.Rectangle;

public interface Collidable {
    public void move(int deltaX, int deltaY);
    public Rectangle getRectangle();
}
