package es.joser.flappy;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class SpriteManager {
    private static SpriteManager instance;

    private TextureRegion spritePlayer;
    private TextureRegion spritePipeline;
    private TextureRegion background;

    public SpriteManager() {
        Pixmap pixPlaye = new Pixmap(10, 10, Pixmap.Format.RGBA8888);
        pixPlaye.setColor(Color.RED);
        pixPlaye.fill();

        this.spritePlayer = new TextureRegion(new Texture(pixPlaye));
    }

    public static SpriteManager getInstance() {
        if (instance == null)
            instance = new SpriteManager();
        return instance;
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
