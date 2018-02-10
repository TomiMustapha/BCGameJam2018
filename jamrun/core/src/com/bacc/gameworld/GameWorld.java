package com.bacc.gameworld;

import com.bacc.gameobjects.Runner;

/**
 * Created by danestrin on 2018-02-09.
 */
public class GameWorld {

    private static float width;
    private static float height;

    private Runner runner;

    public GameWorld(float width, float height) {
        this.width = width;
        this.height = height;

        this.runner = new Runner(50, 50, 16, 16);
    }

    public void update(float delta) {

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
}
