package main;

import student.Department;
import student.Student;
import student.StudentProcess;

import java.util.Arrays;

public class Main {
    public static void main(String args[]) {
        //Task 1

        Student students[] = {
                new Student("Wesley", "Jones", 42.89, Department.Media),
                new Student("Adam", "Saher", 87, Department.CPD),
                new Student("Luis", "Saher", 80, Department.CPA),
                new Student ("Aaron", "Johnson", 76.0, Department.IT)

        };

        StudentProcess studentProcess = new StudentProcess(students);

        studentProcess.print();
        System.out.println();



        //Task 2
        studentProcess.getSuccessfulStudents();
        System.out.println();



        //Task 3
        System.out.println(Arrays.stream(students).filter(student -> student.getGrade() >= 50).findFirst().get());

    }
}
