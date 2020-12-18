package ooptests.pointline;

import oop.pointline.Line;
import oop.pointline.Point;
import oop.pointline.PointLineAPI;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static oop.pointline.PointLineAPI.getDistance;

public class TestPointLine {

    Point A, B, C, D, belongPoint;
    Line line;

    @BeforeClass
    public void setup() {
        A = new Point(-2, 1);
        B = new Point(1, 4);
        C = new Point(4, 1);
        D = new Point(1, -2);
        belongPoint = new Point(1, 3);
        line = new Line(A, B);
    }

    @Test
    public void testGetDistance() {
        Assert.assertEquals(getDistance(A, B), 4.24);
    }

    @Test
    public void testPointOnTheLine() {
        Assert.assertTrue(PointLineAPI.isPointOnTheLine(line, new Point(0, 3)));
    }

    @Test
    public void testPointsFormSquare() {
        Assert.assertTrue(PointLineAPI.isPointsFormSquare(A, B, C, D));
    }

    @Test
    public void testPointBelongsToSquare() {
        Assert.assertTrue(PointLineAPI.isPointBelongsToSquare(belongPoint, A, B, C, D));
    }
}