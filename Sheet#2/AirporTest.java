


public class AirporTest {
    
    
    public static void main(String[] args) {
        
        
        
        Airport  RiyadhAirport = new Airport("King Khalid" , 10);
        
        
        Flight[] newFlights = new Flight[3];
        newFlights[0] = new Flight(435,2,"Paris",40);
        
        newFlights[0].addPassenger(new Passenger(232 ,"Sara"));
        newFlights[0].addPassenger(new Passenger(444 ,"Amal"));
       
        
        newFlights[1] = new Flight(666,4,"Paris",40);
        
        newFlights[1].addPassenger(new Passenger(666,"Noura"));
        
        newFlights[2]=new Flight(820,2,"London",40);
       
        newFlights[2].addPassenger(new Passenger(168,"Khulud"));
        newFlights[2].addPassenger(new Passenger(655,"Atheer"));
        newFlights[2].addPassenger(new Passenger(589,"Asma"));

        
        for (int i = 0; i < newFlights.length; i++) {

            RiyadhAirport.addFlight(newFlights[i]);
            
        }
        
        int total= RiyadhAirport.searchFlgihts("aris");
        
//System.out.println("Number of Flights that will land in Paris is :"+total);
        
        
        
        Flight[] flightsInDay = RiyadhAirport.FindFlightInDay(2);
       
        for (int i = 0; i <flightsInDay.length; i++) {
            
           // System.out.println(flightsInDay[i]);
        }
        
        
       
 Flight[]  flightsMoreThat2 = RiyadhAirport.PassengersInFlight(2);


            for(int i=0; i<flightsMoreThat2.length;i++ ){


             
                    System.out.println(flightsMoreThat2[i].getFlightNumber());

        }

        
        
    }
}
