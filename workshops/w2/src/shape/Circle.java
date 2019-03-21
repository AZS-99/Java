package shape;

import static java.lang.Math.PI;

public class Circle implements Shape, Area {
    private double radius;

    public Circle(double radius) throws NonPositiveValueException {
        if (radius < 0)
            throw new NonPositiveValueException("Invalid Radius!");
        this.radius = radius;
    }


    @Override
    public String toString() {

        String str = "Circle {r = " + this.radius + "} perimeter = ";
        String perimeter = String.format("%.5f", getPerimeter());
        str += perimeter + ", Area = ";
        return str + String.format("%.4f", getArea());
    }


    public double getPerimeter() {
        return Math.round(2 * PI * this.radius * 100000.0)/100000.0;
    }

    Area area = () -> this.radius * this.radius * PI;


    @Override
    public double getArea() {
        return area.getArea();
    }
}
