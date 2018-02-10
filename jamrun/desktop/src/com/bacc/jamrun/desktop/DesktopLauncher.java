package com.bacc.jamrun.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.bacc.jamrun.JamRun;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		new LwjglApplication(new JamRun(), config);
		config.title = "Fat Boy Szn";
		config.width = 640;
		config.height = 320;
	}
}
