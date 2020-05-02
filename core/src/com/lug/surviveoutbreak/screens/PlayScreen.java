package com.lug.surviveoutbreak.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthoCachedTiledMapRenderer;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import com.lug.surviveoutbreak.Sprites.Hero;
import com.lug.surviveoutbreak.SurviveOutbreak;
import com.lug.surviveoutbreak.scenes.Hud;


public class PlayScreen implements Screen {

    private SurviveOutbreak game;

    private OrthographicCamera gameCam;
    private Viewport gamePort;
    private Hud hud;

    // Tiled map variables
    private TmxMapLoader maploader;
    private TiledMap map;
    private OrthogonalTiledMapRenderer renderer;

    // Box2d variables
    private World world;
    private Box2DDebugRenderer b2dr;

    Texture texture;

    private Hero hero;


    public PlayScreen(SurviveOutbreak game) {
        this.game = game;

        // create cam used to follow player through the world.
        gameCam = new OrthographicCamera();

        // create a FitViewport to maintain visual aspect ratio despire screen
        gamePort = new FitViewport(SurviveOutbreak.V_WIDTH, SurviveOutbreak.V_HEIGHT, gameCam);

        // create game HUD for score/timers/level info
        hud = new Hud(game.batch);

        // load map and setup map renderer
        maploader = new TmxMapLoader();
        map = maploader.load("tileMaps/STO.tmx");
        renderer = new OrthogonalTiledMapRenderer(map);

        // initially set gamecam to be centered correctly at middle of screen
        gameCam.position.set(gamePort.getWorldWidth() / 2, gamePort.getWorldHeight() / 2, 0);


        world = new World(new Vector2(0,0), true);
        b2dr = new Box2DDebugRenderer();

        BodyDef bdef = new BodyDef();
        PolygonShape shape = new PolygonShape();
        FixtureDef fdef = new FixtureDef();
        Body body;

        // create walls bodies/fixtures

        for (MapObject object : map.getLayers().get(2).getObjects().getByType(RectangleMapObject.class)) {
            Rectangle rect = ((RectangleMapObject) object).getRectangle();

            bdef.type = BodyDef.BodyType.StaticBody;
            bdef.position.set(rect.getX() + rect.getWidth() / 2, rect.getY() + rect.getHeight() / 2);

            body = world.createBody(bdef);

            shape.setAsBox(rect.getWidth() / 2, rect.getHeight() / 2);
            fdef.shape = shape;
            body.createFixture(fdef);
        }



        // create objects bodies/fixtures
        /*
        for (MapObject object : map.getLayers().get(0).getObjects().getByType(RectangleMapObject.class)) {
            Rectangle rect = ((RectangleMapObject) object).getRectangle();

            bdef.type = BodyDef.BodyType.StaticBody;
            bdef.position.set(rect.getX() + rect.getWidth() / 2, rect.getY() + rect.getHeight() / 2);

            body = world.createBody(bdef);

            shape.setAsBox(rect.getWidth() / 2, rect.getHeight() / 2);
            fdef.shape = shape;
            body.createFixture(fdef);
        }

         */

        hero = new Hero(world);

        texture = new Texture("enemigo.png");


    }

    @Override
    public void show() {

    }

    public void handleInput(float dt) {
        // this is from mario game example to move camera across map
        if (Gdx.input.isTouched()) {
            //gameCam.position.x += 100 * dt;
        }
    }

    public void update (float dt) {
        handleInput(dt);

        world.step(1/60f, 6, 2);

        gameCam.update();
        renderer.setView(gameCam);
    }


    @Override
    public void render(float delta) {
        update(delta);

        Gdx.gl.glClearColor(0, 0, 0 , 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        renderer.render();

        // renderer our Box2DDebugLines
        b2dr.render(world, gameCam.combined);

        game.batch.setProjectionMatrix(hud.stage.getCamera().combined);
        hud.stage.draw();

        /*
        game.batch.begin();
        game.batch.draw(texture, 0, 0);
        game.batch.end();

         */
    }

    @Override
    public void resize(int width, int height) {
        gamePort.update(width, height, true);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
