package com.example.store_app.DataModels;

import com.example.store_app.Additions.Constants;

import java.util.ArrayList;

public class Clothes extends OtherProducts implements ReturnString {
    private ArrayList<Constants.Sizes> sizes;
    private String type;

    public Clothes(String Supplier, int yearOfproduction, String name, int quantity, double price, String image, String type, ArrayList<Constants.Sizes> sizes, String serialNumber) {
        super(Supplier, yearOfproduction, name, quantity, price, image, serialNumber);
        this.type = type;
        this.sizes = sizes;
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ArrayList<Constants.Sizes> getSize() {
        return sizes;
    }

    @Override
    public String getString() {
        return "Name: " + getName() + "\nSerial Number: " + getSerialNumber() + "\nPrice: " + getPrice() + " EGP" + "\nQuantity: " + getQuantity() + "\nSupplier: " + getSupplier() + "\nYear of production: " + getYearOfproduction() + "\nType: " + getType() + "\nSizes: " + getSize();
    }

    public void setSizes(ArrayList<Constants.Sizes> sizes) {
        this.sizes = sizes;
    }
}
