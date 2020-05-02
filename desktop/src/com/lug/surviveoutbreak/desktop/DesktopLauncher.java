package com.lug.surviveoutbreak.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.lug.surviveoutbreak.SurviveOutbreak;

public class DesktopLauncher {

    public static void main(String[] arg) {
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.title = "Survive The Outbreak";
        config.width = 3000;
        config.height = 2000;
        //config.fullscreen = true;

        new LwjglApplication(new SurviveOutbreak(), config);
    }
}
