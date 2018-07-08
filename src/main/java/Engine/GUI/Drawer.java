package Engine.GUI;

import javafx.scene.canvas.GraphicsContext;

public class Drawer {

    private static final int PIXEL_SIZE = 1;

    private GraphicsContext context;
    private Texture texture;

    public Drawer(Texture texture) {
        this.texture = texture;
        context = texture.getCanvas().getGraphicsContext2D();
    }

    public void draw() {
        texture.getTrajectory().getPixelsOfTrajectory().forEach(pixel -> {
            context.setFill(pixel.getPixelColor());
            context.fillRect(pixel.getX(), pixel.getY(), PIXEL_SIZE, PIXEL_SIZE);
        });
    }

}
