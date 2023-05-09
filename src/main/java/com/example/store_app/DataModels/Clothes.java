package com.example.store_app.DataModels;

import com.example.store_app.Additions.Constants;

public class Clothes extends OtherProducts implements ReturnString {
    Constants.sizes size;
    private String type;

    public Clothes(String manufacturer, int yearOfproduction, String name, int quantity, double price, String image, String type, Constants.sizes size) {
        super(manufacturer, yearOfproduction, name, quantity, price, image);
        this.type = type;
        this.size = size;
    }

    public String getType() {
        return type;
    }

    public Constants.sizes getSize() {
        return size;
    }

    @Override
    public String getString() {
        return "Name: " + getName() + "\nPrice: " + getPrice() + " EGP" + "\nQuantity: " + getQuantity() + "\nManufacturer: " + getManufacturer() + "\nYear of production: " + getYearOfproduction() + "\nMaterial: " + getType() + "\nSize: " + getSize();
    }


}
