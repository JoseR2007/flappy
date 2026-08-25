package es.joser.flappy.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import es.joser.flappy.handlers.PipeHandler;
import es.joser.flappy.models.Player;


public class LevelScreen extends ScreenAdapter {
    private Player player;
    private Game game;
    private OrthographicCamera cam;
    private PipeHandler pipes;
    private SpriteBatch batch;

    public LevelScreen(Game game) {
        this.game = game;
        this.cam = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        this.cam.setToOrtho(false);
        this.batch = new SpriteBatch();

        this.pipes = new PipeHandler(this.batch);
    }

    @Override
    public void show() {
        super.show();
    }

    @Override
    public void render(float delta) {
        this.batch.setProjectionMatrix(this.cam.combined);
        this.pipes.updatePipes(delta);

        this.batch.begin();
        this.pipes.drawPipes();
        this.batch.end();
    }

    @Override
    public void dispose() {
        super.dispose();
    }
}
