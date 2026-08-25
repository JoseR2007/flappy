package es.joser.flappy.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import es.joser.flappy.models.Pipeline;
import es.joser.flappy.models.Player;

import java.awt.*;
import java.util.ArrayList;

public class LevelScreen extends ScreenAdapter {
    private Player player;
    private Game game;
    private OrthographicCamera cam;
    private SpriteBatch batch;

    public LevelScreen(Game game) {
        this.game = game;
        this.cam = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        this.cam.setToOrtho(false);
        this.batch = new SpriteBatch();
    }

    @Override
    public void show() {
        super.show();
    }

    @Override
    public void render(float delta) {
        this.batch.setProjectionMatrix(this.cam.combined);


        this.batch.begin();
        this.batch.end();
    }

    @Override
    public void dispose() {
        super.dispose();
    }
}
