package es.joser.flappy.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import es.joser.flappy.SpriteManager;
import es.joser.flappy.handlers.InputPlayer;
import es.joser.flappy.handlers.PipeHandler;
import es.joser.flappy.handlers.VirtualController;
import es.joser.flappy.models.Player;

public class LevelScreen extends ScreenAdapter {
    private VirtualController controller;
    private InputPlayer inputPlayer;
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

        this.player = new Player(SpriteManager.getInstance().getSpritePlayer(), Gdx.graphics.getHeight());
        this.controller = new VirtualController();
        this.inputPlayer = new InputPlayer(this.controller);
        this.pipes = new PipeHandler(this.batch);
        Gdx.input.setInputProcessor(inputPlayer);
    }

    @Override
    public void show() {
        super.show();
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        this.processInput();
        this.player.update(delta);

        this.pipes.updatePipes(delta);
        this.batch.setProjectionMatrix(this.cam.combined);

        this.batch.begin();
        this.pipes.drawPipes();
        this.player.draw(this.batch);
        this.batch.end();
    }

    public void processInput() {
        if (!this.controller.isFalling())
            this.player.jump();
    }

    @Override
    public void dispose() {
        this.batch.dispose();
        super.dispose();
    }
}
