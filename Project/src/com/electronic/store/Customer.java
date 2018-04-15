package com.electronic.store;

/**
 *
 * @author IT676
 */
public class Customer {

    private String name;
    private String ID;
    private String password;
    public int numOfOrders = 0;

    private Order[] orders;
    private Order currentOrder;

    public Customer(String n, String ID, String p) {

        name = n;
        this.ID = ID;
        password = p;

    }

    public String getName() {
        return name;
    }

    public String getID() {
        return ID;
    }

    public String getPassword() {
        return password;
    }

    public void displayOrderHistory() {
        if (numOfOrders == 0) {
            System.out.println("You did not made any order yeat");
        }

    }
}
