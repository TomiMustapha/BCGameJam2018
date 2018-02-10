package com.bacc.gameworld;

import com.bacc.gameobjects.Ground;
import com.bacc.gameobjects.Obstacle;
import com.bacc.gameobjects.Runner;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import java.util.ArrayList;

/**
 * Created by danestrin on 2018-02-09.
 */
public class GameRenderer {

    private GameWorld world;
    private OrthographicCamera cam;
    private ShapeRenderer shapeRenderer;

    private SpriteBatch batch;

    private static float width;
    private static float height;

    private Runner runner;
    private Ground ground;
    private ArrayList<Obstacle> obstacles;

    public GameRenderer(GameWorld world) {

        this.world = world;
        this.width = world.getWidth();
        this.height = world.getHeight();

        this.runner = world.getRunner();
        this.ground = world.getGround();
        this.obstacles = world.getObstacles();

        cam = new OrthographicCamera();
        cam.setToOrtho(true, 320, 160);
        shapeRenderer = new ShapeRenderer();
        shapeRenderer.setProjectionMatrix(cam.combined);
    }
    public void render() {
        // Fill screen with black to avoid flickering
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // Begin ShapeRenderer
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);

        // Draw Ground
        shapeRenderer.setColor(111 / 255.0f, 186 / 255.0f, 45 / 255.0f, 1);
        shapeRenderer.rect(ground.getX(), ground.getY(), ground.getWidth(), ground.getHeight());

        // Draw Runner
        shapeRenderer.setColor(212 / 255.0f, 123 / 255.0f, 35 / 255.0f, 1);
        shapeRenderer.rect(runner.getX(), runner.getY(), runner.getWidth(), runner.getHeight());
        for(Obstacle o : obstacles){
            // Draw Enemy
            shapeRenderer.setColor(100 / 255.0f, 123 / 255.0f, 35 / 255.0f, 1);
            shapeRenderer.rect(o.getX(), o.getY(), o.getWidth(), o.getHeight());
        }

        shapeRenderer.end();
    }
}
