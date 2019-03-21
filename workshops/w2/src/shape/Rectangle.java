package shape;

public class Rectangle extends Square implements Shape, Area {


    private double width;

    public Rectangle(double length, double width) throws NonPositiveValueException{
        super(length);
        if (width < 0)
            throw new NonPositiveValueException("Invalid Side!");
        this.width = width;
    }


    @Override
    public String toString() {
        String str = "Rectangle {l = " + super.getLength() + ", width = " + width + "} perimeter = ";
        String perimeter = String.format("%.5f", getPerimeter());
        str += perimeter + ", Area = ";
        return str + String.format("%.4f", getArea());
    }

    public double getPerimeter() {
        return Math.round(2 * (super.getLength() + width) * 100000.0)/100000.0;
    }

    public double getWidth() {
        return width;
    }

    Area area = () -> this.width * this.getLength();

    @Override
    public double getArea() {
        return area.getArea();
    }
}
