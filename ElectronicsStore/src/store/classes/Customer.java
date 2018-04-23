package store.classes;

import java.io.*;

/**
 *
 * @author IT676
 */
public class Customer implements Serializable {

    private String name;
    private String ID;
    private String password;
    public int numOfOrders = 0;

    public Order[] orders = new Order[100];
    public Order currentOrder;

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

    //not copmleted yet
    public String displayCurrentOrder() {

        return this.currentOrder.toString();
    }

    public boolean saveCurrentOrdrer() {

        PrintWriter writer = null;
        try {

            File file = new File("currentOrder.txt");

            if (!file.exists()) {

                file.createNewFile();
            }

            writer = new PrintWriter(new FileOutputStream(file));

            String data = currentOrder.toString().replace("<html>", "");
            data = data.replace("<br>", "\n");
            data = data.replace("</html>", "");
            writer.println(data);

            return true;//process completed !

        } catch (FileNotFoundException ex) {

            return false;
        } catch (IOException ex) {

            return false;

        } finally {
            if (writer != null) {
                writer.close();
            }
        }
    }

    public String displayOrderHistory() {

        String data = "";

        if (numOfOrders == 0) {
            return "You did not made any order yeat";
        }
        for (int i = 0; i < numOfOrders; i++) {

            Order order = orders[i];
            if (order != null) {

                if (order.IsCompleted()) {
                    data += order.toString();
                    data += "\n---------------------------------\n";

                }
            }

        }

        data = data.replace("<html>", "");
        data = data.replace("<br>", "\n");
        data = data.replace("</html>", "");
        return data;

    }
}
