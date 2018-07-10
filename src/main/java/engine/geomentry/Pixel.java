package engine.geomentry;

import javafx.scene.paint.Color;

public class Pixel {

    private int x;
    private int y;
    private Color pixelColor;

    public Pixel(int x, int y, Color color) {
        this.x = x;
        this.y = y;
        this.pixelColor = color;
    }

    public Pixel(int x, int y) {
        this(x, y, Color.BLACK);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Color getPixelColor() {
        return pixelColor;
    }
}
