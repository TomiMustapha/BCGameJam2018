package com.bacc.helpers;

import com.bacc.gameworld.GameWorld;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;

/**
 * Created by danestrin on 2018-02-09.
 */

public class InputHandler implements InputProcessor {

    private GameWorld world;

    public InputHandler(GameWorld world) {

        this.world = world;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean keyDown(int keycode) {
        if (world.getGround().collides(world.getRunner()) && Gdx.input.isKeyJustPressed(Input.Keys.SPACE) && world.isInGame()) {
            world.getRunner().onPress();
            return true;
        } else if (world.isTitle() && Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
            world.start();
        } else if (world.isGameOver() && Gdx.input.isKeyJustPressed(Input.Keys.SPACE)){
            world.restart();
        }

        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }

}
