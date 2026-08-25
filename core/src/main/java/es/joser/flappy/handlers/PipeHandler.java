package es.joser.flappy.handlers;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;
import es.joser.flappy.models.Pipeline;

public class PipeHandler {
    private Array<Pipeline> pipes;
    private SpriteBatch batch;

    public static final float initialPosPipes = 30f;
    private static final int cantPipes = 5;
    private static final int minHeightPipe = 20;
    private static final int maxHeightPipe = 50;
    private static final int rangeHeightPipe = (maxHeightPipe - minHeightPipe) + 1;
    private static final float distanceBetweenPipes = 30f;

    public PipeHandler(SpriteBatch batch) {
        this.pipes = new Array<Pipeline>();
        this.batch = batch;
    }

    // managment:
    private Pipeline generatePipe() {
        int height = (int) (Math.random() * rangeHeightPipe) + minHeightPipe;
        Pixmap pix = new Pixmap(20, height, Pixmap.Format.RGBA8888);
        pix.setColor(Color.YELLOW);
        pix.fill();

        return new Pipeline(new TextureRegion(new Texture(pix)));
    }

    public void updatePipes(float delta) {
        for (Pipeline pipe : this.pipes) {
            if (pipe.isOffScreen())
                this.reusePipe(pipe);
            else
                pipe.update(delta);
        }
    }

    public void createPipes() {
        for (int ind = 0; ind < cantPipes; ind++)
            this.pipes.add(this.generatePipe());
    }

    public void drawPipes() {
        for (Pipeline pipe : this.pipes)
            pipe.draw(this.batch);
    }

    public void reusePipe(Pipeline pipe) {
        pipe.setX(PipeHandler.initialPosPipes);
        int height = (int) (Math.random() * rangeHeightPipe) + minHeightPipe;
        pipe.setRegionHeight(height);
    }
}
