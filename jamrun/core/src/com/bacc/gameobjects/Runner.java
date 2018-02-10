package com.bacc.gameobjects;

import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Polygon;

/**
 * Created by danestrin on 2018-02-09.
 */
public class Runner {

    private float x, y, width, height, gravity;
    private float y_vel = 0;
    private float acceleration;
    private float jump_factor;

    private Polygon boundingPoly;

    public Runner(float x, float y, float width, float height, float gravity) {

        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        boundingPoly = new Polygon(new float[]{0, 0, this.width, 0, this.width, this.height, 0, this.height});

        // World Parameters
        this.gravity = gravity;

        this.acceleration = gravity;
    }

    public void update(float delta) {
        movement(delta);
        updatePoly(delta);
        checkBounds();
    }

    public void movement(float delta) {
        if (acceleration < gravity) {
            acceleration += gravity;
        }

        y_vel = (y_vel + acceleration)*delta;
        y = y + y_vel;
    }

    public void updatePoly(float delta) {
        boundingPoly.setPosition(x, y);
    }

    public void onPress() {
        jump();
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

    public void setJump(float jump_factor) {
        this.jump_factor = jump_factor;
    }

    public boolean collides(Obstacle obstacle){
        if (Intersector.overlapConvexPolygons(this.boundingPoly, obstacle.getBoundingPoly())) {
            return true;
        }
        else {
            return false;
        }
    }

    private void jump() {
        acceleration -= jump_factor*gravity + 75;
    }

    private void checkBounds() {
        if (y < 0) {
            y_vel = 0;
            acceleration = gravity;
        }
    }
}
