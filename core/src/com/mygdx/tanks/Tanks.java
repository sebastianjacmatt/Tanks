package com.mygdx.tanks;

import java.util.ArrayList;
import java.util.HashMap;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.tanks.controller.Controller;
import com.mygdx.tanks.controller.Move;
import com.mygdx.tanks.controller.Player1Controller;
import com.mygdx.tanks.controller.Player2Controller;
import com.mygdx.tanks.entities.AbstractEntity;
import com.mygdx.tanks.entities.Bullet;
import com.mygdx.tanks.entities.Player;

public class Tanks extends ApplicationAdapter {
	private SpriteBatch batch;
	private Sprite img;
	
	ArrayList<Player> playerList;

	private TiledMapRenderer tiledMapRenderer;
	private OrthographicCamera camera;
	private Map map;

	private CollisionDetector collisionDetector;
	
	private HashMap<Player, Controller> playerController;
	private ArrayList<Bullet> bulletList;


	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Sprite(new Texture("tankSheet.png"));
		map = new Map("assets/tileMapTest1.tmx");

		playerList = new ArrayList<Player>();
		playerList.add(new Player(img));
		playerList.add(new Player(img));
		
        // Create a camera that will show the map
        camera = new OrthographicCamera();
        camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        camera.update();

        // Create a TiledMapRenderer to render the map
        tiledMapRenderer = new OrthogonalTiledMapRenderer(map.getTileMap(), 1f);
		
		collisionDetector = new CollisionDetector(map);

		playerController = new HashMap<Player, Controller>();
		playerController.put(playerList.get(0),new Player1Controller());
		playerController.put(playerList.get(1),new Player2Controller());

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
		for (HashMap.Entry<Player, Controller> playerAndController : playerController.entrySet()) {
			Player player = playerAndController.getKey();
			Controller controller = playerAndController.getValue();
			
			Move move = controller.registerInput();
			checkPlayerCollision(player, move.getDeltaX(), move.getDeltaY());
		}
	}
	/**
	 * a method moving AbstractEntities
	 * @param entity
	 * @param move 
	 * @return true if collides with map
	 */
	private void moveEntity(AbstractEntity entity,Move move){
		entity.setX(entity.getX() + move.getDeltaX());
		entity.setY(entity.getY() + move.getDeltaY());
	}
	private void checkPlayerCollision(Player player, int deltaX, int deltaY){
		float prevX = player.getX();
		float prevY = player.getY();
		player.move(deltaX, deltaY);
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
