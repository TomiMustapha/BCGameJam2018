package com.bacc.gameworld;

import com.bacc.gameobjects.Ground;
import com.bacc.gameobjects.Obstacle;
import com.bacc.gameobjects.Runner;
import com.bacc.helpers.AssetLoader;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.Align;

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
    private ObstacleManager obstacleManager;

    public GameRenderer(GameWorld world) {

        this.world = world;
        this.width = world.getWidth();
        this.height = world.getHeight();

        this.runner = world.getRunner();
        this.ground = world.getGround();
        this.obstacleManager = world.getObstaclesManager();

        cam = new OrthographicCamera();
        cam.setToOrtho(true, 320, 160);
        shapeRenderer = new ShapeRenderer();
        shapeRenderer.setProjectionMatrix(cam.combined);

        batch = new SpriteBatch();
        batch.setProjectionMatrix(cam.combined);
    }
    public void render(float runTime) {
        // Fill screen with black to avoid flickering
        Gdx.gl.glClearColor(145 / 255.0f, 187 / 255.0f, 255 / 255.0f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        //shapeRenderer.polygon(runner.getBoundingPoly().getTransformedVertices());

        // Begin SpriteBatch

        currentFrame = AssetLoader.runAnim.getKeyFrame(runTime);

        batch.begin();

        batch.draw(AssetLoader.bg, 0, 0, 320, 160);
        batch.draw(AssetLoader.ground, ground.getX(), ground.getY(), ground.getWidth(), ground.getHeight());

        if (world.isTitle()) {
            AssetLoader.font.getData().setScale(1f);
            AssetLoader.font.setColor(255, 255, 255, 255);
            AssetLoader.font.draw(batch, "FAT BOY SZN \n PRESS SPACEBAR TO START", 0, height/2, width, Align.center, true);
        } else if (world.isInGame()) {
            batch.draw(currentFrame, runner.getX(), runner.getY());

            AssetLoader.font.getData().setScale(0.5f);
            AssetLoader.font.setColor(255, 255, 255, 255);
            AssetLoader.font.draw(batch, "CALORIES BURNED: " + world.getScore(), 0, 0, width, Align.left, true);

            for (Obstacle o : obstacleManager.getCollectables()) {
                //batch.draw(AssetLoader.apple, o.getX(), o.getY(), o.getWidth(), o.getHeight());
                batch.draw(AssetLoader.apple, o.getX(), o.getY(), o.getWidth(), o.getHeight());
            }

            for (Obstacle o : obstacleManager.getEnemies()) {
                // Draw Enemy
                batch.draw(AssetLoader.crate, o.getX(), o.getY(), o.getWidth(), o.getHeight());
                // shapeRenderer.polygon(o.getBoundingPoly().getTransformedVertices());
            }
        } else if (world.isGameOver()) {
            AssetLoader.font.getData().setScale(1f);
            AssetLoader.font.setColor(255, 255, 255, 255);
            AssetLoader.font.draw(batch, "GAME OVER \n YOU BURNED " + world.getScore() + " CALORIES", 0, height/2, width, Align.center, true);
        }
        batch.end();
    }
}
