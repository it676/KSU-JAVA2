

public class Airport {
    
    
    private String name;
    
    private Flight[] FlightList;
    
    private int numOfFlight;
    
    public Airport(String n , int size){
        
        name = n;
        FlightList = new Flight[size];
        numOfFlight = 0;
        
        
    }
    
    public boolean addFlight(Flight  F){
        
        if(numOfFlight <  FlightList.length){
            FlightList[numOfFlight++] = new Flight(F);//comp
            return true;
        }
        
        return false;
            
            
    }
    
    
    public int getNumOfFlight(){
        
        return numOfFlight;
    }
    
    public  boolean isFull(){
 
        return  (numOfFlight == FlightList.length);
    }
    
    public int  searchFlgihts(String des){
        
        
        int totalFlights=0;
        
        
        for (int i = 0; i <numOfFlight; i++) {
            
            if(FlightList[i].getDestination().equalsIgnoreCase(des)){
                totalFlights++;
            }
        }
        
        
        return totalFlights;
    }
    
    
    public Flight[] FindFlightInDay(int d){
        
        
        int size=0;
        
        for (int i = 0; i <numOfFlight; i++) {
            
            if(FlightList[i].getDay() == d)
                size++;
        }
        
        if(size==0)
            return null;
        Flight[] foundFlights= new Flight[size];
        
        
        for (int i = 0 , j=0; i <numOfFlight; i++) {
            
            if(FlightList[i].getDay() ==  d){
                
                foundFlights[j++] = FlightList[i];
                
            }
        }
        
        
        return foundFlights;
    }
    
    
    
    public Flight[] PassengersInFlight(int num){
        
        
        int size=0;
        
        for (int i = 0; i <numOfFlight; i++) {
            
            if(FlightList[i].getNumOfPassengers() > num)
                size++;
        }
        
        Flight[] foundFlights= new Flight[size];
        
        
        for (int i = 0 , j=0; i <numOfFlight; i++) {
            
            if(FlightList[i].getNumOfPassengers() > num){
                
                foundFlights[j++] = FlightList[i];
                
            }
        }
        
        
        return foundFlights;
    }
    
    
    
    
    public Flight[] getFlightList(){
        
        return FlightList;
    }
    
    
    
    @Override
    public String toString(){
        
        
        
        return String.format("Airpot Name is:%s Num of Flights :%d",
                name , numOfFlight);
        
    }
}
