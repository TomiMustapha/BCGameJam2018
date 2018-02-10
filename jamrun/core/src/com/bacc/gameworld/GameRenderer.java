package com.bacc.gameworld;

import com.bacc.gameobjects.Ground;
import com.bacc.gameobjects.Runner;
import com.bacc.helpers.AssetLoader;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

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

    TextureRegion currentFrame;

    private Runner runner;
    private Ground ground;

    public GameRenderer(GameWorld world) {

        this.world = world;
        this.width = world.getWidth();
        this.height = world.getHeight();

        this.runner = world.getRunner();
        this.ground = world.getGround();

        cam = new OrthographicCamera();
        cam.setToOrtho(true, 320, 160);
        shapeRenderer = new ShapeRenderer();
        shapeRenderer.setProjectionMatrix(cam.combined);

        batch = new SpriteBatch();
        batch.setProjectionMatrix(cam.combined);
    }
    public void render(float runTime) {
        // Fill screen with black to avoid flickering
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // Begin ShapeRenderer
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);

        // Draw Ground
        shapeRenderer.setColor(111 / 255.0f, 186 / 255.0f, 45 / 255.0f, 1);
        shapeRenderer.rect(ground.getX(), ground.getY(), ground.getWidth(), ground.getHeight());

        // Draw Runner
        //shapeRenderer.setColor(212 / 255.0f, 123 / 255.0f, 35 / 255.0f, 1);
        //shapeRenderer.rect(runner.getX(), runner.getY(), runner.getWidth(), runner.getHeight());

        shapeRenderer.end();

        // Begin SpriteBatch

        currentFrame = AssetLoader.runAnim.getKeyFrame(runTime);

        batch.begin();

        batch.draw(currentFrame, runner.getX(), runner.getY());

        batch.end();
    }
}
