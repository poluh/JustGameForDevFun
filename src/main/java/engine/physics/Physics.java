package engine.physics;

import engine.gui.Texture;
import javafx.scene.canvas.Canvas;

public class Physics implements Runnable {

    private Texture texture;
    private Canvas canvas;

    public Physics(Texture texture) {
        this.canvas = texture.getCanvas();
    }

    @Override
    public void run() {

    }
}
