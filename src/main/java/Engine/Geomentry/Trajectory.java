package Engine.Geomentry;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Trajectory {

    private List<Pixel> pixelsOfTrajectory;

    public Trajectory(List<Pixel> pixels) {
        pixelsOfTrajectory = pixels;
    }

    public Trajectory(Pixel... pixels) {
        this(Arrays.asList(pixels));
    }

    public List<Pixel> getPixelsOfTrajectory() {
        return pixelsOfTrajectory;
    }
}
