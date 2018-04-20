package store.classes;

import java.io.*;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author IT676
 */
public class Store {

    private String storeName;
    private int numOfItems = 7;
    private int numOfCustomers = 1;

    public static TechnicalDevice[] devices = new TechnicalDevice[100];
    public Customer[] customers = new Customer[1000];

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
                    items.append(device.toString()).append("\n");
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
                    items.append(device.toString()).append("\n");
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
                items.append(device.toString()).append("\n");
            }

        }

        return items.toString();
    }

    public boolean placeOrder(String customerID, String[] itemID, int[] q, String c) {

        boolean isPlacedSuccessfuly = true;//flag to indicate that whether the order is placed or not

        //---------------------------------------------------------------------//
        //main method for Testing purpose olny , we remove it later 
        try {
            this.main(null);
        } catch (IOException ex) {

            Logger.getLogger(Store.class.getName()).log(Level.SEVERE, null, ex);
        }

        //---------------------------------------------------------------------//
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
                                    boolean isItemAdded = order.addItemOrder(new ItemOrder(itemID[i], q[i], price));

                                    //track the item if it's added by any flag you'd like 
                                    //I will make the string of the id null to use it later to track the items 
                                    //that not added to this order 
                                    //remove itemId from itemID list
                                    if (isItemAdded) {

                                        itemID[i] = null;//flag to indicate that the item is added and removed from the list

                                    }
                                    device.remove(q[i]);//decrease quantity of this device
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
            //add this order to cutomers order history[list]
            customer.orders[--customer.numOfOrders] = order; // number of order now is 1 , so decrease it to store the first order in first index [0]

        } else {
            //reset the number of orders 
            customer.numOfOrders--;
        }
        return isPlacedSuccessfuly;//process complete 
    }//end of placeOrder

    //main method for Testing purpose olny , we remove it later 
    public static void main(String[] args) throws FileNotFoundException, IOException {

        Store store = new Store("The Dreams Electronics Store");

        store.customers[0] = new Customer("Sara", "sa", "1234");
//
//        store.devices[0] = new DesktopComputer("1234id", 13.2, "i7", 16, "Silver", "Apple", 9999.9, 10, "CD");
//        store.devices[1] = new DesktopComputer("1334id", 13.2, "i8", 8, "Black", "Samsung", 9999.9, 10, "CD");
//        store.devices[2] = new DesktopComputer("1434id", 13.2, "i9", 4, "White", "Apple", 9999.9, 10, "DVD");
//        store.devices[3] = new DesktopComputer("1534id", 13.2, "i3", 32, "Gold", "Dell", 9999.9, 10, "Burner");
//        store.devices[4] = new Laptop("1534id", 18.2, "i3", 16, "Gold", "Dell", 9999.9, 10, true, true);
//        store.devices[5] = new Laptop("1634id", 16.2, "i3", 8, "Black", "Dell", 9999.9, 10, true, false);
//        store.devices[6] = new Laptop("1734id", 14.2, "i3", 11, "Silver", "Apple", 9999.9, 0, false, true);
//
//        System.out.println("All:\n" + store.displayAvaiableItems());
//        System.out.println("By Brand:\n" + store.displaybyBrand("Apple"));
//        System.out.println("By Type:\n" + store.displaybyType(1));
//
//        String[] itemsIDs = {"1234id", "1734id"};
//        int[] q = {1, 28};
//
//        boolean result = store.placeOrder("sa", itemsIDs, q, "SA");
//
//        System.out.println(result);
        store.devices[0]
                = new DesktopComputer("d1", 27.0, "Intel Core i5", 4, "White", "Apple", 5000.0, 2, "CD burner");

        store.devices[1]
                = new DesktopComputer("d2", 21.5, "Intel Core i3", 8, "Grey", "HP", 4000.0, 4, "SuperMulti DVD Burner");

        store.devices[2]
                = new DesktopComputer("d3", 19.5, "Intel Core i7", 16, "Black", "Dell", 3000.0, 2, "CD burner ");

        store.devices[3]
                = new DesktopComputer("d4", 23.8, "Intel Core i5", 32, "Black", "Apple", 8000.0, 4, "SuperMulti DVD Burner");

        store.devices[4]
                = new DesktopComputer("d5", 23.8, "Intel Core i5", 32, "Black", "Dell", 6000.0, 3, "SuperMulti DVD Burner");

        store.devices[5]
                = new Laptop("d6", 13.3, "Intel Core i5", 4, "White", "Apple", 7000.0, 5, true, true);

        store.devices[6]
                = new Laptop("d7", 14.0, "Intel Core i5", 4, "Black", "Dell", 5000.0, 5, false, false);

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("TechnicalDevices.ser"));

        for (int i = 0; i < 7; i++) {

            oos.writeObject(devices[i]);
        }
        oos.close();

    }

    public Customer[] getUsers() {

        try {
            Store.main(null);
        } catch (IOException ex) {
            Logger.getLogger(Store.class.getName()).log(Level.SEVERE, null, ex);
        }
        return customers;
    }
}
