package com.mygdx.tanks;

import java.util.ArrayList;

import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;

public class CollisionDetector {
    private Map map;
    ArrayList<Rectangle> MapCollidables;
    CollisionDetector(Map map){
        this.map = map;
        MapCollidables = map.getCollidableRectangles();
    }
    /**
     * A method checking for collision with a map
     * @param collidable an object implementing the Collidable interface
     * @return true if collision between Collidable and map
     */
    public boolean detectCollisions(Collidable collidable){
        for (Rectangle rectangle : MapCollidables) {
            if (Intersector.overlaps(collidable.getRectangle(),rectangle)) {
                return true;
            }
        }
        return false;
    }

}
