package shape;

public class Parallelogram extends Rectangle implements Shape {


    public Parallelogram(double width, double height) throws NonPositiveValueException {
        super(width, height);
    }

    @Override
    public String toString() {
        String str = "Parallelogram {" + "w =" + super.getWidth() + ", h=" + getLength() + "} " +  "perimeter = ";
        String perimeter = String.format("%.5f", getPerimeter());
        return str + perimeter;
    }

    @Override
    public double getPerimeter() {
        return Math.round(2 * (super.getWidth() + super.getLength()) * 100000.0)/100000.0;
    }
}
