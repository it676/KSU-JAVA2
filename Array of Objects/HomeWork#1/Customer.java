

public class Customer {
    
    private String name;
    private String ID;
    private int points;
    private int numItems; //counter
    private double paymentAmount;
    
    private Item[] itemList;
    
    
    public Customer(String n , String id , int size){
        
        name = n;
        ID = id;
        itemList =new Item[size];
        
        paymentAmount= points = numItems = 0;
        
      
    }
   
    public boolean addItem(Item i){
        
        if (numItems == itemList.length)
            return false;
       
        
        itemList[numItems++] = new Item(i.getName() , i.getPrice());
        return true;
    }
    
    
    public void addPoint(double amount){
        
        points += amount;
    }
    
    
    public double calculatePaymentAmount(){
        
        for (int i = 0; i < numItems; i++) {
            
             paymentAmount += itemList[i].getPrice();
        }
        
        return paymentAmount;
    }

    
    
    public double getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(double paymentAmount) {
        this.paymentAmount = paymentAmount;
    }
    
    
    
}
