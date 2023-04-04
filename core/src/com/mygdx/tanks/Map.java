package com.mygdx.tanks;

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
        layer = (TiledMapTileLayer) tiledMap.getLayers().get(0);
        tileWidth = (int) layer.getTileWidth();
        tileHeight = (int) layer.getTileHeight();
        mapWidth = layer.getWidth();
        mapHeight = layer.getHeight();
        bounds = new Rectangle(0, 0, tileWidth * mapWidth, tileHeight * mapHeight);
    }

    public boolean isBlocked(int x, int y) {
        return layer.getCell(x, y).getTile().getProperties().containsKey("blocked");
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
