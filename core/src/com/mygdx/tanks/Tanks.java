package com.mygdx.tanks;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class Tanks extends ApplicationAdapter {
	SpriteBatch batch;
	Sprite img;
	Player1 player1;
	Player2 player2;

	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Sprite(new Texture("bombermanSheet.png"));
		player1 = new Player1(img);
		player2 = new Player2(img);
	}

	@Override
	public void render () {
		ScreenUtils.clear(1, 0, 0, 1);
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
