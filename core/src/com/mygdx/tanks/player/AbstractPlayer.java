package com.mygdx.tanks.player;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.mygdx.tanks.Collidable;
import com.mygdx.tanks.Map;

public abstract class AbstractPlayer extends Sprite implements Collidable{
    private Animation<TextureRegion> activeAnimation;
    private float elapsedtime;

    private Animation<TextureRegion> upAnim;
    private Animation<TextureRegion> rightAnim;
    private Animation<TextureRegion> leftAnim;
    private Animation<TextureRegion> downAnim;

    public AbstractPlayer(Sprite sprite, Map map){
        super(sprite);

        setSize(16,24);

        downAnim = createAnimation(sprite.getTexture(), 0, false);
        rightAnim = createAnimation(sprite.getTexture(), 1, false);
        leftAnim = createAnimation(sprite.getTexture(), 1, true);
        upAnim = createAnimation(sprite.getTexture(), 2, false);

        activeAnimation = createAnimation(sprite.getTexture(),2, false);
    }
    @Override
    public void draw(Batch batch) {
        elapsedtime += Gdx.graphics.getDeltaTime();
        batch.draw(activeAnimation.getKeyFrame(elapsedtime, true), getX(), getY());
    }
    public void move(){    
        //left for implimentation of each player, for each own controller input
    }
    
    /**
     * takes a raw animation sheet and exstract (row) indexed animation
     * @param rawAnimationSheet raw texture of animations
     * @param row of animation in rawAnimationSheet
     * @return an Animation
     */
    private Animation<TextureRegion> createAnimation(Texture rawAnimationSheet, int row, boolean inverted){
        TextureRegion[][] textureRegion2DArray = TextureRegion.split(rawAnimationSheet, 16, 24);
        Animation<TextureRegion> anim = new Animation<TextureRegion>(1f/textureRegion2DArray[row].length, exstractAnimationFrames(textureRegion2DArray, row));
        // Flip the frames horizontally for left/right animation
        if (row == 1 && inverted) {
            for (TextureRegion frame : textureRegion2DArray[row]) {
                frame.flip(true, false);
            }
        }
        return anim;
    }
    private TextureRegion[] exstractAnimationFrames(TextureRegion[][] animationSheet,int row){
        TextureRegion[] animationFrames = new TextureRegion[animationSheet[row].length];
        for (int i = 0; i < animationSheet[row].length; i++) {
            animationFrames[i] = animationSheet[row][i];
        }
        return animationFrames;
    }
    public void moveUp(){
        setY((getY() + 1));
        activeAnimation = upAnim;
    }
    public void moveDown(){
        setY((getY() - 1));
        activeAnimation = downAnim;
    }
    public void moveLeft(){
        setX((getX() - 1));
        activeAnimation = leftAnim;
    }
    public void moveRight(){
        setX((getX() + 1));
        activeAnimation = rightAnim;
    }

    @Override
    public Rectangle getRectangle() {
        return this.getBoundingRectangle();
    }
}
