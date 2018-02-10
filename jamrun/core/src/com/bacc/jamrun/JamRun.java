package com.bacc.jamrun;

import com.bacc.helpers.AssetLoader;
import com.bacc.screens.GameScreen;
import com.badlogic.gdx.Game;

public class JamRun extends Game {

    @Override
    public void create() {
        AssetLoader.load();
        setScreen(new GameScreen());
    }

    @Override
    public void dispose() {
        super.dispose();
        AssetLoader.dispose();
    }
}
