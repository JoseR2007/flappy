package es.joser.flappy.handlers;

public class VirtualController {
    private boolean falling;
    private boolean jump;

    public VirtualController() {
        this.falling = true;
        this.jump = false;
    }

    /* Getters */
    public boolean isFalling() {
        return this.falling;
    }

    public boolean isJump() {
        return this.jump;
    }

    /* Setters */
    public void setFalling(boolean value) {
        this.falling = value;
    }

    public void setJump(boolean value) {
        this.jump = value;
    }
}
