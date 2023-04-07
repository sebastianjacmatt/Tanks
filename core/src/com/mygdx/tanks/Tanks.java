package com.mygdx.tanks;

import java.util.ArrayList;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.tanks.player.Player;
import com.mygdx.tanks.player.Player1Controller;
import com.mygdx.tanks.player.Player2Controller;
import com.badlogic.gdx.InputMultiplexer;

public class Tanks extends ApplicationAdapter {
	private SpriteBatch batch;
	private Sprite img;
	
	ArrayList<Player> playerList;

	private TiledMapRenderer tiledMapRenderer;
	private OrthographicCamera camera;
	private Map map;

	private CollisionDetector collisionDetector;
	InputMultiplexer inputMultiplexer;

	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Sprite(new Texture("bombermanSheet.png"));
		map = new Map("assets/tileMapTest1.tmx");

		playerList = new ArrayList<Player>();
		playerList.add(new Player(img,new Player1Controller()));
		playerList.add(new Player(img,new Player2Controller()));
		
        // Create a camera that will show the map
        camera = new OrthographicCamera();
        camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        camera.update();

        // Create a TiledMapRenderer to render the map
        tiledMapRenderer = new OrthogonalTiledMapRenderer(map.getTileMap(), 1f);

		collisionDetector = new CollisionDetector(map);
	}

	@Override
	public void render () {
		ScreenUtils.clear(1, 0, 0, 1);
		// Set the camera position to center on player 1
		camera.position.set(playerList.get(0).getX() + playerList.get(0).getWidth() / 2, playerList.get(0).getY() + playerList.get(0).getHeight() / 2, 0);

		// Update the camera
		camera.update();
	
		// Render the map using the camera's projection matrix
		tiledMapRenderer.setView(camera);
		tiledMapRenderer.render();
		
		//handle game collision
		this.update(Gdx.graphics.getDeltaTime());

		// Render the players
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		for (Player player : playerList) {
			player.draw(batch);
		}
		batch.end();
	}
	/**
	 * Right now only a function checking player collision every Gdx.graphics.getDeltaTime
	 * Essensial for player movement
	 * @param delta set to Gdx.graphics.getDeltaTime
	 */
	private void update(float delta){
		for (Player player : playerList) {
			checkPlayerCollision(player);
		}
	}
	private void checkPlayerCollision(Player player){
		float prevX = player.getX();
		float prevY = player.getY();
		player.move();
		if (detectCollisions(player)) {
			player.setX(prevX);
			player.setY(prevY);
		}
	}
	/**
	 * A method detecting collision between collidables and map
	 * @param collidable object inhereting Collidable interface
	 * @return true if collidable collides with map
	 */
	public boolean detectCollisions(Collidable collidable){
		return collisionDetector.detectCollisions(collidable);
	}
	@Override
	public void dispose () {
		batch.dispose();
	}
}
