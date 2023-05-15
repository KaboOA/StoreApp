package com.example.store_app.DataModels;


import java.time.LocalDate;

public abstract class Food extends Item {

    private LocalDate dateOfproduction;
    private LocalDate dateOfexpiration;

    public Food(LocalDate dateOfproduction, LocalDate dateOfexpiration, String name, int quantity, double price, String image, String serialNumber) {
        super(name, quantity, price, image, serialNumber);
        this.dateOfproduction = dateOfproduction;
        this.dateOfexpiration = dateOfexpiration;
    }

    public LocalDate getDateOfproduction() {
        return dateOfproduction;
    }

    public void setDateOfproduction(LocalDate dateOfproduction) {
        this.dateOfproduction = dateOfproduction;
    }

    public LocalDate getDateOfexpiration() {
        return dateOfexpiration;
    }

    public void setDateOfexpiration(LocalDate dateOfexpiration) {
        this.dateOfexpiration = dateOfexpiration;
    }
}
