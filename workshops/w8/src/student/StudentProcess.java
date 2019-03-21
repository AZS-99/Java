package student;

import java.util.Arrays;
import java.util.Comparator;

public class StudentProcess {
    private Student students[];

    public StudentProcess(Student students[]) {
        this.students = students;
    }

    public void print() {
        Arrays.stream(students).forEach(System.out::println);
    }

    public void getSuccessfulStudents() {
        Arrays.stream(students).filter(student -> student.getGrade() > 50).forEach(System.out::println);
    }

    public void getUnique() {
        Arrays.sort(students, Comparator.comparing(Student::getLastName).thenComparing(Student::getGrade));
    }
}

