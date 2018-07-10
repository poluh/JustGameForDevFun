package Engine.Parser;

import Engine.Geomentry.Pixel;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

public class Parser {

    private int width;
    private int height;
    private List<Pixel> pixels;

    public Parser(List<String> strings) {
        var stringSpriteSize = strings.get(0).split(",");
        height = Integer.parseInt(stringSpriteSize[0]);
        width = Integer.parseInt(stringSpriteSize[1]);
        pixels = parse(strings.subList(1, strings.size()));
    }

    private List<Pixel> parse(List<String> strings) {
        var result = new ArrayList<Pixel>();
        strings.forEach(string -> {
            var positionAndColor = string.split(";");
            var x = Integer.parseInt(positionAndColor[0].split(",")[0]);
            var y = Integer.parseInt(positionAndColor[0].split(",")[1]);
            var stringColor = positionAndColor[1].split(",");
            var r = Integer.parseInt(stringColor[0]);
            var g = Integer.parseInt(stringColor[1]);
            var b = Integer.parseInt(stringColor[2]);
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
}
