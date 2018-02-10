package com.bacc.gameworld;

import com.bacc.gameobjects.Enemy;
import com.bacc.gameobjects.Ground;
import com.bacc.gameobjects.Obstacle;
import com.bacc.gameobjects.Runner;
import com.badlogic.gdx.Gdx;

import java.util.ArrayList;

/**
 * Created by danestrin on 2018-02-09.
 */
public class GameWorld {

    private static float width;
    private static float height;

    private Runner runner;
    private Ground ground;
    private ArrayList<Obstacle> obstacles;
    private Enemy enemy;
    private Enemy enemy2;
    private float spriteVelocity = 1;


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
        this.obstacles = new ArrayList<Obstacle>(1);
        this.enemy = new Enemy(width, height - 48, 16, 16, spriteVelocity );
        this.enemy2 = new Enemy(width+100, height - 48, 16, 16, spriteVelocity );
        obstacles.add(enemy);
        obstacles.add(enemy2);
    }

    public void update(float delta) {
        runner.update(delta);
        for(Obstacle o : obstacles){
            o.update(delta);
                //end game


        }

        // Collisions
        checkCollisions();
    }

    public void checkCollisions() {
        if (ground.collides(runner)) {
            runner.setY(ground.getY() - runner.getHeight());
        }

        for(Obstacle o : obstacles){
            if (runner.collides(o)) {
                //end game
                Gdx.app.log("Collision","player hit obstacle");

            }
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

    public ArrayList<Obstacle> getObstacles(){return this.obstacles; }
}
