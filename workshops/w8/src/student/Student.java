package student;

public class Student {
    String firstName, lastName;
    double grade;
    Department department;

    public double getGrade() {
        return grade;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public Student(String firstName, String lastName, double grade, Department department) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.grade = grade;
        this.department = department;
    }

    @Override
    public String toString() {
        return firstName + "\t\t" + lastName + "\t\t" + grade + "\t\t" + department.toString();
    }
}
