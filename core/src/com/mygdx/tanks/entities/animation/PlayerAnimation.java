package com.mygdx.tanks.entities.animation;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.tanks.entities.Player;

public class PlayerAnimation {
    private Animation<TextureRegion> northAnim;
    private Animation<TextureRegion> eastAnim;
    private Animation<TextureRegion> westAnim;
    private Animation<TextureRegion> southAnim;

    Player player;
    public PlayerAnimation(Player player){
        this.player = player;
        southAnim = createAnimation(player.getSprite().getTexture(), 0, false);
        eastAnim = createAnimation(player.getSprite().getTexture(), 1, false);
        westAnim = createAnimation(player.getSprite().getTexture(), 1, true);
        northAnim = createAnimation(player.getSprite().getTexture(), 2, false);
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
    public Animation<TextureRegion> getActiveAnimation() {
        switch (player.getDirection()) {
            case north:
            return northAnim;
            case east:
            return eastAnim;
            case south:
            return southAnim;
            case west:
            return westAnim;
            default:
            return northAnim;
        }
    }
    
}