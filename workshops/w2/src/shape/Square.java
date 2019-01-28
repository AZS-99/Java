package shape;

public class Square implements Shape {
    private double sideLength;

    public Square(double sideLength) {
        this.sideLength = sideLength;
    }


    @Override
    public String toString() {
        return "Square {s = " + this.sideLength + "} perimeter = " + this.getPerimeter();
    }


    public double getPerimeter() {
        return sideLength * 4;
    }


}
