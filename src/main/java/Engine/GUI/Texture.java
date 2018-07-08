package Engine.GUI;

import Engine.Geomentry.Trajectory;
import Engine.Parser.Parser;
import javafx.scene.canvas.Canvas;

import java.util.List;

public class Texture {

    private Trajectory trajectory;
    private Canvas canvas;

    public Texture(List<String> rawTextureStrings) {
        Parser parser = new Parser(rawTextureStrings);
        trajectory = new Trajectory(parser.getPixels());
        canvas = new Canvas(parser.getWidth(), parser.getHeight());
    }
}
