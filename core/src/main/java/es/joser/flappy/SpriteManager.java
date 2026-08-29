package es.joser.flappy;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import javax.swing.*;

public class SpriteManager {
    private static SpriteManager instance;

    private TextureRegion spritePlayer;
    private TextureRegion spritePipeline;
    private TextureRegion background;

    public static final int widthPipe = 40;
    public static final int playerWidth = 30;
    public static final int playerHeight = 30;

    public SpriteManager() {
    }

    public static SpriteManager getInstance() {
        if (instance == null)
            instance = new SpriteManager();
        return instance;
    }

    public TextureRegion generateSpriteTestPlayer() {
        Pixmap pixPlayer = new Pixmap(SpriteManager.playerWidth, SpriteManager.playerHeight, Pixmap.Format.RGBA8888);
        pixPlayer.setColor(Color.RED);
        pixPlayer.fill();

        return new TextureRegion(new Texture(pixPlayer));
    }

    public TextureRegion generateSpritePipe(int height) {
        Pixmap pix = new Pixmap(SpriteManager.widthPipe, (int) height, Pixmap.Format.RGBA8888);
        pix.setColor(Color.YELLOW);
        pix.fill();

        return new TextureRegion(new Texture(pix));
    }

    public TextureRegion getSpritePlayer() {
        return this.spritePlayer;
    }

    public TextureRegion getSpritePipeline() {
        return this.spritePipeline;
    }

    public TextureRegion getBackground() {
        return this.background;
    }
}
