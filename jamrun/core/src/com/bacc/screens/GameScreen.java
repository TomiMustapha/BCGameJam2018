package com.bacc.screens;

import com.bacc.gameworld.GameRenderer;
import com.bacc.gameworld.GameWorld;
import com.bacc.helpers.InputHandler;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;

/**
 * Created by danestrin on 2018-02-09.
 */
public class GameScreen implements Screen {

    private GameWorld world;
    private GameRenderer renderer;

    private float runTime;

    public GameScreen() {

        float screenWidth = Gdx.graphics.getWidth();
        float screenHeight = Gdx.graphics.getHeight();
        float gameWidth = 320;
        float gameHeight = screenHeight / (screenWidth / gameWidth);

        world = new GameWorld(gameWidth, gameHeight);
        renderer = new GameRenderer(world);

        Gdx.input.setInputProcessor(new InputHandler(world));
    }

    @Override
    public void render(float delta) {
        runTime += delta;
        world.update(delta);
        renderer.render(runTime);
    }

    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void show() {
    }

    @Override
    public void hide() {
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void dispose() {
        // Leave blank
    }
}
