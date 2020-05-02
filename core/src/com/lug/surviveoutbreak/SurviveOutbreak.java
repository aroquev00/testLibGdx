package com.lug.surviveoutbreak;

import com.badlogic.gdx.graphics.g2d.freetype.FreeType;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.lug.surviveoutbreak.screens.MainMenuScreen;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class SurviveOutbreak extends Game {
    public static final int V_WIDTH = 1920;
    public static final int V_HEIGHT = 1080;

    //private OrthographicCamera camera;
    public SpriteBatch batch;

    public FreeTypeFontGenerator fontGenerator;
    public FreeTypeFontGenerator.FreeTypeFontParameter fontParameter;


    public BitmapFont font;

    private Stage stage;

    @Override
    public void create() {


        batch = new SpriteBatch();
        font = new BitmapFont();

        fontGenerator = new FreeTypeFontGenerator(Gdx.files.internal("fonts/GloriaHallelujah-Regular.ttf"));
        fontParameter = new FreeTypeFontGenerator.FreeTypeFontParameter();

        //stage = new Stage(new ScreenViewport());
        this.setScreen(new MainMenuScreen(this));

        //Texture tex = new Texture("enemigo.png");
        //Image image1 = new Image(tex);
        //image1.setPosition(0,0);
        //stage.addActor(image1);
        
        /*
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
         */
    }

    @Override
    public void render() {
        //Gdx.gl.glClearColor(1, 1, 1, 1);
        //Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        //stage.act();
        //stage.draw();
        
        super.render();
        /*
        if (Gdx.input.isTouched()) {
            System.out.println("Input occurred at x=" + Gdx.input.getX() + ", y=" + Gdx.input.getY());
        }

        Gdx.gl.glClearColor(0, 0, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        camera.update();

        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        batch.draw(img, chari.x, chari.y);
        batch.end();

        if (Gdx.input.isTouched()) {

            touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
            camera.unproject(touchPos);
            chari.x = touchPos.x - 64 / 2;
        }

        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            chari.x -= 200 * Gdx.graphics.getDeltaTime();
        }
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            chari.x += 200 * Gdx.graphics.getDeltaTime();
        }
        if (chari.x < 0) {
            chari.x = 0;
        }
        if (chari.x > 800 - 64) {
            chari.x = 800 - 64;
        }

         */
    }

    @Override
    public void dispose() {
        batch.dispose();
        font.dispose();
        screen.dispose();
        fontGenerator.dispose();
    }
}
