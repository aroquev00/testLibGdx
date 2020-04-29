/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lug.surviveoutbreak;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.utils.Array;

/**
 *
 * @author armandoroque
 */
public class Player extends BaseActor {

    Animation north;
    Animation south;
    Animation east;
    Animation west;

    public Player(float x, float y, Stage s) {
        super(x, y, s);
        String fileName = "assets/hero.png";
        // rollo para sacar el monito
    }

    public void act(float dt) {
        super.act(dt);

        if (Gdx.input.isKeyPressed(Keys.LEFT)) {
            accelerateAtAngle(180);
        }
        if (Gdx.input.isKeyPressed(Keys.RIGHT)) {
            accelerateAtAngle(0);
        }
        if (Gdx.input.isKeyPressed(Keys.UP)) {
            accelerateAtAngle(90);
        }
        if (Gdx.input.isKeyPressed(Keys.DOWN)) {
            accelerateAtAngle(270);
        }

        // pause animation when character not moving
        if (getSpeed() == 0) {
            setAnimationPaused(true);
        } else {
            setAnimationPaused(false);// set direction animation
            float angle = getMotionAngle();
            if (angle >= 45 && angle <= 135) {
                setAnimation(north);
            } else if (angle > 135 && angle < 225) {
                setAnimation(west);
            } else if (angle >= 225 && angle <= 315) {
                setAnimation(south);
            }
            else
                setAnimation(east);
        }
        applyPhysics(dt);
    }

}
