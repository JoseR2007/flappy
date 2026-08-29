package es.joser.flappy.models;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Player extends Sprite {
    private int score;
    private float currentVelocity;
    private float limitTop;

    private static final float gravity = 40f;
    private static final float jumpImpulse = 25f;

    public Player(TextureRegion sprite, float viewportHeight) {
        super(sprite);

        this.setPosition(20, 20);
        this.limitTop = viewportHeight - sprite.getRegionHeight();
        this.score = 0;
        this.currentVelocity = 0f;
    }

    /* Getters */
    public int getScore() {
        return this.score;
    }

    public int incrementScore() {
        this.score++;
        return this.score;
    }

    public void jump() {
        this.currentVelocity = jumpImpulse;
    }

    public void update(float delta) {
        float posY = this.getY()
            + this.currentVelocity * delta
            - 0.5f * gravity * delta * delta;

        this.currentVelocity -= gravity * delta;

        if (posY >= this.limitTop) {
            posY = this.limitTop - 1;
            this.currentVelocity = 0f;
        } else if (posY <= 0) {
            posY = 0;
            this.currentVelocity = 0f;
        }

        this.setPosition(20, posY);
    }
}
