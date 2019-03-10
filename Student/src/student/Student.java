package student;

import java.io.Serializable;
import java.util.ArrayList;

public class Student implements Serializable {
    static int idGenerator;
    int id;
    String firstName, lastName;
    ArrayList<Course> courses;

    public Student(String firstName, String lastName, ArrayList<Course> courses) {
        id = ++idGenerator;
        this.firstName = firstName;
        this.lastName = lastName;
        this.courses = new ArrayList<>(courses);
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + ", " + "Student id: " + id + "\nCourses: " + courses + "\n";
    }
}
