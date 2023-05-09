package com.example.store_app.DataModels;


public abstract class Item {
    public static int globalId = 0;
    private String name;
    private int id;
    private int quantity;
    private double price;
    private String image;


    public Item(String name, int quantity, double price, String image) {
        this.name = name;
        this.id = globalId;
        this.quantity = quantity;
        this.price = price;
        this.image = image;
        globalId++;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public String getImage() {
        return image;
    }


}
