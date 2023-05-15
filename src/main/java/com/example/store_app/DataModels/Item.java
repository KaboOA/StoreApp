package com.example.store_app.DataModels;


public abstract class Item {
    public static int globalId = 0;
    private String name;
    private String serialNumber;
    private int id;
    private int quantity;
    private double price;
    private String image;


    public Item(String name, int quantity, double price, String image, String serialNumber) {
        this.name = name;
        this.id = globalId;
        this.quantity = quantity;
        this.price = price;
        this.serialNumber = serialNumber;
        this.image = image;
        globalId++;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
