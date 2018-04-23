package store.classes;

import java.io.*;
import java.util.Date;

/**
 *
 * @author IT676
 */
public class Store {

    private String storeName;
    private int numOfItems = 0;
    private int numOfCustomers = 0;

    public TechnicalDevice[] devices = new TechnicalDevice[100];
    public Customer[] customers = new Customer[100];

    public Store(String name) {
        customers[0] = new Customer("Sara", "sa", "1234");//testing
        storeName = name;
    }

    public boolean login(String id, String password) {

        for (int i = 0; i < numOfCustomers; i++) {

            Customer customer = customers[i];

            if (customer != null) {
                String cusId = customer.getID();
                String cusPass = customer.getPassword();

                //match ---> user logged in
                if (customer.getID().equals(id) && cusPass.equals(password)) {
                    return true;
                }
            }
        }

        //invalid id or password
        return false;
    }

    public boolean registerUser(String name, String id, String password) {

        if (numOfCustomers == customers.length) {
            return false;
        }

        //check if user-id already registered 
        for (int i = 0; i < numOfCustomers; i++) {

            if (id.equals(customers[i].getID())) {
                return false;
            }

        }

        //new user 
        customers[numOfCustomers++] = new Customer(name, id, password);
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
                type = "DesktopComputer";
                break;

            case 1:
                type = "Laptop";
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
                    items.append(device.toString()).append("\n")
                            .append("-------------------------------------------------------\n");
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
                    items.append(device.toString()).append("\n")
                            .append("-------------------------------------------------------\n");
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
                items.append(device.toString()).append("\n")
                        .append("-------------------------------------------------------\n");
            }

        }

        return items.toString();
    }

    public boolean placeOrder(String customerID, String[] itemID, int[] q, String c) {

        boolean isPlacedSuccessfuly = true;//flag to indicate that whether the order is placed or not

        //looking for the customer who made this order using customer id
        Customer customer = null;

        for (int i = 0; i < numOfCustomers; i++) {

            if (customerID.equals(customers[i].getID())) {
                customer = customers[i];  //customer found
            }

        }

        //if customer id not found !
        if (customer == null) {

            return false;//then terminate the process
        }

        //if customer was found
        //then create order id for this customer's order
        String orderId = "order" + ++customer.numOfOrders;

        //create the order object and pass the data to 
        Order order = new Order(orderId, new Date(), itemID.length, c);

        //add items to the order itemsList array
        for (int i = 0; i < itemID.length; i++) {

            if (itemID[i] != null) {

                //search devices array to find the item by id to get price
                double price;
                TechnicalDevice device;

                for (int j = 0; j < numOfItems; j++) {
                    device = devices[j];

                    if (device != null) {

                        if (device.getItemID().equalsIgnoreCase(itemID[i])) {

                            if (device.isAvaiable()) {

                                if (device.getQuantity() >= q[i]) {

                                    price = device.getPrice();
                                    ItemOrder itemOrder = new ItemOrder(itemID[i], q[i], price);
                                    boolean isItemAdded = order.addItemOrder(itemOrder);

                                    if (isItemAdded) {

                                        //remove items from the store by the number of quantity of this device
                                        for (int k = 0; k < q[i]; k++) {
                                            itemOrder.removeItem(devices);//pass the array to update
                                        }

                                        //track the item if it's added by any flag you'd like 
                                        //I will make the string of the id null to use it later to track the items 
                                        //that not added to this order 
                                        //remove itemId from itemID list
                                        itemID[i] = null;//flag to indicate that the item is added and removed from the list

                                    }

                                } else {
                                    isPlacedSuccessfuly = false;//Quantity not available
                                }
                            } else {
                                isPlacedSuccessfuly = false;//device not available
                            }

                        }
                    }

                }

            }

        }//end loop through items

        if (isPlacedSuccessfuly) {

            customer.currentOrder = order;//set current order for the customer to this order
        } else {
            //reset the number of orders 
            customer.numOfOrders--;
        }
        
        System.out.println(customer.numOfOrders);
        return isPlacedSuccessfuly;//process complete 
    }//end of placeOrder

    public Customer[] getUsers() {

        return customers;
    }

    public boolean cancelOrder(String cutomerID) {
        Customer customer = null;

        for (int i = 0; i < numOfCustomers; i++) {

            if (cutomerID.equals(customers[i].getID())) {
                customer = customers[i];  //customer found
            }

        }

        //if customer id not found !
        if (customer == null) {

            return false;//then terminate the process
        }

        //check if ther'se a current order for this customer if not return false;
        if (customer.currentOrder == null) {
            return false;
        }

        //get all items for the current order 
        ItemOrder[] items = customer.currentOrder.getitems();

        //check if it's null or empty ! ---> optional
        if (items != null && items.length > 0) {

            //process items one by one 
            for (ItemOrder item : items) {

                int q = item.getQuantity();

                for (int i = 0; i < q; i++) {

                    item.addItem(devices);//pass the array to update
                }

            }
        }

        //remove the current order
        customer.currentOrder = null;

        //decrease the number of total orders 
        customer.numOfOrders--;
        return true;
    }

    public boolean confirmOrder(String cutomerID) {

        Customer customer = null;

        for (int i = 0; i < numOfCustomers; i++) {

            if (cutomerID.equals(customers[i].getID())) {
                customer = customers[i];  //customer found
            }

        }

        //if customer id not found !
        if (customer == null) {

            return false;//then terminate the process
        }

        //check if there's a current order for this customer if not return false;
        if (customer.currentOrder == null) {
            return false;
        }

        //if currentOrder is private then use setters and getters 
        customer.currentOrder.setStatus(true);
        //add this order to cutomers order history[list]
        int index = customer.numOfOrders;
        customer.orders[--index] = customer.currentOrder; // number of order now is 1 , so decrease it to store the first order in first index [0]

        //saving the currentOrder into the file will be from the GUI 
        return true;
    }

    public int getNumOfItems() {

        return numOfItems;
    }

    //for array counter  from another calss since it's a private 
    public int setNumOfItems(int number) {

        return numOfItems += number;
    }

    public int getNumOfCustomers() {

        return numOfCustomers;
    }

    public int setNumOfCustomers(int number) {

        return numOfCustomers += number;
    }

   
}
