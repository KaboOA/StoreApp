package com.example.store_app.Classes;

import com.example.store_app.Additions.ClassesBasics;
import com.example.store_app.Additions.DairyItemCell;
import com.example.store_app.DataModels.Dairy;
import com.example.store_app.DataModels.Item;
import javafx.collections.FXCollections;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

import static com.example.store_app.HelloApplication.dairyObservableList;
import static com.example.store_app.HelloApplication.dairyObservableList1;

public class DairyClass implements ClassesBasics {

    public TextField dairyImageTextField;
    public TextField dairyNameTextField;
    public TextField dairyPriceTextField;
    public TextField dairyQuantityTextField;
    public TextField dairyTypeTextField;
    public DatePicker dairyProdDateTextField;
    public DatePicker dairyExpDateTextField;
    public TextField dairySerialNumber;
    ListView<Dairy> dairyListView;

    public DairyClass(ListView<Dairy> listView) {
        this.dairyListView = listView;

    }

    public DairyClass(TextField dairyImageTextField, TextField dairyNameTextField, TextField dairyPriceTextField, TextField dairyQuantityTextField, TextField dairyTypeTextField, DatePicker dairyProdDateTextField, DatePicker dairyExpDateTextField, TextField dairySerialNumber) {
        this.dairyImageTextField = dairyImageTextField;
        this.dairyNameTextField = dairyNameTextField;
        this.dairyPriceTextField = dairyPriceTextField;
        this.dairyQuantityTextField = dairyQuantityTextField;
        this.dairyTypeTextField = dairyTypeTextField;
        this.dairyProdDateTextField = dairyProdDateTextField;
        this.dairyExpDateTextField = dairyExpDateTextField;
        this.dairySerialNumber = dairySerialNumber;
    }

    @Override
    public Item insertNewItem() {
        return newDairy();
    }

    @Override
    public boolean isValid() {
        return !(dairyImageTextField.getText().isEmpty() ||
                dairyImageTextField.getText().equals("Failed to get Image") ||
                dairyNameTextField.getText().isEmpty() ||
                dairyPriceTextField.getText().isEmpty() ||
                dairyQuantityTextField.getText().isEmpty() ||
                dairyTypeTextField.getText().isEmpty() ||
                dairyProdDateTextField.getValue().toString().isEmpty() ||
                dairyExpDateTextField.getValue().toString().isEmpty() ||
                dairySerialNumber.getText().isEmpty()
        );
    }

    @Override
    public void setData(ImageView detailsImageView, Text detailsText, AnchorPane backgroundId) {
        dairyListView.setItems(dairyObservableList);
        dairyListView.setCellFactory(x -> new DairyItemCell());
        dairyListView.getSelectionModel().selectedItemProperty().addListener((observableValue, clothes, t1) -> {
            backgroundId.setStyle("-fx-background-color: #cccccc");
            if (t1 == null) {
                detailsImageView.setImage(null);
                detailsText.setText("");
            } else {
                detailsImageView.setImage(new Image(t1.getImage()));
                detailsText.setText(t1.getString());
            }
        });
    }

    @Override
    public void searchItem(TextField TextField) {
        dairyObservableList1 = FXCollections.observableArrayList();

        if (TextField.getText().isEmpty()) {
            dairyListView.setItems(dairyObservableList);
            dairyObservableList1 = null;
        } else {
            for (Dairy c1 : dairyObservableList) {
                if (c1.getName().toLowerCase().contains(TextField.getText().toLowerCase()) || c1.getSerialNumber().toLowerCase().contains(TextField.getText().toLowerCase())) {
                    dairyObservableList1.add(c1);
                }
            }
            dairyListView.setItems(dairyObservableList1);
        }
    }

    @Override
    public void updateItem(Item item) {
        dairyObservableList.set(dairyObservableList.indexOf(item), newDairy());
        if (dairyObservableList1 != null) {
            dairyObservableList1.set(dairyObservableList1.indexOf(item), newDairy());
        }
    }


    Dairy newDairy() {
        return new Dairy(
                dairyTypeTextField.getText(),
                dairyProdDateTextField.getValue(),
                dairyExpDateTextField.getValue(),
                dairyNameTextField.getText(),
                Integer.parseInt(dairyQuantityTextField.getText()),
                Double.parseDouble(dairyPriceTextField.getText()),
                dairyImageTextField.getText(),
                dairySerialNumber.getText()
        );
    }
}
