package shape;

public class Triangle implements Shape {
    double x, y, z;
    public Triangle(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }


    @Override
    public String toString() {
        String str = "Triangle {s1=" + x + ", s2=" + this.y + ", s3=" + this.z + "}";
        str += " perimeter = " + getPerimeter();
        return str;
    }


    public double getPerimeter() {
        return  Math.round((x + y + z) * 1000)/1000;
    }
}
