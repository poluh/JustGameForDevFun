package Engine.Parser;

import Engine.Geomentry.Pixel;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

public class Parser {

    private List<String> strings;

    public Parser(List<String> strings) {
        this.strings = strings;
    }

    private List<Pixel> parse() {
        var result = new ArrayList<Pixel>();
        strings.forEach(string -> {
            for (String stringPixel : string.split("::")) {
                var positionAndColor = stringPixel.split(";");
                var x = Integer.parseInt(positionAndColor[0].split(",")[0]);
                var y = Integer.parseInt(positionAndColor[0].split(",")[1]);
                var stringColor = positionAndColor[1].split(",");
                var r = Integer.parseInt(stringColor[0]);
                var g = Integer.parseInt(stringColor[1]);
                var b = Integer.parseInt(stringColor[2]);
                var color = new Color(r, g, b, 1);
                var pixel = new Pixel(x, y, color);
                result.add(pixel);
            }
        });
        return result;
    }
}
