

public class Normal extends Customer {
    
    
    public Normal (String n , String id , int s){
        
        super(n , id  , s);
        
    }
    
    
    @Override
    public void  addPoint(double amount){

        super.addPoint(amount);
    }
    
}
