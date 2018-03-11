

public class Passenger {
    
    private int pID;
    private String name;
    
    public Passenger(int id , String n  ){
        
        pID = id;
        name = n;

    }
    
    
    //set
    
    //get
    
    @Override 
    public String toString(){
        
        return String.format("ID :%d\tPassenger's Name :%s%n", name,pID);
    }
    
}
