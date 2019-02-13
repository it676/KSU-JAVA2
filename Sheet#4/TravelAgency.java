
/**
 *
 * @author IT676
 */
public class TravelAgency {

    private Ticket[] Issues;
    private int numOfTickets;

    public TravelAgency(int size) {

        Issues = new Ticket[size];
        numOfTickets = 0;
    }

    public boolean addReservation(Ticket t) {

        //if array if full 
        if (numOfTickets == Issues.length) {
            return false;
        } else {//location for more ticket is available

            //get the common attributes
            String name = t.getPassengerName();
            String dep = t.getDeparture();
            String des = t.getDestination();
            String date = t.getDate();
            String ticketClass = t.getClassOfService();

            if (t instanceof BusTicket) {
                double distance = ((BusTicket) t).getDistance();
                Issues[numOfTickets++] = new BusTicket(name, dep, des, date, ticketClass, distance);
            } else if (t instanceof AirlineTicket) {
                String companyName = ((AirlineTicket) t).getCompanyName();
                Issues[numOfTickets++] = new AirlineTicket(name, dep, des, date, ticketClass, companyName);

            } else {
                System.out.println("Unknow Ticket Type !");
                return false;
            }
            
            
            //call the method to calculate and  set the Total Price for the added ticket
            int lastAddedTicketIndex = numOfTickets - 1;
            Issues[lastAddedTicketIndex].setTotalPrice();
            
            return true;
        }//end else
    }//end method addReservation

    public boolean cancelReservation(int index) {

        if (index < 0 || numOfTickets) {
            return false;
        }

        for (int i = index; i < numOfTickets - 1; i++) {

            Issues[i] = Issues[i + 1];
        }
        Issues[--numOfTickets] = null;

        return true;

    }//end of cancelReservation method

    public Ticket[] allTickets(String companyN){
        
        int sizeCounter = 0;
        
        for (int i = 0; i < numOfTickets; i++) {
            
            if(Issues[i] instanceof AirlineTicket){
                
                 if((((AirlineTicket) Issues[i])).getCompanyName().equalsIgnoreCase(companyN))
                     sizeCounter++;
            }
        }
        
        if (sizeCounter == 0 )
             return null;
        
        //array creation
        Ticket[] airlineCompTickets = new Ticket[sizeCounter];
        
         for (int i = 0 , j=0; i < numOfTickets; i++) {
            
            if(Issues[i] instanceof AirlineTicket){
                
                 if(((AirlineTicket) Issues[i]).getCompanyName().equalsIgnoreCase(companyN))
                     airlineCompTickets[j++] = Issues[i] ;
            }
        }
         
         return airlineCompTickets;
        
        
    }//end of allTickets method
    
    
    
    public void display(){
        
        //Edit : use printf to make the output looks professional 
        
        System.out.println("Welcome  , Travel Agency Details as follows : ");
        
        System.out.println("Number of currently tickets is :" + numOfTickets);
        
        for (int i = 0; i < numOfTickets; i++) {
            
            System.out.println(Issues[i].toString());//polymorphic mehtod
            System.out.println("-------------------------------");
        }
    }
}
