package com.example.store_app.DataModels;

public class Groceries extends Food implements ReturnString {
    String type;

    public Groceries(String type, String dateOfproduction, String dateOfexpiration, String name, int quantity, double price, String image) {
        super(dateOfproduction, dateOfexpiration, name, quantity, price, image);
        this.type = type;
    }


    public String getType() {
        return type;
    }

    @Override
    public String getString() {
        return "Name: " + getName() + "\nPrice: " + getPrice() + " EGP" + "\nQuantity: " + getQuantity() + "\nDate of production: " + getDateOfproduction() + "\nDate of expiration: " + getDateOfexpiration() + "\nType: " + getType();
    }


}
