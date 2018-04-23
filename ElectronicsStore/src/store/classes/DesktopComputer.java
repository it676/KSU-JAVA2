package store.classes;

/**
 *
 * @author IT676
 */
public class DesktopComputer extends TechnicalDevice {

    private String opticalDrive;

    public DesktopComputer(String ID, double size, String pType, int ram, String color, String b, double p, int q, String opticalD) {

        super(ID, size, pType, ram, color, b, p, q);

        opticalDrive = opticalD;
    }

    @Override
    public double getPrice() {

        switch (opticalDrive.toUpperCase()) {

            case "CD BURNER":
                this.price += 100;
                break;

            case "DVD OptOPTICAL DRIVE":
                this.price += 230;
                break;

            case "SUPERMULTI DVD BURNER":
                this.price += 270;
                break;

            //default - keep the price  same without adding ...
        }

        return price;

    }

    @Override
    public String toString() {

        return String.format("%s  %s", super.toString(), opticalDrive);

    }
}
