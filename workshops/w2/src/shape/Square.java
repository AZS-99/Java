package shape;

public class Square implements Shape, Area {
    private double length;

    public Square(double length) throws NonPositiveValueException {
        if (length < 0)
            throw new NonPositiveValueException("Invalid Side!");
        this.length = length;
    }


    @Override
    public String toString() {

        String str = "Square {s = " + this.length + "} perimeter = ";
        String perimeter = String.format("%.5f", getPerimeter());
        str += perimeter + ", Area = ";
        return str + String.format("%.4f", getArea());
    }


    public double getLength() {
        return length;
    }


    public double getPerimeter() {
        return Math.round(length * 4.0 *100000.0)/100000.0;
    }

    Area area = () -> this.length * this.length;

    @Override
    public double getArea() {
        return area.getArea();
    }
}
