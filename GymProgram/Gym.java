
import java.util.Scanner;


/*
 *  Written By NAIF ALSHEHRI
 *  https://VisionAcademy.online
 *  All Rights Reserved@2011-2018
 */
/**
 *
 * @author IT676
 */
public class Gym  implements java.io.Serializable{

    private int gID;
    private String location;
    private double fee;
    private String[] membersID;
    private int nbM;

    public Gym(int id, String loc, double f, int size) {

        gID = id;
        location = loc;
        membersID = new String[size];

        //validation
        while (f < 0 || f > 5000) {

            try {

                throw new InvalidFeeException("Invalid fee ...");

            } catch (InvalidFeeException ex) {

                System.out.print("Please enter a valid fee :");
                Scanner input = new Scanner(System.in);
                f = input.nextDouble();

            }
        }

        fee = f;

    }

    public boolean addMemebr(String id) {

        if (nbM == membersID.length) {
            return false;
        }

        membersID[nbM++] = id;
        return true;
    }

    public String getLoction(){
        
        return location;
    }
    
    
    
    
    public double  getFee(){
        
        return fee;
    }
    @Override
    public String toString() {

        String info = "";

        info += "Gym ID : " + gID + " , Location:" + location + " , Fee: " + fee + "\n";

        info += " Members: \n";
        for (int i = 0; i < nbM; i++) {
            info += membersID[i] + "\n";

        }

        return info;

    }
}
