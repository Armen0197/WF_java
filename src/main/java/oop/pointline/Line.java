package oop.pointline;

public class Line {

     private Point a;
     private Point b;
     private double length;

     public Line(Point a, Point b) {
         isLineCanCreated();
         setA(a);
         setB(b);
     }

    public Point getA() {
        return a;
    }

    public void setA(Point a) {
        this.a = a;
    }

    public Point getB() {
        return b;
    }

    public void setB(Point b) {
        this.b = b;
    }

    public double getLength() {
         length = Math.sqrt(Math.pow((a.getX() - b.getX()), 2) + Math.pow((a.getY() - b.getY()), 2));
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    @Override
    public String toString() {
        return String.format("%s -> %s", a, b);
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Line)) return false;
        Line line = (Line) obj;
        return a.equals(line.getA()) && b.equals(line.getB());
    }

    private boolean isLineCanCreated() {
        if (a == null || b == null || a.equals(b)) {
            System.out.println("Error: Line not created!");
            return false;
        }
        else return true;
    }
}