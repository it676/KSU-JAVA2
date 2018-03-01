


public class Flight {
    
    private String flightNum="SV";
    private int day ;
    private String destination;
    
    private Passenger[] PassengerList;
    private int numOfPassenger;
    
    
    public Flight (int num , int d , String des, int size){
    
      flightNum+= num;
      day = d;
      destination = des;
      
      PassengerList = new Passenger[size];
      numOfPassenger=0;
}
    
    
    public Flight (Flight  F){
        
        this.flightNum = F.flightNum;
        this.day = F.day;
        this.destination =  F.destination;
        
        this.PassengerList = new Passenger[F.PassengerList.length];

        
        for (int i = 0; i <F.numOfPassenger; i++) {
            
            this.PassengerList[i] = F.PassengerList[i];
            this.numOfPassenger++;
        }
        
       
    }
    
    
    
    public boolean addPassenger(Passenger  p){
        
        if(numOfPassenger  ==  PassengerList.length)
            return false;
        
        PassengerList[numOfPassenger++] = p;
        return true;
       
    }
    
    
    
    //set
    //get
    
    public String getFlightNumber(){
        
        return flightNum;
    }
    
    public String getDestination(){
        
        return destination;
    }
    
    public int getDay(){
        
        return day;
    }
    
    
    public int  getNumOfPassengers(){
        
        return numOfPassenger;
    }
    
    @Override
    public String toString(){

        return String.format("Flight Num: %s\tDay : %d\t Destination :%s", 
                             flightNum,day,destination);
    }
    
    
}
