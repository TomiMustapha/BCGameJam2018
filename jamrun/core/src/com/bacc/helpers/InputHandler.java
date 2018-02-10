package com.bacc.helpers;

import com.bacc.gameworld.GameWorld;
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
        if (world.getGround().collides(world.getRunner())) {
            world.getRunner().onPress();
            return true;
        }

        return false;
    }

    @Override
    public boolean keyDown(int keycode) {
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
