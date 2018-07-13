package engine.gui;

import engine.geomentry.Trajectory;
import engine.parser.Parser;
import engine.physics.BorderRectangle;
import engine.physics.Physics;
import javafx.scene.canvas.Canvas;

import java.util.List;

public class Texture {

    public enum TextureType {
        OBJECT,
        STATIC;
    }

    private Trajectory trajectory;

    private Canvas canvas;
    private TextureType textureType;
    private BorderRectangle borderRectangle;

    public Texture(List<String> rawTextureStrings) {
        Parser parser = new Parser(rawTextureStrings);
        trajectory = new Trajectory(parser.getPixels());
        canvas = new Canvas(parser.getWidth(), parser.getHeight());
        textureType = parser.getTextureType();
        borderRectangle = new BorderRectangle(
                (int) canvas.getLayoutX(),
                (int) canvas.getLayoutY(),
                (int) canvas.getHeight(),
                (int) canvas.getWidth());
    }

    public void startPhysics() {
        var physics = new Physics(this);
        (new Thread(physics)).start();
    }

    public Trajectory getTrajectory() {
        return trajectory;
    }

    public Canvas getCanvas() {
        return canvas;
    }

    public BorderRectangle getBorderRectangle() {
        return borderRectangle;
    }
}
