package shape;

public class Rectangle implements Shape {
    private double length, width;

    public Rectangle(double length, double width) throws NonPositiveValueException{
        if (length < 0 || width < 0)
            throw new NonPositiveValueException("Invalid Side!");
        this.length = length;
        this.width = width;
    }


    @Override
    public String toString() {
        String str = "Rectangle {l = " + length + ", width = " + width + "} perimeter = ";
        String perimeter = String.format("%.5f", getPerimeter());
        return str + perimeter;
    }

    public double getPerimeter() {
        return Math.round(2 * (length + width) * 100000.0)/100000.0;
    }
}
