




public class CashierLine {
    
    int nbC;
    private  Customer[] customerLine ;
    
    public CashierLine(){
        
        customerLine = new Customer[100];
        nbC = 0;
    }
    
    public boolean enqueue(Customer C){
        
        if(nbC  == customerLine.length) 
            return false;
        
        
      
        //vip customer
        if ( C instanceof VIP ){
                 
               int i;
               
                 for ( i = 0; i < nbC; i++)
                    if(customerLine[i] instanceof Normal)
                        break;
               
              return  addCustomer(i , C);
            
        }
        
        //noraml customer
        return addCustomer(C);
        
    }
    
    private boolean  addCustomer(int index  , Customer C){
       
      
        for (int i = index; i < nbC ; i++) {
            
              customerLine[i+1] = customerLine[i];
        }
        
        customerLine[index] = C;
        nbC++;
        return true;
    }
    
    private  boolean addCustomer(Customer C){
        
        customerLine[nbC++] = C;
        return true;
    }
    
    public Customer  serve(boolean offer, char t){
        
        
        Customer  removedCustomer = customerLine[0];
        
        
        for (int i = 0; i < nbC - 1; i++) {
            
            customerLine[i] = customerLine[i+1];
        }
        
        customerLine[--nbC] = null;
        
       
        endPurchase(removedCustomer ,offer , t);
        
        return  removedCustomer;
    }
    
    private void endPurchase(Customer  C  , boolean offer  , char type){
        
        if(offer){
            
             type = Character.toUpperCase(type);
            
             switch (type) {
                
                case 'P':
                    
                           if(C instanceof VIP){
                               
                                 VIP  vipCustomer = (VIP) C;
                                 String category = vipCustomer.getCategory().toUpperCase();
                                 
                                   switch (category) {
                                   
                                    case "GOLD":
                                        
                                        vipCustomer.addPoint(-C.calculatePaymentAmount());
                                        
                                       break;
                                       
                                   case "SILVER":
                                       
                                        vipCustomer.addPoint(-C.calculatePaymentAmount()/2);
                                        
                                       break;
                                   
                                   default:
                                       System.out.println("Invalid  Category !");
                               }
                                 
                               
                           }else{///noraml customer
                               

                               Normal normalCustomer  = (Normal) C;
                               normalCustomer.addPoint(-C.calculatePaymentAmount()*0.1);
                           }
                    
                    break;
                    
                    
                    
                case 'D':
                    
                    double paymentAmount = C.calculatePaymentAmount();
                    
                        if(C instanceof VIP){
                               
                                 VIP  vipCustomer = (VIP) C;
                                 String category = vipCustomer.getCategory().toUpperCase();
                                 
                                   switch (category) {
                                   
                                    case "GOLD":
                                        
                                      vipCustomer.setPaymentAmount(paymentAmount * 0.3);
                                        
                                       break;
                                       
                                   case "SILVER":
                                       
                                      vipCustomer.setPaymentAmount(paymentAmount * 0.1);
                                        
                                       break;
                                   
                                   default:
                                       System.out.println("Invalid  Category !");
                               }
                                 
                               
                           }
                    
                    else {//normal customer
                          C.setPaymentAmount(paymentAmount * 0.05);
                    }
                    
                break;
                
                default:
                    
                    System.out.println("Invalid Prize Type 1");
            }
            
        }
        else {//no offer
           
          if(C instanceof VIP){
               VIP  vipCustomer = (VIP) C;
                   String category = vipCustomer.getCategory().toUpperCase();
                     
                   if(category.equals("GOLD")){
                       
                       vipCustomer.addPoint(C.calculatePaymentAmount());
                   }
                   else if(category.equals("SILVER")){
                     vipCustomer.addPoint(C.calculatePaymentAmount()/2);
 
                   }
                   
                   else 
                     System.out.println("Invalid Categroy !");
               
          }
          else { //normal customer 
              
              
              Normal normalCustomer  = (Normal) C;
              normalCustomer.addPoint(C.calculatePaymentAmount()*0.1);
                      
          }
                         
                                 
        }
        
    } 

    public int merge(CashierLine cl){
      
      int addedCustoemrs = 0;
      for (int i = 0; i < cl.nbC; i++) {
          
          if(nbC == customerLine.length )
              break;
          
          addCustomer(cl.customerLine[i]);
          addedCustoemrs++;
      }
      
      return addedCustoemrs;
      
  }
}
