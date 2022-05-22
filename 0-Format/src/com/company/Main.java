package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // Type 'sout'
        System.out.println("Enter your name");
        var name = scan.next();

        System.out.println("Welcome, " + name);

        double pi = 3.1415926535;
        System.out.printf("%2.3f\n", pi); // Every % represent a column
        System.out.printf("%8s %8s\n", "Adam", "Saher");
        System.out.printf("%8s %8s\n", "Abanob", "Hafeez");

        System.out.printf("%-8s %-8s\n", "Adam", "Saher");
        System.out.printf("%-8s %-8s\n", "Abanob", "Hafeez");
    }
}
