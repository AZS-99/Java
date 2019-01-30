package main;

import shape.*;

import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String args[]) {
        ArrayList<Shape> shapes = new ArrayList<>();
        String s;

        try {
            BufferedReader br = new BufferedReader(new FileReader("shape.txt"));
            while ((s = br.readLine()) != null) {
                String[] tokens = s.split(",");


                if (tokens[0].equals("Square") && tokens.length == 2)
                    shapes.add(new Square(Double.valueOf(tokens[1])));

                else if (tokens[0].equals("Triangle") && tokens.length == 4)
                    shapes.add(new Triangle(Double.valueOf(tokens[1]), Double.valueOf(tokens[2]), Double.valueOf(tokens[3])));

                else if (tokens[0].equals("Rectangle") && tokens.length == 3)
                    shapes.add(new Rectangle(Double.valueOf(tokens[1]), Double.valueOf(tokens[2])));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (var shape : shapes)
            System.out.println(shape);
    }
}
