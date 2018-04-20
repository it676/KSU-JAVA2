
import java.io.*;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author IT676
 */
public class Demo {

    public static void main(String[] args) throws FileNotFoundException, IOException {

        LinkedList cList = new LinkedList();
        Scanner input = new Scanner(System.in);

        Course c1, c2, c3;

        for (int i = 0; i < 3; i++) {

            System.out.print("Enter Course No:");
            int cNo = input.nextInt();

            System.out.print("Enter Course Code:");
            String cCode = input.next();

            input.nextLine();
            System.out.print("Enter Course Name:");
            String name = input.nextLine();

            System.out.print("Enter Course Hours:");
            int hours = input.nextInt();

            System.out.print("How many Students?");
            int size = input.nextInt();

            //create the object
            Course course = new Course(cNo, cCode, name, hours, size);

            cList.addFront(course);//IMPORTANT

        }

        FileOutputStream fos = new FileOutputStream("AllCourse.txt", true);
        PrintWriter writer = new PrintWriter(fos);
        fos = new FileOutputStream("AllCourse.data", true);
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        Node currentCourse = cList.getFirstNode();

        while (currentCourse != null) {

            Course course = currentCourse.getData();

            writer.println(course.toString());//to write the info to a file

            course.addStudent("Amal");//add a student to the course

            System.out.println(course.toString());//to prit the info

            oos.writeObject(course);

            currentCourse = currentCourse.getNext();

        }

        writer.close();
        oos.close();

        //d
        Course course1 = new Course(113, "CSC", "Java Programming", 3, 4);
        String[] names = {"Sara", "Nora", "Maha", "Arwa"};

        for (String name : names) {
            course1.addStudent(name);
        }

        currentCourse = cList.getFirstNode();

        boolean isFound = false;
        while (currentCourse != null) {

            if (course1.equals(currentCourse.getData())) {
                isFound = true;
                break;
            }

            //update 
            currentCourse = currentCourse.getNext();
        }

        System.out.println((isFound) ? "The Course is Found !"
                : "The Course Is not in the List !");

    }
}
