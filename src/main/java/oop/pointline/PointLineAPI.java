package oop.pointline;

import java.text.DecimalFormat;

public class PointLineAPI {

    private PointLineAPI() {
    }

    public static double getDistance(Point a, Point b) {
        if (a == null || b == null || a.equals(b)) {
            return 0.0;
        }
        DecimalFormat df = new DecimalFormat("##.00");
        return Double.parseDouble(df.format(Math.abs(Math.hypot((a.getX() - b.getX()), (a.getY() - b.getY())))));
    }

    public static double getDistance(Line line) {
        if (line == null)
            return 0.0;
        return line.getLength();
    }

    public static Point middlePoint(Point firstPoint, Point secondPoint) {
        Point middlePoint = new Point(0, 0);
        if (firstPoint == null || secondPoint == null || getDistance(firstPoint, secondPoint) == 0) {
            System.out.println("Error: Point not created!");
        } else
            middlePoint = new Point(((firstPoint.getX() + secondPoint.getX()) / 2), ((firstPoint.getY() + secondPoint.getY()) / 2));
        return middlePoint;
    }

    public static boolean isPointOnTheLine(Line line, Point point) {
        if (line == null || point == null)
            return false;
        return (getDistance(line.getA(), point) + getDistance(line.getB(), point)) == getDistance(line.getB(), line.getA());
    }

    public static boolean isPointsFormSquare(Point a, Point b, Point c, Point d) {
        double ac = getDistance(a, c);
        double db = getDistance(d, b);

        if (a == null || b == null || c == null || d == null || getDistance(a, b) == 0 || getDistance(a, c) == 0 || getDistance(a, d) == 0) {
            System.out.println("Error: Point not created!");
            return false;
        } else if (getDistance(a, b) != getDistance(b, c) && getDistance(a, b) != getDistance(c, d) && getDistance(a, b) != getDistance(d, a)) {
            System.out.println("Error: This is not square!");
            return false;
        } else if (ac != db) {
            return false;
        }

        return middlePoint(a, c).equals(middlePoint(d, b));
    }

    public static boolean isPointBelongsToSquare(Point belongPoint, Point a, Point b, Point c, Point d) {
        DecimalFormat df = new DecimalFormat("##.00");
        double maxX = Math.max(Math.max(a.getX(), b.getX()), Math.max(c.getX(), d.getX()));
        double minX = Math.min(Math.min(a.getX(), b.getX()), Math.min(c.getX(), d.getX()));
        double maxY = Math.max(Math.max(a.getY(), b.getY()), Math.max(c.getY(), d.getY()));
        double minY = Math.min(Math.min(a.getY(), b.getY()), Math.min(c.getY(), d.getY()));
        if (!isPointsFormSquare(a, b, c, d)) {
            return false;
        } else if (belongPoint.getX() > maxX || belongPoint.getX() < minX || belongPoint.getY() > maxY || belongPoint.getY() < minY) {
            return false;
        }

        double squareArea = Math.abs(new Line(a, b).getLength() * new Line(a, b).getLength());
        double firstTriangle = calculateTrianglelArea(belongPoint, a, b);
        double secondTriangle = calculateTrianglelArea(belongPoint, b, c);
        double thirdTriangle = calculateTrianglelArea(belongPoint, c, d);
        double forthTriangle = calculateTrianglelArea(belongPoint, a, d);

        return (df.format(squareArea).equals(df.format(firstTriangle + secondTriangle + thirdTriangle + forthTriangle)));
    }

   private static double calculateTrianglelArea(Point a, Point b, Point c) {
        return Math.abs((a.getX() * (b.getY() - c.getY()) +
                b.getX() * (c.getY() - a.getY()) + c.getX() * (a.getY() - b.getY())) / 2.0);
    }
}