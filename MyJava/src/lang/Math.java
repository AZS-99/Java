package lang;

public class Math {
    /**
     * @param x any double
     * @return An approximated integer value for the passed double.
     */
    public static int approximate(double x) {
        return (x + 0.5 >= (int) x + 1? (int) x + 1 : (int) x);
    }


    /**
     * @param n Any positive value
     * @return The summation of numbers from 0 till n
     */
    public static int sum (int n) {
        if (n <= 1)
            return n;
        return sum(n - 1) + n;
    }


    /**
     * @param number a positive number
     * @return The number of digits of the passed number. For instance, passing 3450 returns 4
     */
    public static int numberOfDigits(int number) {
        if (number < 10)
            return 1;
        return numberOfDigits(number/10) + 1;
    }
}
