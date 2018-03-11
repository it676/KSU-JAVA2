
/**
 *
 * @author IT676
 */
public abstract  class Ticket {

    //instance variables
    protected String passengerName;
    protected String departure;
    protected String destination;
    protected String date;
    protected String classOfService;
    protected double totalPrice;
    
    
    //constructor 
    public  Ticket(String name, String dep, String des,String date, String ticketClass) {
        passengerName = name;
        departure = dep;
        destination = des;
        this.date = date;
        classOfService = ticketClass;
        
    }

    public String getPassengerName() {
        return passengerName;
    }

    public String getDeparture() {
        return departure;
    }

    public String getDestination() {
        return destination;
    }

    public String getDate() {
        return date;
    }

    public String getClassOfService() {
        return classOfService;
    }

    public double getTotalPrice() {
        return totalPrice;
    }
   
    public abstract void setTotalPrice();
    
  @Override
  public String toString(){
     
      return String.format("Passenger Name : %S  Departure: %s   Destination: %s%nDate: %s"
                          + "  Class :%s%nTotal Price:%.2f%n",
                            getPassengerName(),getDeparture(),getDestination(),
                            getDate(),getClassOfService(),getTotalPrice());
  }
    
}
