package shape;

import static java.lang.Math.PI;

public class Circle implements Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }


    @Override
    public String toString() {
        return "Circle {r = " + this.radius + "} perimeter = " + getPerimeter();
    }


    public double getPerimeter() {
        return 2 * PI * this.radius;
    }
}
