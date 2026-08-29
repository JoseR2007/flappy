package es.joser.flappy.models;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;

public class Pipeline extends Sprite {
    private Rectangle box;
    private float posX;

    private static final float velocity = 20f;

    public Pipeline (TextureRegion sprite, float initPosX) {
        super(sprite);
        this.posX = initPosX;
        this.setPosition(this.posX, 0);
        this.box = new Rectangle(this.posX, 0, this.getWidth(), this.getHeight());
    }

    public Rectangle getBox() {
        return this.box;
    }

    public void setPosx(float posx) {
        this.posX = posx;

        this.setPosition(this.posX, 0);
        this.box.setX(this.posX);
    }

    public float getPosX() {
        return this.posX;
    }

    public void update(float delta) {
        this.posX -= (velocity * delta);

        this.setPosition(this.posX, 0);
        this.box.setX(this.posX);
    }

    public void render(SpriteBatch batch) {
        this.draw(batch);
    }

    public boolean isOffScreen() {
        return (this.getWidth() + this.getPosX()) < 0;
    }
}
