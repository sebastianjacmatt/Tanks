package com.mygdx.tanks.entities.animation;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.tanks.entities.Player;

public class PlayerAnimation {
    private Animation<TextureRegion> northAnim;
    /*
    private Animation<TextureRegion> eastAnim;
    private Animation<TextureRegion> southAnim;
    private Animation<TextureRegion> westAnim;
    private Animation<TextureRegion> northEastAnim;
    private Animation<TextureRegion> southEastAnim;
    private Animation<TextureRegion> southWestAnim;
    private Animation<TextureRegion> northWestAnim;
    */

    Player player;
    public PlayerAnimation(Player player){
        this.player = player;
        northAnim = createAnimation(player.getSprite().getTexture(), 0, false, 24, 26);
    }
    /**
     * takes a raw animation sheet and exstract (row) indexed animation
     * @param rawAnimationSheet raw texture of animations
     * @param row of animation in rawAnimationSheet
     * @return an Animation
     */
    private Animation<TextureRegion> createAnimation(Texture rawAnimationSheet, int row, boolean inverted, int textureWidht, int textureHeigh){
        TextureRegion[][] textureRegion2DArray = TextureRegion.split(rawAnimationSheet, textureWidht, textureHeigh);
        Animation<TextureRegion> anim = new Animation<TextureRegion>(1f/textureRegion2DArray[row].length, exstractAnimationFrames(textureRegion2DArray, row));
        // Flip the frames horizontally for left/right animation
        if (row == 1 && inverted) {
            for (TextureRegion frame : textureRegion2DArray[row]) {
                frame.flip(true, true);
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
            default:
            return northAnim;
        }
    }
    
}
