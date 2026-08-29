package es.joser.flappy.handlers;

public class VirtualController {
    private boolean falling;

    public VirtualController() {
        this.falling = true;
    }

    /* Getters */
    public boolean isFalling() {
        return this.falling;
    }

    /* Setters */
    public void setFalling(boolean value) {
        this.falling = value;
    }
}
