package com.example.store_app.DataModels;


public abstract class OtherProducts extends Item {
    private String Supplier;
    private int yearOfproduction;

    public OtherProducts(String Supplier, int yearOfproduction, String name, int quantity, double price, String image, String serialNumber) {
        super(name, quantity, price, image, serialNumber);
        this.Supplier = Supplier;
        this.yearOfproduction = yearOfproduction;
    }


    public String getSupplier() {
        return Supplier;
    }

    public void setSupplier(String supplier) {
        this.Supplier = supplier;
    }

    public int getYearOfproduction() {
        return yearOfproduction;
    }

    public void setYearOfproduction(int yearOfproduction) {
        this.yearOfproduction = yearOfproduction;
    }
}
