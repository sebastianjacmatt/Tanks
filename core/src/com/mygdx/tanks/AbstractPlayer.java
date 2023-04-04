package com.mygdx.tanks;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public abstract class AbstractPlayer extends Sprite{
    Animation<TextureRegion> anim;
    TextureRegion[] upAnimationFrames;
    TextureRegion[] leftRightAnimationFrames;
    TextureRegion[] downAnimationFrames;
    float elapsedtime;

    //Animation animation;
    public AbstractPlayer(Sprite sprite){
        super(sprite);
        anim = exstractMovementAnimations(sprite.getTexture());

    }
    @Override
    public void draw(Batch batch) {
        elapsedtime += Gdx.graphics.getDeltaTime();
        update(Gdx.graphics.getDeltaTime());
        batch.draw(anim.getKeyFrame(elapsedtime, true), getX(), getY());
    }
    private void update(float delta){
        //collision handling
        move();
    }
    protected void move(){
        //left for implimentation of each player, for each own controller input
    }

    private Animation<TextureRegion> exstractMovementAnimations(Texture animationSheet){
        //https://www.youtube.com/watch?v=SVyYvi0I6Bc&ab_channel=Gamefromscratch
        TextureRegion[][] tmpFrames = TextureRegion.split(animationSheet, 16, 24);
        //TODO create an animationhandler
        upAnimationFrames = new TextureRegion[tmpFrames.length];
        leftRightAnimationFrames = new TextureRegion[tmpFrames.length];
        downAnimationFrames = new TextureRegion[tmpFrames.length];
        int index = 0;
        for (int i = 0; i < tmpFrames.length; i++) {
            for (int j = 0; j < tmpFrames.length; j++) {
                if (index < 5) {
                    upAnimationFrames[j] = tmpFrames[j][i];
                } else if(index < 11){
                    leftRightAnimationFrames[j] = tmpFrames[j][i];
                } else if(index < 17){
                    downAnimationFrames[j] = tmpFrames[j][i];
                }
            }
        }
        anim = new Animation<TextureRegion>(1f/6f, upAnimationFrames);
        return anim;
    }
    public void moveUp(){setY((getY() + 1));}
    public void moveDown(){setY((getY() - 1));}
    public void moveLeft(){setX((getX() - 1));}
    public void moveRight(){setX((getX() + 1));}
}
