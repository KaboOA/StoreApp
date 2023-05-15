package com.example.store_app.DataModels;

import java.time.LocalDate;

public class Dairy extends Food implements ReturnString {
    private String type;

    public Dairy(String type, LocalDate dateOfproduction, LocalDate dateOfexpiration, String name, int quantity, double price, String image, String serialNumber) {
        super(dateOfproduction, dateOfexpiration, name, quantity, price, image, serialNumber);
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String getString() {
        return "Name: " + getName() + "\nSerial Number: " + getSerialNumber() + "\nPrice: " + getPrice() + " EGP" + "\nQuantity: " + getQuantity() + "\nDate of production: " + getDateOfproduction().toString() + "\nDate of expiration: " + getDateOfexpiration().toString() + "\nType: " + getType();
    }
}
