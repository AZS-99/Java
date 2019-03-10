package lang;

public class Math {
    public static int approximate(double x) {
        return (x + 0.5 >= (int) x + 1? (int) x + 1 : (int) x);
    }
}
