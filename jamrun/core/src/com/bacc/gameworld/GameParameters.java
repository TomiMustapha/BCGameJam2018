package com.bacc.gameworld;

/**
 * Created by Tomi on 2018-02-10.
 */
public class GameParameters {
    private float jump_factor;
    private float gravity;
    private float spriteVelocity;

    public GameParameters(){
        jump_factor = 9.5f;
        gravity = 100;
        spriteVelocity = 1.25f;
    }

    public float getGravity() {
        return gravity;
    }

    public float getJump_factor() {
        return jump_factor;
    }

    public float getSpriteVelocity() {
        return spriteVelocity;
    }
}
