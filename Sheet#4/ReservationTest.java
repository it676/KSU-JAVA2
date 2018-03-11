

/**
 *
 * @author IT676
 */
public class ReservationTest {
    
    
    public static void main(String[] args) {
        
        //create travel agency object
        TravelAgency Altayyar = new TravelAgency(20);
        
        //creating and storing object for processing using array
        Ticket[]  ticketsToAdd = new Ticket[4];
        
        ticketsToAdd[0] = new BusTicket("Nora Ali","Riyadh","Jeddah","28/02/2018","Standard",600);
        ticketsToAdd[1] = new AirlineTicket("Sara Saad","Riyadh","Khobar","03/03/2018","Business","Flynas");
        ticketsToAdd[2] = new AirlineTicket("Ahmad Ali","Riyadh","Dammam","13/03/2018","Economy","Saudia");
        ticketsToAdd[3] = new AirlineTicket("Maha Hamad","Riyadh","Jeddah","20/04/2018","Business","Saudia");
        
        //adding objects
        for (int i = 0; i < ticketsToAdd.length; i++) {
            
             boolean isAdded = Altayyar.addReservation(ticketsToAdd[i]);
             System.out.println((isAdded)?"The Ticket was added successfully":"The Ticket was not added !");
        }
       
        
        //display all the issued tickets 
          Altayyar.display();
        

       //cancel a ticket
        boolean isCancelled = Altayyar.cancelReservation(0);
        System.out.println((isCancelled)?"The ticket was found and cancelled successfully !":"Ticket was not found !");
        
        
        
                
        
        //get and display all tickets belonging to Saudia 
       Ticket[] saudiaTickets =  Altayyar.allTickets("Saudia");
       
       for (int i = 0; i < saudiaTickets.length; i++) {
           
            System.out.println(saudiaTickets[i].toString());
        }
       
       
       
        //display all the issued tickets after the update 
        Altayyar.display();
        
       
    }
}
