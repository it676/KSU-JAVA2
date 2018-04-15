package com.electronic.store;



import java.util.Date;

/**
 *
 * @author IT676
 */
public class Order {

    private String orderID;
    private Date orderDate;
    private boolean orderCompleted;
    private double totalPrice;
    private String Country;

    private ItemOrder[] itemsList;
    private int numOfitems;

    public Order(String id, Date d, int size, String country) {

        this.orderID = id;
        orderDate = d;
        orderCompleted = false; //init  is not complete -->[ also by default is false ]
        this.Country = country;
        itemsList = new ItemOrder[size];
        numOfitems = 0;

    }

    public boolean addItemOrder(ItemOrder t) {

        if (numOfitems == itemsList.length) {
            return false;
        }

        itemsList[numOfitems++] = t;
        return true;
    }

    public boolean removeItemOrder(String id) {

        for (int i = 0; i < numOfitems; i++) {

            if (itemsList[i].getItemId().equalsIgnoreCase(id)) {

                //shift the element ---> remove operation 
                for (int j = i; j < numOfitems - 1; j++) {

                    itemsList[j] = itemsList[j + 1];
                    return true;
                }
            }
        }

        return false;
    }

    public void setStatus(boolean status) {

        orderCompleted = status;
    }

    public boolean IsCompleted() {

        return orderCompleted;
    }

    public void setTotalPrice() {

        //loop through  itemsList  to calculate total price for all items
        for (int i = 0; i < numOfitems; i++) {

            ItemOrder item = itemsList[i];

            double singleItemPrice = item.getPrice() * item.getQuantity();

            this.totalPrice += singleItemPrice;
        }

        //shipping charges
        this.totalPrice += calculateShipping();
    }

    public double calculateShipping() {

        //shipping
        double shippingCost = 0;

        switch (Country.toUpperCase()) {

            case "SA":
                shippingCost = 100;
                break;

            case "BH":
                shippingCost = 260;
                break;

            case "KWT":
                shippingCost = 300;
                break;

            case "UAE":
                shippingCost = 550;
                break;

        }

        return shippingCost;
    }

    public int getNumOfitems() {

        return numOfitems;
    }

    public ItemOrder[] getitems() {

        //you can return the entire array directlly :
        // return itemsList;
        //but it's better  to return array containg the items inserted only , not the entire array
        //if not items 
        if (numOfitems == 0) {
            return null;
        }

        ItemOrder[] items = new ItemOrder[numOfitems];

        for (int i = 0; i < numOfitems; i++) {

            items[i] = itemsList[i];
        }

        return items;

    }

    @Override
    public String toString() {

        //if no items added  then return null to indicate that no order made to show
        if (this.numOfitems == 0) {
            return null;
        }

        StringBuilder orderData = new StringBuilder(); //better than String object for performance reasons

        orderData.append("Order ID : ").append(orderID);
        orderData.append("Order Date : ").append(orderDate);
        //...
        //...

        //append ordered items
        for (ItemOrder item : getitems()) {
            orderData.append(item.toString());
        }

        return orderData.toString();
    }
}
