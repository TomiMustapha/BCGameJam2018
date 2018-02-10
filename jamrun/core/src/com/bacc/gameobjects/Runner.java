package com.bacc.gameobjects;

/**
 * Created by danestrin on 2018-02-09.
 */
public class Runner {

    private float x, y, width, height;

    public Runner(float x, float y, float width, float height) {

        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void update(float delta) {

    }

    public float getX() {
        return this.x;
    }

    public float getY() {
        return this.y;
    }

    public float getWidth() {
        return this.width;
    }

    public float getHeight() {
        return this.height;
    }
}
