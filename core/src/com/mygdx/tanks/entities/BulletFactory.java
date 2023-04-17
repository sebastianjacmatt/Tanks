package com.mygdx.tanks.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.tanks.Directions;

public class BulletFactory {
    public Bullet produceBullet(float x, float y, Vector2 speed, Directions dir) {
        return new Bullet(new Sprite(new Texture("assets/badlogic.jpg")), x, y, speed, dir);
    }
}
