package engine.physics;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class BorderRectangle {

    private class Point {

        private int x;
        private int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Point)) return false;
            Point point = (Point) o;
            return x == point.x &&
                    y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    private static List<BorderRectangle> ALL_BORDER_RECTANGLES = new ArrayList<>();
    private Point upperRPoint;
    private Point bottomLPoint;
    private int height;
    private int width;

    BorderRectangle(int x, int y, int h, int w) {
        upperRPoint = new Point(x, y);
        bottomLPoint = new Point(x + w, y + h);
        height = h;
        width = w;
        ALL_BORDER_RECTANGLES.add(this);
    }

    public boolean intersect(BorderRectangle other) {
        return this.pointIsInside(other.bottomLPoint) || this.pointIsInside(other.upperRPoint);
    }

    private boolean pointIsInside(Point point) {
        return point.x >= this.upperRPoint.x && point.x <= this.bottomLPoint.x &&
                point.y <= this.upperRPoint.y && point.y >= this.bottomLPoint.y;
    }

}
