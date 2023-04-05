package com.mygdx.tanks;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.tanks.player.Player1;
import com.mygdx.tanks.player.Player2;

public class Tanks extends ApplicationAdapter {
	SpriteBatch batch;
	Sprite img;
	Player1 player1;
	Player2 player2;

	TiledMapRenderer tiledMapRenderer;
	OrthographicCamera camera;
	Map map;

	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Sprite(new Texture("bombermanSheet.png"));
		map = new Map("assets/tileMapTest1.tmx");

		player1 = new Player1(img, map);
		player2 = new Player2(img, map);
		

        // Create a camera that will show the map
        camera = new OrthographicCamera();
        camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        camera.update();

        // Create a TiledMapRenderer to render the map
        tiledMapRenderer = new OrthogonalTiledMapRenderer(map.getTileMap(), 1f);
	}

	@Override
	public void render () {
		ScreenUtils.clear(1, 0, 0, 1);
		// Set the camera position to center on player 1
		camera.position.set(player1.getX() + player1.getWidth() / 2, player1.getY() + player1.getHeight() / 2, 0);

		// Update the camera
		camera.update();
	
		// Render the map using the camera's projection matrix
		tiledMapRenderer.setView(camera);
		tiledMapRenderer.render();
	
		// Render the players
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		player2.draw(batch);
		player1.draw(batch);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}
}
