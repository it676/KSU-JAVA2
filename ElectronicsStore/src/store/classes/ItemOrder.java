package store.classes;

import java.io.Serializable;

/**
 *
 * @author IT676
 */
public class ItemOrder implements Item, Serializable {

    private final String itemID;
    private final int quantity;
    private final double price;

    public ItemOrder(String id, int quantity, double price) {
        itemID = id;
        this.quantity = quantity;
        this.price = price;

    }

    public void addItem(TechnicalDevice[] devices) {

        for (TechnicalDevice device : devices) {
            if (device != null) {
                if (device.getItemID().equals(itemID)) {
                    device.quantity++;
                    return;
                }
            }
        }
    }

    public void removeItem(TechnicalDevice[] devices) {

        for (TechnicalDevice device : devices) {
            if (device != null) {
                if (device.getItemID().equals(itemID)) {
                    device.quantity--;
                    return;
                }
            }
        }
    }

    @Override
    public double getPrice() {

        return price;
    }

    @Override
    public int getQuantity() {

        return quantity;
    }

    public String getItemId() {

        return itemID;
    }

    @Override
    public String toString() {

        return String.format("Item ID: %s Price:%.2f Quantity: %d",
                itemID, price, quantity);
    }

}
