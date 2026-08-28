package es.joser.flappy.handlers;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;
import es.joser.flappy.SpriteManager;
import es.joser.flappy.models.Pipeline;

import java.io.PipedInputStream;

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

        this.createPipes();
    }

    // managment:
    private Pipeline generatePipe(float ultimateX) {
        int height = (int) (Math.random() * rangeHeightPipe) + minHeightPipe;
        return new Pipeline(SpriteManager.getInstance().generateSpritePipe(height), ultimateX + distanceBetweenPipes);
    }

    public void updatePipes(float delta) {
        Pipeline pipe = null;
        for (int ind = 0; ind < this.pipes.size; ind++) {
            pipe = this.pipes.get(ind);
            if (pipe.isOffScreen())
                this.reusePipe(pipe);
            else
                pipe.update(delta);
        }
    }

    public void createPipes() {
        float ultimateX = PipeHandler.initialPosPipes;

        for (int ind = 0; ind < cantPipes; ind++) {
            ultimateX = PipeHandler.initialPosPipes * (ind + 1);
            this.pipes.add(this.generatePipe(ultimateX));
        }
    }

    public void drawPipes() {
        for (Pipeline pipe : this.pipes)
            pipe.draw(this.batch);
    }

    public void reusePipe(Pipeline pipe) {
        float max = this.getMaxPosX();

        pipe.setPosx(max + PipeHandler.distanceBetweenPipes);
        int height = (int) (Math.random() * rangeHeightPipe) + minHeightPipe;
        pipe.setSize(20, height);
    }

    public float getMaxPosX() {
        float result = this.pipes.get(0).getPosX();

        Pipeline pipe = null;
        for (int ind = 0; ind < this.pipes.size; ind++) {
            pipe = this.pipes.get(ind);
            if (pipe.getPosX() > result)
                result = pipe.getPosX();
        }

        return result;
    }
}
