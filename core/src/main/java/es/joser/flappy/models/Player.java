package es.joser.flappy.models;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Player extends Sprite {
    private int score;
    private float currentVelocity;
    private float limitTop;

    private static final float gravity = 9.81f;
    private static final float jumpImpulse = 12f;

    public Player(TextureRegion sprite, float viewportHeight) {
        super(sprite);

        this.setPosition(20, 20);
        this.limitTop = viewportHeight - 10;
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
        this.currentVelocity = jumpImpulse; // no depende de delta ni de frames
    }

    public void update(float delta) {
        float posY = this.getY()
            + this.currentVelocity * delta
            - 0.5f * gravity * delta * delta;

        this.currentVelocity -= gravity * delta;

        if (posY >= this.limitTop) {
            posY = this.limitTop - 1;
            this.currentVelocity = 0f;
        }

        this.setPosition(20, posY);
    }
}
