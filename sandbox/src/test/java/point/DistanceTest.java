package point;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DistanceTest {

    @Test
    public void testDistance () {
        Point p1 = new Point(1.0,1.0);
        Point p2 = new Point(5.0,4.0);
        Assert.assertEquals(p1.distanceTo(p2), 5.0);
    }

    @Test
    public void testDistanceNegative () {
        Point p1 = new Point(-1.0,-1.0);
        Point p2 = new Point(-5.0,-4.0);
        Assert.assertEquals(p1.distanceTo(p2), 5.0);
    }
}