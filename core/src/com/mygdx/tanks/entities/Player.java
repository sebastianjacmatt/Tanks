package com.mygdx.tanks.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mygdx.tanks.Directions;
import com.mygdx.tanks.entities.animation.PlayerAnimation;
public class Player extends AbstractEntity{
    protected Directions dir;
    private float elapsedtime;
    private PlayerAnimation animations;
    private BulletFactory bulletFactory;

    public Player(Sprite sprite){
        super(sprite);
        setSize(24,26);
        dir = Directions.north;
        this.animations = new PlayerAnimation(this);
        this.setOrigin(this.getWidth() / 2, this.getHeight() / 2);

        bulletFactory = new BulletFactory();
    }
    @Override
    public void draw(Batch batch) {
        elapsedtime += Gdx.graphics.getDeltaTime();
        batch.draw(animations.getActiveAnimation().getKeyFrame(elapsedtime, true), getX(), getY(), getOriginX(), getOriginY(), getWidth(), getHeight(), getScaleX(), getScaleY(), getRotation());
    }
    @Override
    public void move(float deltaX, float deltaY) {
        super.move(deltaX, deltaY);
    }
    /**
     * Fires a bullet for player
     */
    public Bullet fire() {
        return bulletFactory.produceBullet(getX(), getY(), 1.3f,getDirection());
    }
}
