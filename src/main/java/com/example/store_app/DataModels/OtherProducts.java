package com.example.store_app.DataModels;


public abstract class OtherProducts extends Item {
    private String manufacturer;
    private int yearOfproduction;

    public OtherProducts(String manufacturer, int yearOfproduction, String name, int quantity, double price, String image) {
        super(name, quantity, price, image);
        this.manufacturer = manufacturer;
        this.yearOfproduction = yearOfproduction;
    }


    public String getManufacturer() {
        return manufacturer;
    }

    public int getYearOfproduction() {
        return yearOfproduction;
    }


}
