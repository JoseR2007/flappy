package es.joser.flappy.models;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;

public class Pipeline extends Sprite {
    private Rectangle box;
    private float posX;
    private float posY;

    private static final float velocity = 5f;

    public Pipeline (TextureRegion sprite) {
        super(sprite);
        this.posX = 0;
        this.posY = 0;
        this.box = new Rectangle(this.posX, this.posY, this.getWidth(), this.getHeight());
    }

    public void update(float delta) {
        this.posX -= (velocity * delta);
        this.setX(this.posX);
    }

    public void render(SpriteBatch batch) {
        this.draw(batch);
    }

    public boolean isOffScreen() {
        boolean result = false;
        if ((this.getWidth() + this.getX()) < 0)
            result = true;
        return result;
    }
}
