package engine.gui;

import engine.geomentry.Trajectory;
import engine.parser.Parser;
import javafx.scene.canvas.Canvas;

import java.util.List;

public class Texture {

    public enum TextureType {
        OBJECT,
        STATIC
    }

    private Trajectory trajectory;
    private Canvas canvas;
    private TextureType textureType;

    public Texture(List<String> rawTextureStrings) {
        Parser parser = new Parser(rawTextureStrings);
        trajectory = new Trajectory(parser.getPixels());
        canvas = new Canvas(parser.getWidth(), parser.getHeight());
        textureType = parser.getTextureType();
    }

    public Trajectory getTrajectory() {
        return trajectory;
    }

    public Canvas getCanvas() {
        return canvas;
    }
}
