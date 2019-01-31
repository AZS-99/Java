package shape;

public class Rectangle implements Shape {
    private double length, width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }


    @Override
    public String toString() {
        return "Square {l = " + length + ", width = " + width + "} perimeter = " + getPerimeter();
    }

    public double getPerimeter() {
        return Math.round(2 * (length + width) * 1000)/1000;
    }
}
