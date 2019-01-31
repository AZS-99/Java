package main;

import shape.*;

import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String args[]) {
        System.out.println("------->JAC 444 Assignment 1<-------");
        System.out.println("------->Task 1 ... <-------");

        ArrayList<Shape> shapes = new ArrayList<>();
        String s;

        try {
            BufferedReader br = new BufferedReader(new FileReader("shape.txt"));
            while ((s = br.readLine()) != null) {
                String[] tokens = s.split(",");


                if (tokens[0].equals("Square") && tokens.length == 2) {
                    try {
                        shapes.add(new Square(Double.valueOf(tokens[1])));
                    }
                    catch (NonPositiveValueException ex) {
                        System.out.println(ex.getMessage());
                    }
                }

                else if (tokens[0].equals("Triangle") && tokens.length == 4) {
                    try {
                        Triangle triangle = new Triangle(Double.valueOf(tokens[1]), Double.valueOf(tokens[2]), Double.valueOf(tokens[3]));
                        shapes.add(triangle);
                    }
                    catch (IllegalValueException ex) {
                        System.out.println(ex.getMessage());
                    }
                    catch (NonPositiveValueException ex) {
                        System.out.println(ex.getMessage());
                    }
                }

                else if (tokens[0].equals("Rectangle") && tokens.length == 3) {
                    try {
                        shapes.add(new Rectangle(Double.valueOf(tokens[1]), Double.valueOf(tokens[2])));
                    }
                    catch (NonPositiveValueException ex) {
                        System.out.println(ex.getMessage());
                    }
                }

                else if (tokens[0].equals("Circle") && tokens.length == 2) {
                    try {
                        shapes.add(new Circle(Double.valueOf(tokens[1])));
                    }
                    catch (NonPositiveValueException ex) {
                        System.out.println(ex.getMessage());
                    }
                }

                else if (tokens[0].equals("Parallelogram") && tokens.length == 3) {
                    try {
                        shapes.add(new Parallelogram(Double.valueOf(tokens[1]), Double.valueOf(tokens[2])));
                    }
                    catch (NonPositiveValueException ex) {
                        System.out.println(ex);
                    }
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println();

        System.out.println(shapes.size() + " shapes were created!:");

        for (var shape : shapes)
            System.out.println(shape + "\n");
    }
}
