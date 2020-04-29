/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lug.surviveoutbreak;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;




/**
 *
 * @author armandoroque
 */
public class LevelOneScreen implements Screen {
    final SurviveOutbreak game;
    Texture img;
    GL20 gl;
    Texture myTexture;
    
    OrthographicCamera camera;

    private Music backMusic;

    private Rectangle chari;

    private Vector3 touchPos;
    
    private Stage stage;
    
    public LevelOneScreen(final SurviveOutbreak game) {
        this.game = game;
        img = new Texture(Gdx.files.internal("enemigo.png"));
        gl = Gdx.graphics.getGL20();
        Gdx.app.log("MyTag", "my informative message");
        backMusic = Gdx.audio.newMusic(Gdx.files.internal("sounds/mkt.wav"));
        backMusic.setLooping(true);
        //backMusic.play();

        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);

        chari = new Rectangle();
        chari.x = 800 / 2 - 64 / 2;
        chari.y = 20;
        chari.width = 64;
        chari.height = 64;

        touchPos = new Vector3();
        
        
    }

    @Override
    public void show() {
        backMusic.play();
        
        //stage = new Stage(new FitViewport(9,16));
    }

    @Override
    public void render(float f) {
        if (Gdx.input.isTouched()) {
            System.out.println("Input occurred at x=" + Gdx.input.getX() + ", y=" + Gdx.input.getY());
        }

        Gdx.gl.glClearColor(0, 0, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        camera.update();

        game.batch.setProjectionMatrix(camera.combined);
        game.batch.begin();
        game.batch.draw(img, chari.x, chari.y, chari.width, chari.height);
        game.batch.end();

        if (Gdx.input.isTouched()) {

            touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
            camera.unproject(touchPos);
            chari.x = touchPos.x - 64 / 2;
        }

        if (Gdx.input.isKeyPressed(Keys.LEFT)) {
            chari.x -= 200 * Gdx.graphics.getDeltaTime();
        }
        if (Gdx.input.isKeyPressed(Keys.RIGHT)) {
            chari.x += 200 * Gdx.graphics.getDeltaTime();
        }
        if (chari.x < 0) {
            chari.x = 0;
        }
        if (chari.x > 800 - 64) {
            chari.x = 800 - 64;
        }
    }

    @Override
    public void resize(int i, int i1) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void pause() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void resume() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void hide() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void dispose() {
        img.dispose();
        backMusic.dispose();    
    }
    
}
