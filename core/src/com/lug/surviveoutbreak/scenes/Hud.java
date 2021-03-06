package com.lug.surviveoutbreak.scenes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.lug.surviveoutbreak.SurviveOutbreak;

public class Hud {
    public Stage stage;
    private Viewport viewport;

    public FreeTypeFontGenerator fontGenerator;
    public FreeTypeFontGenerator.FreeTypeFontParameter fontParameter;

    private Integer worldTimer;
    private float timeCount;
    private Integer score;

    Label countdownLabel;
    Label scoreLabel;
    Label timeLabel;
    Label levelLabel;
    Label worldLabel;
    Label marioLabel;

    public Hud(SpriteBatch sb) {
        worldTimer = 300;
        timeCount = 0;
        score = 0;
        viewport = new FitViewport(SurviveOutbreak.V_WIDTH, SurviveOutbreak.V_HEIGHT, new OrthographicCamera());
        stage = new Stage(viewport, sb);

        Table table = new Table();
        table.top();
        table.setFillParent(true);

        fontGenerator = new FreeTypeFontGenerator(Gdx.files.internal("fonts/GloriaHallelujah-Regular.ttf"));
        fontParameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        fontParameter.size = 30;
        BitmapFont font30 = fontGenerator.generateFont(fontParameter);

        countdownLabel = new Label(String.format("%03d", worldTimer), new Label.LabelStyle(font30, Color.WHITE));
        scoreLabel = new Label(String.format("%06d", score), new Label.LabelStyle(font30, Color.WHITE));
        timeLabel = new Label("TIME", new Label.LabelStyle(font30, Color.WHITE));
        levelLabel = new Label("1-1", new Label.LabelStyle(font30, Color.WHITE));
        worldLabel = new Label("WORLD", new Label.LabelStyle(font30, Color.WHITE));
        marioLabel = new Label("MARIO", new Label.LabelStyle(font30, Color.WHITE));

        table.add(marioLabel).expandX().padTop(10);
        table.add(worldLabel).expandX().padTop(10);
        table.add(timeLabel).expandX().padTop(10);

        table.row();
        table.add(scoreLabel).expandX();
        table.add(levelLabel).expandX();
        table.add(countdownLabel).expandX();

        stage.addActor(table);
    }
}
