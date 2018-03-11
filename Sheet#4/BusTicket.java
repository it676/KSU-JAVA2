



/**
 *
 * @author IT676
 */
public class BusTicket  extends Ticket{
    
    private double distance; //could be double if you want. 
    
    public  BusTicket(String name, String dep, String des,
                      String date, String ticketClass, double distance){
        
        super(name , dep , des ,date ,ticketClass );
        this.distance = distance;
    }

    public double getDistance() {
        return distance;
    }


    //implement the abstract method
    @Override
    public void setTotalPrice() {

        /*      
            you can use switch aslo   
            or 
            condetional opertor   variable = (condetion) ? value1 : value2
       */
        
        if(classOfService.equalsIgnoreCase("Standard"))
            totalPrice = (getDistance() * 0.5) + 50;
        
        else if(classOfService.equalsIgnoreCase("Premier"))
                 totalPrice = (getDistance() * 0.5) + 200;
        else {
            
               System.out.println("Error : Unknown Class of Service !");
               totalPrice = 0.0;
        }
    }//enf of setTotalPrice method
    
    @Override
    public String toString(){
        
        return String.format("%sDistnace is : %.2f", super.toString(),getDistance());
    }

    
}
