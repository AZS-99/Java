package shape;

public class Parallelogram implements Shape {
    private double width, height;

    public Parallelogram(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public String toString() {
        return "Parallelogram {" + "w =" + width + "{ h=" + height + "}" +  "perimeter =" + getPerimeter();
    }

    @Override
    public double getPerimeter() {
        return 2 * (width + height);
    }
}
