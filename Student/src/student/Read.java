package student;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class Read {
    public static void readStudents() {
        try {
            ArrayList<Student> studentArray;
            FileInputStream file2 = new FileInputStream("Students.ser");
            ObjectInputStream obj2 = new ObjectInputStream(file2);
            studentArray = (ArrayList<Student>) obj2.readObject();
            obj2.close();
            file2.close();

            for (var student : studentArray) {
                System.out.println(student);
            }
        } catch (IOException exp) {
            System.out.println(exp);

        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }
}
