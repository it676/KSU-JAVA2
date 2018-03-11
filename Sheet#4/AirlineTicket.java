
/**
 *
 * @author IT676
 */
public class AirlineTicket extends Ticket {

    private String companyName;

    public AirlineTicket(String name, String dep, String des,
            String date, String ticketClass, String companyN) {

        super(name, dep, des, date, ticketClass);

        this.companyName = companyN;
    }

    public String getCompanyName() {
        return companyName;
    }

    //implement the abstract method
    @Override
    public void setTotalPrice() {

        // if Economy
        if (classOfService.equalsIgnoreCase("Economy")){
               
                  //if Economy and Flynas
               if(getCompanyName().equalsIgnoreCase("Flynas"))
                   totalPrice = 390.0;
                
                    //if Economy and Saudia
               else if(getCompanyName().equalsIgnoreCase("Saudia"))
                       totalPrice = 570.0;
               else{//if Unknown company
                   System.out.println("Error : Company Name !");
                    totalPrice = 0.0;
               }
                   
               
        }//if Business
        else  if (classOfService.equalsIgnoreCase("Business")){
            
             //if Business and Flynas
             if(getCompanyName().equalsIgnoreCase("Flynas"))
                   totalPrice = 650.0;
               
              //if Business and Saudia
               else if(getCompanyName().equalsIgnoreCase("Saudia"))
                       totalPrice = 2100.0;
               else{//if Unknown company
                   System.out.println("Error : Company Name !");
                    totalPrice = 0.0;
               }
        }
        
         else {//if Unknown 
            
               System.out.println("Error : Unknown Class of Service !");
               totalPrice = 0.0;
        }
    }

    @Override
    public String toString() {

    return String.format("%sCompany Name is : %s", super.toString(),getCompanyName());

    }

}
