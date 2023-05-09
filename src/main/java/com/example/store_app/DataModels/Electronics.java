package com.example.store_app.DataModels;


public class Electronics extends OtherProducts implements ReturnString {
    private String type;

    public Electronics(String manufacturer, int yearOfproduction, String name, int quantity, double price, String image, String type) {
        super(manufacturer, yearOfproduction, name, quantity, price, image);
        this.type = type;
    }

    public String getType() {
        return type;
    }

    @Override
    public String getString() {
        return "name: " + getName() + "\nPrice: " + getPrice() + " EGP" + "\nQuantity: " + getQuantity() + "\nManufacturer: " + getManufacturer() + "\nYear of production: " + getYearOfproduction() + "\nType: " + getType();
    }


}
