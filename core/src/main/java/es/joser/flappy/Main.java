package es.joser.flappy;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import es.joser.flappy.screens.LevelScreen;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Main extends Game {
    private SpriteBatch batch;

    @Override
    public void create() {
        batch = new SpriteBatch();
        setScreen(new LevelScreen(this));
    }

    @Override
    public void dispose() {
        batch.dispose();
    }
}
