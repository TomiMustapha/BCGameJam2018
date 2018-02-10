package com.bacc.helpers;

/**
 * Created by danestrin on 2018-02-10.
 */

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

;

public class AssetLoader {

    public static Texture texture;

    public static Animation<TextureRegion>runAnim;
    public static TextureRegion dude1, dude2, dude3;

    public static TextureRegion bg, ground, apple;

    public static void load() {

        texture = new Texture(Gdx.files.internal("data/texture.png"));

        texture.setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.Nearest);
        dude1 = new TextureRegion(texture, 0, 0, 18, 32);
        dude1.flip(false, true);
        dude2 = new TextureRegion(texture, 18, 0, 18, 32);
        dude2.flip(false, true);
        dude3 = new TextureRegion(texture, 36, 0, 18, 32);
        dude3.flip(false, true);

        bg = new TextureRegion(texture, 0, 32, 320, 160);
        ground = new TextureRegion(texture, 0, 192, 320, 32);
        ground.flip(false, true);

        apple = new TextureRegion(texture, 36, 0, 12, 12);

        TextureRegion[] dudes = { dude1, dude2, dude3 };
        runAnim = new Animation<TextureRegion>(0.12f, dudes);
        runAnim.setPlayMode(Animation.PlayMode.LOOP_PINGPONG);
    }

    public static void dispose() {
        // We must dispose of the texture when we are finished.
        texture.dispose();
    }

}
