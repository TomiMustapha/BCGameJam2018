package com.bacc.gameobjects;

/**
 * Created by Tomi on 2018-02-09.
 */
public class Obstacle {
    private float x, y, width, height, velocity;

    public Obstacle(float x, float y, float width, float height, float velocity) {

        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.velocity = velocity;
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
}
