package student;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

public class GraphicalWrite extends JFrame  implements Serializable {
    private JButton addButton, cancelButton, saveButton;
    private JComboBox coursesBox;
    private JTextField lastNameTxt, firstnameTxt;
    private ArrayList<Student> students;

    public GraphicalWrite()  { //VDSL rule
        super("Student Entry");
        setVisible(true);
        setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(15, 2));

        JPanel line1 = new JPanel();
        line1.setLayout(new FlowLayout(FlowLayout.LEADING));
        JLabel firstnameLbl = new JLabel("Enter first name: ");
        line1.add(firstnameLbl);
        firstnameTxt = new JTextField(10);
        line1.add(firstnameTxt);
        this.add(line1);

        JPanel lastNamePanel = new JPanel();
        lastNamePanel.setLayout(new FlowLayout(FlowLayout.LEADING));
        JLabel lastNameLbl = new JLabel("Enter last name: ");
        lastNameTxt = new JTextField(10);
        lastNamePanel.add(lastNameLbl);
        lastNamePanel.add(lastNameTxt);
        this.add(lastNamePanel);

        JPanel coursesPanel = new JPanel();
        coursesPanel.setLayout(new FlowLayout(FlowLayout.LEADING));
        JLabel coursesLbl = new JLabel("Courses");
        coursesBox = new JComboBox();
        coursesBox.addItem("JAC444");
        coursesBox.addItem("DSA555");
        coursesBox.addItem("BCI433");
        coursesBox.addItem("OOP234");
        coursesPanel.add(coursesLbl);
        coursesPanel.add(coursesBox);
        this.add(coursesPanel);


        JPanel saveCancelPanel = new JPanel();
        addButton = new JButton("Add student");
        cancelButton = new JButton("Cancel");
        saveButton = new JButton("Save");
        ButtonHandler buttonHandle = new ButtonHandler();
        addButton.addActionListener(buttonHandle);
        cancelButton.addActionListener(buttonHandle);
        saveButton.addActionListener(buttonHandle);
        saveCancelPanel.add(addButton);
        saveCancelPanel.add(cancelButton);
        saveCancelPanel.add(saveButton);
        this.add(saveCancelPanel);

        students = new ArrayList<>();


    }


    public class ButtonHandler implements ActionListener {

        public void actionPerformed(ActionEvent actionEvent) {
            if (actionEvent.getSource().equals(addButton)) {
                String firstName = firstnameTxt.getText();
                String lastName = lastNameTxt.getText();
                Course course;
                switch (coursesBox.getSelectedItem().toString()) {
                    case "JAC444":
                        course = Course.JAC444;
                        break;
                    case "DSA555":
                        course = Course.DSA555;
                        break;
                    case "BCI433":
                        course = Course.BCI433;
                        break;
                    case "OOP234":
                        course = Course.OOP234;
                        break;
                    case "IPC101":
                        course = Course.IPC101;
                        break;
                        default:
                            course = Course.IPC101;
                }
                ArrayList<Course> courses = new ArrayList<>();
                courses.add(course);

                students.add(new Student(firstName, lastName, courses));
                System.out.println(students);
                firstnameTxt.setText("");
                lastNameTxt.setText("");
            }
            else if (actionEvent.getSource().equals(cancelButton)) {
                firstnameTxt.setText("");
                lastNameTxt.setText("");
                System.exit(0);
            }
            else if (actionEvent.getSource().equals(saveButton)) {
                serialise();
                System.exit(0);
            }


        }
    }

    public void serialise() {
        try {
            FileOutputStream file = new FileOutputStream("Students.ser");
            ObjectOutputStream obj = new ObjectOutputStream(file);
            obj.writeObject(students);
            file.close();

        } catch (IOException ex) {
            System.out.println(ex);
        }
    }


    public  void readStudents() {
        try {
            ArrayList<Student> studentArray;
            FileInputStream file = new FileInputStream("Students.ser");
            ObjectInputStream obj = new ObjectInputStream(file);
            studentArray = (ArrayList<Student>) obj.readObject();
            obj.close();
            file.close();

            for (var student : studentArray) {

                System.out.println(student);
            }

            class Reading extends JFrame {
                JTextArea txt;
                Reading() {
                    txt = new JTextArea();
                    for (var student : studentArray) {

                        txt.append(student.toString());
                    }
                    this.add(txt);
                }
            }
            Reading r = new Reading();
        } catch (IOException exp) {
            System.out.println(exp);

        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }
}
