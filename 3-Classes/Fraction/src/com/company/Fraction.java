package com.company;
import java.math.BigInteger;



public class Fraction {
    int numerator;
    int denominator;

    Fraction(int numerator, int denominator) {
        var gcd = gcd(numerator, denominator);
        this.numerator = Math.abs(numerator / gcd);
        this.denominator = Math.abs(denominator / gcd);
        if (numerator < 0 ^ denominator < 0)
            this.numerator *= -1;
    }

    public String toString() {
        return numerator + "/" + denominator;
    }


    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj instanceof Fraction)
            return numerator == ((Fraction) obj).numerator && denominator == ((Fraction) obj).denominator;
        return false;
    }

    private int gcd(int num1, int num2) {
        if (num1 < num2) {
            var tmp = num1;
            num1 = num2;
            num2 = tmp;
        }
        return num1 % num2 == 0? num2 : gcd(num1, num2 % num1);
    }
}
