package engine.gui;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

public class Drawer {

    private static final int PIXEL_SIZE = 10;

    private GraphicsContext context;
    private Canvas canvas;
    private Texture texture;

    public Drawer(Texture texture) {
        this.texture = texture;
        canvas = texture.getCanvas();
        context = canvas.getGraphicsContext2D();
    }

    public void draw() {
        texture.getTrajectory().getPixelsOfTrajectory().forEach(pixel -> {
            context.setFill(pixel.getPixelColor());
            context.fillRect(pixel.getX(), pixel.getY(), PIXEL_SIZE, PIXEL_SIZE);
        });
    }

    public Canvas getCanvas() {
        return canvas;
    }
}
