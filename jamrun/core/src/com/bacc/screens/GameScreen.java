package com.bacc.screens;

import com.bacc.gameworld.GameRenderer;
import com.bacc.gameworld.GameWorld;
import com.badlogic.gdx.Screen;

/**
 * Created by danestrin on 2018-02-09.
 */
public class GameScreen implements Screen {

    private GameWorld world;
    private GameRenderer renderer;

    public GameScreen() {

        world = new GameWorld();
        renderer = new GameRenderer(world);
    }

    @Override
    public void render(float delta) {
        world.update(delta);
        renderer.render();
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
