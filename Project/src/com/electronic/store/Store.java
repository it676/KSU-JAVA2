package com.electronic.store;


import java.util.Date;

/**
 *
 * @author IT676
 */
public class Store {

    private String storeName;
    private int numOfItems;
    private int numOfCustomers;

    private TechnicalDevice[] devices;
    private Customer[] customers;

    public Store(String name) {

        storeName = name;
    }

    public boolean login(String id, String password) {

        for (Customer customer : customers) {

            String cusId = customer.getID();
            String cusPass = customer.getPassword();

            //match ---> user logged in
            if (cusId.equals(id) && cusPass.equals(password)) {
                return true;
            }
        }

        //invalid id or password
        return false;
    }

    public boolean registerUser(String name, String id, String password) {

        if (numOfCustomers == customers.length) {
            return false;
        }

        customers[numOfCustomers] = new Customer(name, id, password);
        return true;
    }

    public String displaybyType(int t) {

        /*we will display products by the type 
         t= 0  ---> for Desktop 
         t= 1  ---> for Desktop 
         t= 2  ---> for Desktop 
         t=other values ---> return null or any text you would
         
         */
        String type;
        switch (t) {

            case 0:
                type = "Desktop";
                break;

            case 1:
                type = "Labtop";
                break;

            case 2:
                type = "Tablet";
                break;

            default:
                return "Sorry , No items found matching this type !";
        }

        StringBuilder items = new StringBuilder();

        for (TechnicalDevice device : devices) {

            if (device != null) {
                if (device.getClass().getSimpleName().equalsIgnoreCase(type)) {

                    //append the data of the product
                    items.append(device.toString());
                }
            }
        }

        return items.toString();

    }

    public String displaybyBrand(String brandN) {

        StringBuilder items = new StringBuilder();

        for (TechnicalDevice device : devices) {
            if (device != null) {
                if (device.getBrand().equalsIgnoreCase(brandN)) {

                    //append the data of the product
                    items.append(device.toString());
                }
            }
        }

        return items.toString();

    }

    public String displayAvaiableItems() {

        StringBuilder items = new StringBuilder();

        for (TechnicalDevice device : devices) {

            //append the data of the product
            if (device != null) {
                items.append(device.toString());
            }

        }

        return items.toString();
    }

    public boolean placeOrder(String customerID, String[] itemID, int[] q, String c) {

        Customer customer = getCustomer(customerID);
        if (customer == null) {
            return false;
        }

        String orderId = "" + customer.numOfOrders;

        Order order = new Order(orderId, new Date(), itemID.length, c);

        for (int i = 0; i < itemID.length; i++) {
           
         
        }
        
        return true;
    }

    
    //helper method to be used in diff methods
    private Customer getCustomer(String id) {
        for (Customer customer : customers) {

            //match 
            if (customer.getID().equals(id)) {
                return customer;
            }
        }

        return null;
    }
    
    public static void main(String[] args) {
        System.out.println("test");
    }
}
