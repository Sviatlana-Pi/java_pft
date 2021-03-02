package point;

public class Point {
    public final double x;
    public final double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double distanceTo(Point p2) {
        return Math.sqrt(((p2.x-this.x)*(p2.x-this.x)) + ((p2.y-this.y)*(p2.y-this.y)));
    }
}
