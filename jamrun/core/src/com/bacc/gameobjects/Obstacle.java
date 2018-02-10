package com.bacc.gameobjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Polygon;

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
            Gdx.app.log("Collision","player hit obstacle");
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

    public void update(float delta, float width){
        movement();
        isOnScreen();
        updatePoly(delta);
    }

    private void resetPos(float width) {
        this.x = width;
    }

    private void movement() {
        x = x - velocity;
    }

    public boolean isOnScreen() {
        if(this.x > width || this.x < width){
            onScreen = false;
        } else {
            onScreen = true;
        }
        return onScreen;
    }
}
