package com.mygdx.tanks.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.tanks.Directions;

public class BulletFactory {
    public Bullet produceBullet(float x, float y, float speed ,Directions dir) {
        return new Bullet(new Sprite(new Texture("assets/badlogic.jpg")), x, y, speed, dir);
    }
    private Vector2 convertDirection(Directions dir) {
        Vector2 vec = new Vector2();
        switch (dir) {
            case north:
                vec.set(0, 1);
                break;
            case south:
                vec.set(0, -1);
                break;
            case east:
                vec.set(1, 0);
                break;
            case west:
                vec.set(-1, 0);
                break;
            case northEast:
                vec.set(1, 1);
                break;
            case northWest:
                vec.set(-1, 1);
                break;
            case southEast:
                vec.set(1, -1);
                break;
            case southWest:
                vec.set(-1, -1);
                break;
            default:
                vec.set(0, 0);
                break;
        }
        return vec;
    }
    
}
