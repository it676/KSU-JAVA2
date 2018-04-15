package com.electronic.store;


import java.io.Serializable;

/**
 *
 * @author IT676
 */
public abstract class TechnicalDevice implements Item, Serializable {

    protected String itemID;
    protected double displaySize;
    protected String processorType;
    protected int RAM;
    protected String color;
    protected double price;
    protected String brand;
    protected int quantity;

    public TechnicalDevice(String ID, double size, String pType, int ram, String color, String b, double p, int q) {

        itemID = ID;
        displaySize = size;
        processorType = pType;
        RAM = ram;
        this.color = color;
        price = p;
        brand = b;
        quantity = q;
    }

    public boolean isAvaiable() {

        return quantity > 0;
    }

    public void add(int q) {

        quantity += q;
    }

    public boolean remove(int q) {

        if (q <= quantity) {
            quantity -= q;
            return true;
        }

        //the required quantity not avaiable
        return false;
    }

    @Override
    public int getQuantity() {

        return quantity;
    }

    public String getBrand() {
        return brand;
    }

    @Override
    public String toString() {

        return String.format("%s   %.2f  %s  %d   %s  %.2f   %s   %d",
                itemID, displaySize, processorType,
                RAM, color, price, brand, quantity);
    }

}
