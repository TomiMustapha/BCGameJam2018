package com.bacc.gameobjects;

import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Polygon;

/**
 * Created by danestrin on 2018-02-09.
 */
public class Ground {

    private float x, y, width, height;
    private Polygon boundingPoly;

    public Ground(float x, float y, float width, float height) {

        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;

        boundingPoly = new Polygon(new float[]{0, 0, this.width, 0, this.width, this.height, 0, this.height});
        boundingPoly.setPosition(x, y);
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
        return x;
    }

    public float getY() {
        return y;
    }

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }

    public Polygon getBoundingPoly() {
        return this.boundingPoly;
    }
}
