package com.electronic.store;



/**
 *
 * @author IT676
 */
public class Laptop extends TechnicalDevice {

    private boolean touchDisplay;
    private boolean cardReader;
    private static final long serialVersionUID = 752238799930947774L;

    public Laptop(String ID, double size, String pType,
            int ram, String color, String b, double p,
            int q, boolean c, boolean t) {

        super(ID, size, pType, ram, color, b, p, q);

        touchDisplay = t;
        cardReader = c;

    }

    @Override
    public double getPrice() {
        if (cardReader) {
            price += 100;
        }
        if (touchDisplay) {
            price += 380;
        }

        return price;

    }

    @Override
    public String toString() {

        return String.format("%s  %s  %s", super.toString(), touchDisplay, cardReader);

    }

}
