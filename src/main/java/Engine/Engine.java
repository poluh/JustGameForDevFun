package Engine;

import Engine.GUI.Drawer;
import Engine.GUI.Texture;
import javafx.scene.canvas.Canvas;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class Engine {

    private List<Texture> textures;

    public void loadTextures(String pathToDirectoryTextures) throws IOException {
        var directory = new File(pathToDirectoryTextures);
        if (!directory.isDirectory()) {
            throw new IllegalArgumentException(
                    "Is't path to directory!\n" +
                            "PLease, change path.\n" +
                            "Current path = " + pathToDirectoryTextures
            );
        }
        var texturesFiles = directory.listFiles();
        if (texturesFiles == null) throw new IllegalArgumentException("Not searched texture files.");
        var texturesStrings = new ArrayList<List<String>>();
        for (var textureFile : texturesFiles) {
            texturesStrings.add(Files.readAllLines(textureFile.toPath()));
        }

        textures = new ArrayList<>();
        for (var textureStrings : texturesStrings) {
            textures.add(new Texture(textureStrings));
        }
    }

    public List<Canvas> getCanvases() {
        if (textures.isEmpty()) throw new IllegalArgumentException("Textures is't loaded.");
        var canvases = new ArrayList<Canvas>();
        for (var texture : textures) {
            Drawer drawer = new Drawer(texture);
            drawer.draw();
            canvases.add(drawer.getCanvas());
        }
        return canvases;
    }

}
