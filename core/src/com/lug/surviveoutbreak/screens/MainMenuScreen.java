/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lug.surviveoutbreak.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthoCachedTiledMapRenderer;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.lug.surviveoutbreak.LevelOneScreen;
import com.lug.surviveoutbreak.SurviveOutbreak;
import com.lug.surviveoutbreak.scenes.Hud;

public class MainMenuScreen implements Screen {

    private SurviveOutbreak game;

    private OrthographicCamera camera;

    private Skin skin;
    private Viewport gamePort;

    private Stage stage;

    private Hud hud;

    private TmxMapLoader maploader;
    private TiledMap map;
    private OrthogonalTiledMapRenderer renderer;

    public MainMenuScreen(final SurviveOutbreak game) {
        this.game = game;

        skin = new Skin();

        game.fontParameter.size = 30;
        BitmapFont font30 = game.fontGenerator.generateFont(game.fontParameter);
        skin.add("gloria", font30);

        skin.addRegions(new TextureAtlas("skins/skin-test.atlas"));
        skin.load(Gdx.files.internal("skins/skin-test.json"));

        //skin = new Skin(Gdx.files.internal("skins/skin-test.json"));
        System.out.println("Got here");
        camera = new OrthographicCamera();
        gamePort = new FitViewport(SurviveOutbreak.V_WIDTH, SurviveOutbreak.V_HEIGHT, camera);
        //camera.setToOrtho(false, 800, 480);

        stage = new Stage(gamePort);


        
        hud = new Hud(game.batch);

        final TextButton button = new TextButton("Click me", skin, "default");
        //final Button button = new Button(skin);
        button.setWidth(200f);
        button.setHeight(50f);
        button.setPosition(gamePort.getWorldWidth() /2 - 100f, gamePort.getWorldHeight()/2 - 10f);



        button.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y){
                button.setText("You clicked the button");
            }
        });

        stage.addActor(button);

        Gdx.input.setInputProcessor(stage);

        /*
        maploader = new TmxMapLoader();
        map = maploader.load("name");
        renderer = new OrthoCachedTiledMapRenderer(map);
        camera.position.set(gamePort.getWorldWidth() / 2, gamePort.getWorldHeight() / 2, 0);

         */
    }

    @Override
    public void render(float delta) {
        update(delta);

        Gdx.gl.glClearColor(0, 0, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        //renderer.render();

        //game.batch.setProjectionMatrix(camera.combined);
        game.batch.setProjectionMatrix(hud.stage.getCamera().combined);
        hud.stage.draw();



        game.batch.begin();
        stage.draw();
        //game.font.draw(game.batch, "Welcome to SurviveOutbreak!!! ", 100, 150);
        //game.font.draw(game.batch, "Tap anywhere to begin!", 100, 100);
        game.batch.end();




    }

    @Override
    public void dispose() {

    }

    public void handleInput(float dt) {
        // this is from mario
        if (Gdx.input.isTouched()) {
            //game.setScreen(new PlayScreen(game));
            //dispose();
        }
    }

    public void update (float dt) {
        handleInput(dt);

        camera.update();
        //renderer.setView(camera);
    }

    @Override
    public void show() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

    }

    @Override
    public void resize(int width, int height) {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        gamePort.update(width, height, true);
    }

    @Override
    public void pause() {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void resume() {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void hide() {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

    }

}
