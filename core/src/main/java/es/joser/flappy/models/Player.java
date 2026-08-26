package es.joser.flappy.models;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Player extends Sprite {
    private int score;
    private float currentVelocity;

    private static final float gravity = 9.81f;
    private static final float verticalAccelation = 18.6f;
    private static final float timeJumping = 2f;

    public Player(TextureRegion sprite) {
        super(sprite);

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

    public void update(float delta, boolean isFalling) {
        float posY = this.getY(), velocity = this.currentVelocity;

        if (isFalling) {
            posY = (float) (this.getY() + this.currentVelocity*(delta) - 0.5*gravity*(delta*delta));
            velocity = this.currentVelocity - gravity*(delta);
        } else {
            posY = (float) (this.getY() + this.currentVelocity*(delta) + 0.5*(verticalAccelation - gravity)*(delta*delta));
            velocity = this.getY() + (verticalAccelation - gravity)*(delta);
        }
        this.setY(posY);
        this.currentVelocity = velocity;
    }
}
