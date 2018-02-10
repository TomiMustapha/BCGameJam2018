package com.bacc.jamrun;

import com.bacc.screens.GameScreen;
import com.badlogic.gdx.Game;

public class JamRun extends Game {

    @Override
    public void create() {
        setScreen(new GameScreen());
    }

}
