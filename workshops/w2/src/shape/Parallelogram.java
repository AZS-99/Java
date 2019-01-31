package shape;

public class Parallelogram implements Shape {
    private double width, height;

    public Parallelogram(double width, double height) throws NonPositiveValueException {
        if (width < 0 || height < 0)
            throw new NonPositiveValueException("Invalid Side(s)");
        this.width = width;
        this.height = height;
    }

    @Override
    public String toString() {
        String str = "Parallelogram {" + "w =" + width + ", h=" + height + "} " +  "perimeter = ";
        String perimeter = String.format("%.5f", getPerimeter());
        return str + perimeter;
    }

    @Override
    public double getPerimeter() {
        return Math.round(2 * (width + height) * 100000.0)/100000.0;
    }
}
