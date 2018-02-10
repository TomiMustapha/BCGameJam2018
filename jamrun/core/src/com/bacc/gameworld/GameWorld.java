package com.bacc.gameworld;

import com.bacc.gameobjects.Enemy;
import com.bacc.gameobjects.Ground;
import com.bacc.gameobjects.Obstacle;
import com.bacc.gameobjects.Runner;
import com.bacc.helpers.AssetLoader;

import java.util.ArrayList;


/**
 * Created by danestrin on 2018-02-09.
 */
public class GameWorld {

    private static float width;
    private static float height;
    private int score;
    public float score_rate = 1;
    public float timer = 0;

    private Runner runner;
    private Ground ground;
    private GameParameters gameParameters;
    private ArrayList<Obstacle> obstacles;
    private Enemy enemy;
    private Enemy enemy2;
    private float spriteVelocity;
    private ObstacleManager obstacleManager;
    private int enemies;
    private int collectibles;
    private float difference;
    private int collectible_value;

    private GameState currentState = GameState.TITLE;

    // World Parameters - these will change every time you play
    private float gravity;

    public enum GameState {
        TITLE, INGAME, GAMEOVER
    }

    public GameWorld(float width, float height) {
        this.width = width;
        this.height = height;
        this.gameParameters = new GameParameters();
        // Parameters
        this.gravity = gameParameters.getGravity();

        // Game Objects

        this.ground = new Ground(0, height-32, 320, 32);
        this.runner = new Runner(50, ground.getY() - AssetLoader.dude1.getRegionHeight(), AssetLoader.dude1.getRegionWidth(), AssetLoader.dude1.getRegionHeight(), gravity);

        this.runner.setJump(gameParameters.getJump_factor());
        this.spriteVelocity = gameParameters.getSpriteVelocity();
        this.enemies = gameParameters.getEnemies();
        this.collectibles = gameParameters.getCollectibles();
        this.difference = gameParameters.getDifference();
        this.obstacleManager = new ObstacleManager(enemies,collectibles,spriteVelocity, this);
        this.collectible_value = gameParameters.getCollectible_value();
    }

    public void update(float delta) {
        switch(currentState) {
            case TITLE:
            default:
                updateTitle(delta);
                break;

            case INGAME:
                updateInGame(delta);
                break;
            case GAMEOVER:
                updateGameOver(delta);
                break;
        }
    }

    public void updateTitle(float delta) {

    }

    public void updateInGame(float delta) {
        runner.update(delta);

        obstacleManager.update(delta,width,difference);

        // Score
        inc_score(delta);

        // Collisions
        checkCollisions();
    }

    public void restart() {
        this.score = 0;
        currentState = GameState.TITLE;

        runner.setX(50);
        runner.setY(ground.getY() - runner.getHeight());

        for (Obstacle o : obstacleManager.getEnemies()) {
            o.resetPos(this.width, this.difference);
        }

        for (Obstacle o : obstacleManager.getCollectables()) {
            o.resetCPos(this.width, this.difference);
        }
    }

    public void updateGameOver(float delta) {

    }

    public boolean isTitle() {
        return currentState == GameState.TITLE;
    }

    public boolean isGameOver() {
        return currentState == GameState.GAMEOVER;
    }

    public boolean isInGame() {
        return currentState == GameState.INGAME;
    }

    public void start() {
        currentState = GameState.INGAME;
    }

    public void inc_score(float delta) {
        timer += delta;

        if (timer >= score_rate) {
            score += 1;
            timer -= score_rate;
        }
    }

    public void checkCollisions() {
        if (ground.collides(runner)) {
            runner.setY(ground.getY() - runner.getHeight());
        }

        for(Obstacle o : obstacleManager.getEnemies()){
            if (o.collides(runner)) {
                currentState = GameState.GAMEOVER;
                AssetLoader.gameOver.play();

            }
        }

        for(Obstacle o : obstacleManager.getCollectables()){
            if (o.collides(runner)) {
                this.score += collectible_value;
                o.resetCPos(this.width, this.difference);
                AssetLoader.pickup.play();
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

    public int getScore() {
        return this.score;
    }

    public ObstacleManager getObstaclesManager(){return this.obstacleManager; }
}
