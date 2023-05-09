package com.example.store_app.DataModels;

public class FreshProduces extends Food implements ReturnString {
    Freshness freshness;
    private double wight;

    public FreshProduces(double wight, Freshness freshness, String dateOfproduction, String dateOfexpiration, String name, int quantity, double price, String image) {
        super(dateOfproduction, dateOfexpiration, name, quantity, price, image);
        this.wight = wight;
        this.freshness = freshness;
    }

    public double getWight() {
        return wight;
    }

    public Freshness getFreshness() {
        return freshness;
    }

    @Override
    public String getString() {

        return "Name: " + getName() + "\nPrice: " + getPrice() + " EGP" + "\nQuantity: " + getQuantity() + "\nDate of production: " + getDateOfproduction() + "\nDate of expiration: " + getDateOfexpiration() + "\nWight: " + getWight() + "\nFreshness: " + getFreshness();
    }

    enum Freshness {fresh, good, okay}


}
