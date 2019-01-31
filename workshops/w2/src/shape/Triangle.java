package shape;

public class Triangle implements Shape {
    double x, y, z;
    public Triangle(double x, double y, double z) throws IllegalValueException, NonPositiveValueException {
        if (x + y < z || x + z < y || z + y < x)
            throw new IllegalValueException("Invalid side(s)!");
        if (x < 0 || y < 0 || z < 0)
            throw new NonPositiveValueException("Invalid side!");
        this.x = x;
        this.y = y;
        this.z = z;
    }


    @Override
    public String toString() {
        String str = "Triangle {s1=" + x + ", s2=" + this.y + ", s3=" + this.z + "}  perimeter = ";
        String perimeter = String.format("%.5f", getPerimeter());
        return str + perimeter;
    }


    public double getPerimeter() {
        return  Math.round((x + y + z) * 100000.0)/100000.0;
    }
}
