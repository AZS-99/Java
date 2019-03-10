
package main;

import static lang.Math.*;

public class Main {
    public static void main(String[] args) {
        int x = approximate(10.5);
        System.out.println(x);

        int sumTill100 = sum(100);
        System.out.println(sumTill100);

        System.out.println(numberOfDigits(1234599));
    }
}
