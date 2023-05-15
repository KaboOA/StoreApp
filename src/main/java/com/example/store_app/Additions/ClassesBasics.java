package com.example.store_app.Additions;

import com.example.store_app.DataModels.Item;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

public interface ClassesBasics {

    Item insertNewItem();

    boolean isValid();

    void setData(ImageView detailsImageView, Text detailsText, AnchorPane backgroundId);

    void searchItem(TextField TextField);

    void updateItem(Item item);
}
