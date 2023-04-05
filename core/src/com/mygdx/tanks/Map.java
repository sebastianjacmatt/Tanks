package com.mygdx.tanks;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.math.Rectangle;

public class Map {
    private TiledMap tiledMap;
    private TiledMapTileLayer layer;
    private int tileWidth, tileHeight;
    private int mapWidth, mapHeight;
    private Rectangle bounds;

    public Map(String filename) {
        tiledMap = new TmxMapLoader().load(filename);
        layer = (TiledMapTileLayer) tiledMap.getLayers().get("layer1");

        tileWidth = (int) layer.getTileWidth();
        tileHeight = (int) layer.getTileHeight();
        mapWidth = layer.getWidth();
        mapHeight = layer.getHeight();
        bounds = new Rectangle(0, 0, tileWidth * mapWidth, tileHeight * mapHeight);
    }

    public ArrayList<Rectangle> getCollidableRectangles() {
        TiledMapTileLayer collidableLayer = (TiledMapTileLayer) tiledMap.getLayers().get("collidable");
        ArrayList<Rectangle> collidableRectangles = new ArrayList<Rectangle>();
        for (int y = 0; y < collidableLayer.getHeight(); y++) {
            for (int x = 0; x < collidableLayer.getWidth(); x++) {
                if (collidableLayer.getCell(x, y) != null) {
                    collidableRectangles.add(new Rectangle(x * tileWidth, y * tileHeight, tileWidth, tileHeight));
                }
            }
        }
        return collidableRectangles;
    }

    public TextureRegion getTile(int x, int y) {
        return layer.getCell(x, y).getTile().getTextureRegion();
    }

    public int getTileWidth() {
        return tileWidth;
    }

    public int getTileHeight() {
        return tileHeight;
    }

    public int getMapWidth() {
        return mapWidth;
    }

    public int getMapHeight() {
        return mapHeight;
    }

    public Rectangle getBounds() {
        return bounds;
    }

    public void dispose() {
        tiledMap.dispose();
    }

    public TiledMap getTileMap() {
        return tiledMap;
    }
}
