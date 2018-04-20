package store.classes;




/**
 *
 * @author IT676
 */
public class ItemOrder implements Item {

    private String itemID;
    private int quantity;
    private double price;

    public ItemOrder(String id, int quantity, double price) {
        itemID = id;
        this.quantity = quantity;
        this.price = price;

    }

    public void addItem() {

    }
 

    @Override
    public double getPrice() {

        return price;
    }

    @Override
    public int getQuantity() {

        return quantity;
    }

   public String getItemId(){
       
       return itemID;
   }
    
    @Override
    public String toString() {

        return String.format("%s  %s  %s", itemID, quantity, price);
    }

}
