package com.mygdx.tanks.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;

public class BulletFactory {
    public Bullet produceBullet(float x, float y , float rotation, Vector2 velocity) {
        return new Bullet(new Sprite(new Texture("assets/badlogic.jpg")),x,y,rotation,velocity);
    }
    
}
