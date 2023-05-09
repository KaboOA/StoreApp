package com.example.store_app.DataModels;


public abstract class Food extends Item {

    private String dateOfproduction;
    private String dateOfexpiration;

    public Food(String dateOfproduction, String dateOfexpiration, String name, int quantity, double price, String image) {
        super(name, quantity, price, image);
        this.dateOfproduction = dateOfproduction;
        this.dateOfexpiration = dateOfexpiration;
    }

    public String getDateOfproduction() {
        return dateOfproduction;
    }

    public String getDateOfexpiration() {
        return dateOfexpiration;
    }


}
