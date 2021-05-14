package com.company;

public class Math {
    // Static fns belong to the class, not the instance.
    public static int factorial(int num) {
        return num < 2? num : factorial(num - 1) * num;
    }

    public static int sum_digits(int num) {
        return (num < 10)? num : sum_digits(num / 10) + num % 10;
    }
}
