package com.example.store_app.DataModels;


public class Snacks extends Food implements ReturnString {
    private boolean isPreservated;

    public Snacks(boolean isPreservated, String dateOfproduction, String dateOfexpiration, String name, int quantity, double price, String image) {
        super(dateOfproduction, dateOfexpiration, name, quantity, price, image);
        this.isPreservated = isPreservated;
    }


    public boolean isIsPreservated() {
        return isPreservated;
    }

    @Override
    public String getString() {
        return "name: " + getName() + "\nprice: " + getPrice() + " EGP" + "\nquantity: " + getQuantity() + "\nDate of production: " + getDateOfproduction() + "\nDate of expiration: " + getDateOfexpiration() + "\nIs the product preservated? : " + isIsPreservated();
    }


}
