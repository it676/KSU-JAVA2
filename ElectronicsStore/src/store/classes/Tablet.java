package store.classes;

/**
 *
 * @author IT676
 */
public class Tablet extends TechnicalDevice {

    private int noOfSim;
    private String network;

    public Tablet(String ID, double size, String pType,
            int ram, String color, String b, double p,
            int q, int sim, String net) {

        super(ID, size, pType, ram, color, b, p, q);
        noOfSim = sim;
        network = net;

    }

    @Override
    public double getPrice() {

        if (noOfSim == 2) {
            this.price += 200;
        }

        switch (network.toUpperCase()) {
            case "4G":
                this.price += 100;
                break;

            case "WIFI":
                this.price += 150;
                break;
        }

        return price;

    }

    @Override
    public String toString() {

        return String.format("%s  %s  %s", super.toString(), noOfSim, network);

    }

}
