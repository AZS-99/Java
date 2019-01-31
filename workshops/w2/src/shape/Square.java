package shape;

public class Square implements Shape {
    private double sideLength;

    public Square(double sideLength) throws NonPositiveValueException {
        if (sideLength < 0)
            throw new NonPositiveValueException("Invalid Side!");
        this.sideLength = sideLength;
    }


    @Override
    public String toString() {

        String str = "Square {s = " + this.sideLength + "} perimeter = ";
        String perimeter = String.format("%.5f", getPerimeter());
        return str + perimeter;
    }


    public double getPerimeter() {
        return Math.round(sideLength * 4.0 *100000.0)/100000.0;
    }


}
