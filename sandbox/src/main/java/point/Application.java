package point;

public class Application {

    public static void main(String[] args) {

        Point p1 = new Point(1.0,1.0);
        Point p2 = new Point(5.0,4.0);

        p1.distanceTo(p2);

        System.out.println("lenghX squared" + " = " + ((p2.x-p1.x)*(p2.x-p1.x)));
        System.out.println("lenghY squared" + " = " + ((p2.y-p1.y)*(p2.y-p1.y)));
        System.out.println("The distance between A and B with coordination ("+ p1.x + " ; " + p1.y +") for A and ("+ p2.x + " ; " + p2.y +") for B" + " = " + distance(p1, p2));//Method 1

        System.out.println("The distance between A and B with coordination ("+ p1.x + " ; " + p1.y +") for A and ("+ p2.x + " ; " + p2.y +") for B" + " = " + p1.distanceTo(p2));//Method 2


    }

    public static double distance(Point p1, Point p2) {
        return Math.sqrt(((p2.x-p1.x)*(p2.x-p1.x)) + ((p2.y-p1.y)*(p2.y-p1.y)));
    }

}
