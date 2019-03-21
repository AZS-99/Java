package shape;

public class Triangle implements Shape, Area {
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
        str += perimeter;
        str += ", Area = ";
        return str + String.format("%.4f", getArea());
    }


    public double getPerimeter() {
        return  Math.round((x + y + z) * 100000.0)/100000.0;
    }

    Area area = () -> Math.sqrt(getPerimeter()/2 * (getPerimeter()/2 - x) * (getPerimeter()/2 - y) * (getPerimeter()/2 - z));

    @Override
    public double getArea() {
        return area.getArea();
    }
}
