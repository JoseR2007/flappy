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
import java.nio.channels.Pipe;
import java.util.ArrayList;

public class LevelScreen extends ScreenAdapter {
    private Player player;
    private Game game;
    private OrthographicCamera cam;
    private SpriteBatch batch;
    private ArrayList<Pipeline> pipes;

    private static final int minHeightPipe = 20;
    private static final int maxHeightPipe = 50;
    private static final int rangeHeightPipe = 50 - 20 + 1;

    public LevelScreen(Game game) {
        this.game = game;
        this.cam = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        this.cam.setToOrtho(false);
        this.batch = new SpriteBatch();
        this.pipes = new ArrayList<Pipeline>();
    }

    @Override
    public void show() {
        super.show();
    }

    @Override
    public void render(float delta) {
        this.updatePipes(delta);
        this.batch.setProjectionMatrix(this.cam.combined);


        this.batch.begin();
        for (Pipeline pipe : this.pipes) pipe.render(this.batch);
        this.batch.end();
    }

    @Override
    public void dispose() {
        super.dispose();
    }

    public void updatePipes(float delta) {
        for (Pipeline pipe : this.pipes) {
            pipe.update(delta);
        }
    }

    private Pipeline generatePipe() {
        int height = (int) (Math.random() * rangeHeightPipe) + minHeightPipe;
        Pixmap pix = new Pixmap(20, height, Pixmap.Format.RGBA8888);
        pix.setColor(Color.YELLOW);
        pix.fill();

        Pipeline result = new Pipeline(new TextureRegion(new Texture(pix)));
        return result;
    }
}
