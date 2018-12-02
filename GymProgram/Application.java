
import java.io.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author it676
 */
public class Application {

    public static void main(String[] args) {

        List gList = new List();
        Scanner input = new Scanner(System.in);

        try {
            for (int i = 0; i < 3; i++) {
                System.out.println("Enter the gym info");
                int id = input.nextInt();
                String location = input.next();
                double fee = input.nextDouble();
                int size = input.nextInt();

                gList.insertAtFront(new Gym(id, location, fee, size));
            }
        } catch (java.util.InputMismatchException ex) {

            System.out.println("Please enter a valid data");
        }

        List tempList = new List();
        while (!gList.isEmpty()) {

            Gym gym = gList.removeFromFront();

            tempList.insertAtFront(gym);

            if (gym.getLoction().equals("Alnakheel")) {

                System.out.println("Gym was found at Alnakheel");
                break;
            }

        }

        while (!tempList.isEmpty()) {

            gList.insertAtFront(tempList.removeFromFront());
        }

        File file1 = new File("AllGyms.txt");
        File file2 = new File("Gyms.dat");
        PrintWriter pw = null;
        ObjectOutputStream oos = null;
        List expensiveList = new List();
        Gym[] cheapArray = new Gym[gList.size()];
        int index = 0;
        try {
            pw = new PrintWriter(file1);
            oos = new ObjectOutputStream(new FileOutputStream(file2));

            while (!gList.isEmpty()) {

                Gym gym = gList.removeFromFront();

                pw.println(gym);

                gym.addMemebr("555");

                System.out.println(gym);
                oos.writeObject(gym);

                if (gym.getFee() > 2000) {

                    expensiveList.insertAtFront(gym);

                } else {

                    cheapArray[index++] = gym;
                }

            }

        } catch (FileNotFoundException ex) {

//logic
        } catch (IOException ex) {

            //logic
        } finally {

            try {
                oos.close();
                pw.close();
            } catch (IOException ex) {

                //logic
            }
        }

        while (!tempList.isEmpty()) {

            gList.insertAtFront(tempList.removeFromFront());
        }

        for (int i = 0; i < index; i++) {

            System.out.println(cheapArray[i]);

        }

    }

}
