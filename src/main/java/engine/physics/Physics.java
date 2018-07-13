package engine.physics;

import engine.gui.Texture;
import javafx.scene.canvas.Canvas;

import static java.lang.Thread.sleep;

public class Physics implements Runnable {

    private static final int ACCELERATION = 4;
    private Texture texture;
    private Canvas canvas;

    public Physics(Texture texture) {
        this.canvas = texture.getCanvas();
        this.texture = texture;
    }

    @Override
    public void run() {
        var speed = 0.0;
        var time = 0.0;
        while (!texture.getBorderRectangle().anythingIntersect()) {
            delay(50);
            canvas.setTranslateY(canvas.getTranslateY() + speed);
            speed += time * ACCELERATION;
            time += 0.1;
        }
    }

    private void delay(int delay) {
        try {
            sleep(delay);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
