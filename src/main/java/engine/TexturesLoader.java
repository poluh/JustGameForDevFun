package engine;

import engine.gui.Drawer;
import engine.gui.Texture;
import javafx.scene.canvas.Canvas;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class TexturesLoader {

    private List<Texture> textures;
    private static final Pattern TEXTURE_FORMAT_PATTERN = Pattern.compile(".+\\.txr");

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
            if (TEXTURE_FORMAT_PATTERN.matcher(textureFile.getName()).matches()) {
                var textureStrings = Files.readAllLines(textureFile.toPath());
                texturesStrings.add(textureStrings);
            }
        }

        textures = new ArrayList<>();
        for (var textureStrings : texturesStrings) {
            var texture = new Texture(textureStrings);
            texture.startPhysics();
            textures.add(texture);
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
