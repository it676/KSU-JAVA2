



public class VIP extends Customer  {
    
    private String category;
    
    public VIP(String n , String id , String c  , int  s){
        
        super(n , id , s);
        
        category = c;
    }
    
    
    
    public String getCategory(){
        
        return category;
    }
    
    
    @Override
    public void  addPoint(double amount){
        
        super.addPoint(amount);
    }
}
