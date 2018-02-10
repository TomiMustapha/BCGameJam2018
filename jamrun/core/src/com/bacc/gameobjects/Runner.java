package com.bacc.gameobjects;

import com.badlogic.gdx.math.Polygon;

/**
 * Created by danestrin on 2018-02-09.
 */
public class Runner {

    private float x, y, width, height, gravity;
    private float y_vel = 0;

    private Polygon boundingPoly;

    public Runner(float x, float y, float width, float height, float gravity) {

        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        boundingPoly = new Polygon(new float[]{0, 0, this.width, 0, this.width, this.height, 0, this.height});

        // World Parameters
        this.gravity = gravity;
    }

    public void update(float delta) {
        movement(delta);
        updatePoly(delta);
    }

    public void movement(float delta) {
        y_vel = (y_vel + gravity)*delta;
        y += y_vel;
    }

    public void updatePoly(float delta) {
        boundingPoly.setPosition(x, y);
    }

    public void onPress() {

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

    public Polygon getBoundingPoly() {
        return this.boundingPoly;
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }
}
