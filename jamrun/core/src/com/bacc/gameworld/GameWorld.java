package com.bacc.gameworld;

import com.bacc.gameobjects.Ground;
import com.bacc.gameobjects.Runner;

/**
 * Created by danestrin on 2018-02-09.
 */
public class GameWorld {

    private static float width;
    private static float height;

    private Runner runner;
    private Ground ground;

    // World Parameters - these will change every time you play
    private float gravity;

    public GameWorld(float width, float height) {
        this.width = width;
        this.height = height;

        // Parameters
        this.gravity = 40;

        // Game Objects
        this.runner = new Runner(50, 0, 16, 16, gravity);
        this.ground = new Ground(0, height-32, 320, 160);

        this.runner.setJump(15);
    }

    public void update(float delta) {
        runner.update(delta);

        // Collisions
        checkCollisions();
    }

    public void checkCollisions() {
        if (ground.collides(runner)) {
            runner.setY(ground.getY() - runner.getHeight());
        }
    }

    public float getWidth() {
        return this.width;
    }

    public float getHeight() {
        return this.height;
    }

    public Runner getRunner() {
        return this.runner;
    }

    public Ground getGround() {
        return this.ground;
    }
}
