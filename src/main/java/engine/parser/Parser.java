package engine.parser;

import engine.geomentry.Pixel;
import engine.gui.Texture;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

public class Parser {

    private int width;
    private int height;
    private Texture.TextureType textureType;
    private List<Pixel> pixels;

    public Parser(List<String> strings) {
        var sizeAndType = strings.get(0).split(",");
        height = Integer.parseInt(sizeAndType[0]);
        width = Integer.parseInt(sizeAndType[1]);
//        textureType = Texture.TextureType.valueOf(sizeAndType[2]);
        pixels = parse(strings.subList(1, strings.size()));
    }

    private List<Pixel> parse(List<String> strings) {
        var result = new ArrayList<Pixel>();
        strings.forEach(string -> {
            var positionAndColor = string.split(";");
            var x = Integer.parseInt(positionAndColor[0].split(",")[0]);
            var y = Integer.parseInt(positionAndColor[0].split(",")[1]);
            var stringColor = positionAndColor[1].split(",");
            var r = Double.parseDouble(stringColor[0]);
            var g = Double.parseDouble(stringColor[1]);
            var b = Double.parseDouble(stringColor[2]);
            var color = new Color(r, g, b, 1);
            var pixel = new Pixel(x, y, color);
            result.add(pixel);
        });
        return result;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public List<Pixel> getPixels() {
        return pixels;
    }

    public Texture.TextureType getTextureType() {
        return textureType;
    }
}
