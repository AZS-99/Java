package shape;

public class Triangle implements Shape {
    double base, y, z;
    public Triangle(double x, double y, double z) {
        this.base = x;
        this.y = y;
        this.z = z;
    }


    @Override
    public String toString() {
        return "Triangle with dimensions: base " + base + " y: " + this.y + " z: " + this.z;
    }


    public double getPerimeter() {
        return  base + y + z;
    }
}
