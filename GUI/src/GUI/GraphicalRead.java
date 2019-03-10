package GUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class GraphicalRead extends JFrame    {

    JTable tbl;
    ArrayList<Student> students;
    public GraphicalRead() throws IOException, ClassNotFoundException, FileNotFoundException{
        super("Students Enrolled");
        students = new ArrayList<>();
        tbl = new JTable();


        setVisible(true);
        setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(15, 2));

        JPanel studentsLblPanel = new JPanel();
        studentsLblPanel.setLayout(new FlowLayout(FlowLayout.LEADING));
        JLabel studentsLbl = new JLabel("Students currently enrolled: ");
        studentsLblPanel.add(studentsLbl);
        this.add(studentsLblPanel);


        String columns[] = {"Name", "Courses"};
        String rows[][] = new String[10][10];
        String tmpName = new String();
        String tmpCourse = new String();
        String tmp[] = new String[2];
        try {
            deSerialise();

            int i = 0;
            for (var student : students) {
                tmpName = "";
                tmpCourse = "";
                tmpName = student.getFirstName() + " " + student.getLastName();
                for (var course : student.getCourses()) {
                    tmpCourse += course.toString() + " ";

                }
                tmp[0] = tmpName;
                System.out.println(tmp[0]);
                tmp[1] = tmpCourse;
                System.out.println(tmp[1]);
                System.arraycopy(tmp, 0, rows[i++], 0, 2);

            }

            System.out.println("test!: " + rows[1][0]);

            tbl = new JTable(rows, columns );
            tbl.setPreferredScrollableViewportSize(new Dimension(500, 500));
            tbl.setFillsViewportHeight(true);
            JScrollPane scrollPane = new JScrollPane(tbl);

            this.add(scrollPane);
        }
        catch (IOException exp) {

        }





    }

    private void deSerialise() throws FileNotFoundException, IOException, ClassNotFoundException {
        try {

            FileInputStream file = new FileInputStream("Students.ser");
            ObjectInputStream obj = new ObjectInputStream(file);
            students = (ArrayList<Student>) obj.readObject();
            obj.close();
            file.close();
        }
        catch (FileNotFoundException exp) {
            System.out.println(exp);
        }
        catch (IOException exp) {
            System.out.println(exp);

        }

        catch (ClassNotFoundException exp) {
            System.out.println(exp);

        }

    }
}
