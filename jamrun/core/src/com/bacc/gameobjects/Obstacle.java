package com.bacc.gameobjects;

import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Polygon;

import java.util.Random;

/**
 * Created by Tomi on 2018-02-09.
 */
public class Obstacle {
    private float x, y, width, height, velocity;
    private Polygon boundingPoly;
    public boolean onScreen;

    public Obstacle(float x, float y, float width, float height, float velocity) {

        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.velocity = velocity;
        boundingPoly = new Polygon(new float[]{0, 0, this.width, 0, this.width, this.height, 0, this.height});
    }

    public boolean collides(Runner runner) {
        if (Intersector.overlapConvexPolygons(this.boundingPoly, runner.getBoundingPoly())) {
            return true;
        }
        else {
            return false;
        }
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

    public void setX(float x){
        this.x = x;
    }

    public void setY(float y){
        this.y = y;
    }

    public void setWidth(float width){
        this.width= width;
    }

    public void setHeight(float height){
        this.height=height;
    }

    public void setVelocity(float velocity) {
        this.velocity = velocity;
    }

    public void updatePoly(float delta) {
        boundingPoly.setPosition(x, y);
    }

    public Polygon getBoundingPoly() {
        return this.boundingPoly;
    }

    public void update(float delta, float width, float difference){
        movement();
        checkBounds(width,difference);
        updatePoly(delta);
    }

    public void resetPos(float width, float difference) {
        Random rand = new Random();
        float offset = (rand.nextInt((int) 3) * 100) / difference;
        this.x = width + offset;
    }

    public void resetCPos(float width, float difference) {
        Random rand = new Random();
        float offset = (rand.nextInt((int) 5) * 150) / difference;
        this.x = width + offset;
    }

    private void movement() {
        x = x - velocity;
    }
    private void checkBounds(float width, float difference){
        if(this.x < 0-width){
            resetPos(width, difference);
        } else {

        }

    }
}
