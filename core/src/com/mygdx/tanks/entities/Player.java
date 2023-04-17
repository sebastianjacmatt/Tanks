package com.mygdx.tanks.entities;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.tanks.entities.animation.PlayerAnimation;
public class Player extends AbstractEntity{
    protected Directions dir;
    private PlayerAnimation animations;
    public Player(Sprite sprite){
        super(sprite);
        setSize(24,26);
        dir = Directions.north;
        this.animations = new PlayerAnimation(this);
        this.setOrigin(this.getWidth() / 2, this.getHeight() / 2);
    }
    @Override
    public Animation<TextureRegion> getActiveAnimation() {
        return animations.getActiveAnimation();
    }
    @Override
    public void move(int deltaX, int deltaY) {
        super.move(deltaX, deltaY);
        
    }
}
