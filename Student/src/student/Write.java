package student;



import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class Write {
    public static void writeStudents()  {
        ArrayList<Course> courses = new ArrayList<>();
        int courseNum;
        String firstName, lastName, yesNo;
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();
        boolean flag;
        boolean courseFlag;
        do {

            System.out.println("Enter student's first name: ");
            firstName = sc.nextLine();
            System.out.println("Enter student's last name: ");
            lastName = sc.nextLine();


            do {
                System.out.println("Select the course NUMBER from the following courses for current student:");
                System.out.println("1-BCI433  2-DSA555  3-OOP234  4-JAC444");
                System.out.println("5-IPC101  6-EAC150  7-CAN149  8-MAP555");
                courseNum = Integer.parseInt(sc.nextLine());

                switch (courseNum) {
                    case 1:
                        if (!courses.contains(Course.BCI433))
                            courses.add(Course.BCI433);
                        else
                            System.out.println("Course couldn't be added as it already exists!");
                        break;
                    case 2:
                        if (!courses.contains(Course.DSA555))
                            courses.add(Course.DSA555);
                        else
                            System.out.println("Course couldn't be added as it already exists!");
                        break;
                    case 3:
                        if (!courses.contains(Course.OOP234))
                            courses.add(Course.OOP234);
                        else
                            System.out.println("Course couldn't be added as it already exists!");
                        break;
                    case 4:
                        if (!courses.contains(Course.JAC444))
                            courses.add(Course.JAC444);
                        else
                            System.out.println("Course couldn't be added as it already exists!");
                        break;
                    case 5:
                        if (!courses.contains(Course.IPC101))
                            courses.add(Course.IPC101);
                        else
                            System.out.println("Course couldn't be added as it already exists!");
                        break;
                    case 6:
                        if (!courses.contains(Course.EAC150))
                            courses.add(Course.EAC150);
                        else
                            System.out.println("Course couldn't be added as it already exists!");
                        break;
                    case 7:
                        if (!courses.contains(Course.CAN149))
                            courses.add(Course.CAN149);
                        else
                            System.out.println("Course couldn't be added as it already exists!");
                        break;
                    case 8:
                        if (!courses.contains(Course.MAP555))
                            courses.add(Course.MAP555);
                        else
                            System.out.println("Course couldn't be added as it already exists!");
                        break;
                    default:
                        System.out.println("Wrong Entry!");

                }
                System.out.println("Would you like to add another course for the same student? (y/n)");
                yesNo = sc.nextLine();
                courseFlag = handleFlag(yesNo);


            } while (courseFlag);


            students.add(new Student(firstName, lastName, courses));
            courses.clear();

            System.out.println("Enter another student? (y/n)");
            yesNo = sc.nextLine();
            flag = handleFlag(yesNo);
        }while(flag);

        serialise(students);


    }

    private static void serialise(ArrayList<Student> students) {
        try {
            FileOutputStream file = new FileOutputStream("Students.ser");
            ObjectOutputStream obj = new ObjectOutputStream(file);
            obj.writeObject(students);
            file.close();

        } catch (IOException ex) {
            System.out.println(ex);
        }
    }


    private static boolean handleFlag(String yesNo)  {
        if (yesNo.equals("n") || yesNo.equals("N") || yesNo.equals("no"))
            return false;
        else if (yesNo.equals("y") || yesNo.equals("Y") || yesNo.equals("yes"))
            return true;
        else {
            System.out.println("Invalid Entry! Please enter either y (yes) or n (no):");
            Scanner sc = new Scanner(System.in);
            yesNo = sc.nextLine();
            return handleFlag(yesNo);
        }
    }

}
