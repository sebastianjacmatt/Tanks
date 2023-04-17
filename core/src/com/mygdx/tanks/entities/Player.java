package com.mygdx.tanks.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
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
        Vector2 bulletVelocity = new Vector2();
        bulletVelocity.x = 0;
        bulletVelocity.y = 0;
        switch (getDirection()) {
            case north:
                bulletVelocity.y = 1;
                break;
            case south:
                bulletVelocity.y = -1;
                break;
            case east:
                bulletVelocity.x = 1;
                break;
            case west:
                bulletVelocity.x = -1;
                break;
            case northEast:
                bulletVelocity.x = 1;
                bulletVelocity.y = 1;
                break;
            case northWest:
                bulletVelocity.x = -1;
                bulletVelocity.y = 1;
                break;
            case southEast:
                bulletVelocity.x = 1;
                bulletVelocity.y = -1;
                break;
            case southWest:
                bulletVelocity.x = -1;
                bulletVelocity.y = -1;
                break;
            default:
                break;
        }
        return bulletFactory.produceBullet(getX(), getY(), getRotation(), bulletVelocity);
    }
}
