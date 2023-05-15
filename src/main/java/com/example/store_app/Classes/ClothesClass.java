package com.example.store_app.Classes;

import com.example.store_app.Additions.ClassesBasics;
import com.example.store_app.Additions.ClothesItemCell;
import com.example.store_app.Additions.Constants;
import com.example.store_app.DataModels.Clothes;
import com.example.store_app.DataModels.Item;
import javafx.collections.FXCollections;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

import java.util.ArrayList;

import static com.example.store_app.HelloApplication.clothesObservableList;
import static com.example.store_app.HelloApplication.clothesObservableList1;

public class ClothesClass implements ClassesBasics {


    TextField clothesNameTextField;
    ListView<Clothes> clothesListView;
    TextField clothesManifacturerTextField;
    TextField clothesTypeTextField;
    TextField clothesQuantityTextField;
    TextField clothesPriceTextField;
    TextField clothesYOPTextField;
    CheckBox sCheckboxId;
    TextField clothesSerialNumber;
    CheckBox mCheckboxId;
    CheckBox lCheckboxId;
    CheckBox xlCheckboxId;
    TextField clothesImageTextField;

    public ClothesClass(ListView<Clothes> clothesListView) {
        this.clothesListView = clothesListView;
    }

    public ClothesClass(TextField clothesNameTextField, TextField clothesManifacturerTextField, TextField clothesTypeTextField, TextField clothesQuantityTextField, TextField clothesPriceTextField, TextField clothesYOPTextField, CheckBox sCheckboxId, CheckBox mCheckboxId, CheckBox lCheckboxId, CheckBox xlCheckboxId, TextField clothesImageTextField, TextField clothesSerialNumber) {
        this.clothesNameTextField = clothesNameTextField;
        this.clothesManifacturerTextField = clothesManifacturerTextField;
        this.clothesTypeTextField = clothesTypeTextField;
        this.clothesQuantityTextField = clothesQuantityTextField;
        this.clothesPriceTextField = clothesPriceTextField;
        this.clothesYOPTextField = clothesYOPTextField;
        this.clothesImageTextField = clothesImageTextField;
        this.sCheckboxId = sCheckboxId;
        this.mCheckboxId = mCheckboxId;
        this.lCheckboxId = lCheckboxId;
        this.xlCheckboxId = xlCheckboxId;
        this.clothesSerialNumber = clothesSerialNumber;
    }

    @Override
    public void setData(ImageView detailsImageView, Text detailsText, AnchorPane backgroundId) {
        clothesListView.setItems(clothesObservableList);
        clothesListView.setCellFactory(x -> new ClothesItemCell());

        clothesListView.getSelectionModel().selectedItemProperty().addListener((observableValue, clothes, t1) -> {
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
    public void searchItem(TextField clothesTextField) {

        clothesObservableList1 = FXCollections.observableArrayList();
        if (clothesTextField.getText().isEmpty()) {
            clothesListView.setItems(clothesObservableList);
            clothesObservableList1 = null;
        } else {
            for (Clothes c1 : clothesObservableList) {
                if (c1.getName().toLowerCase().contains(clothesTextField.getText().toLowerCase()) || c1.getSerialNumber().toLowerCase().contains(clothesTextField.getText().toLowerCase())) {
                    clothesObservableList1.add(c1);
                }
            }
            clothesListView.setItems(clothesObservableList1);
        }
    }

    @Override
    public Item insertNewItem() {
        return newClothes();
    }

    @Override
    public boolean isValid() {
        return !(clothesNameTextField.getText().isEmpty() ||
                clothesImageTextField.getText().equals("Failed to get Image") ||
                clothesManifacturerTextField.getText().isEmpty() ||
                clothesPriceTextField.getText().isEmpty() ||
                clothesQuantityTextField.getText().isEmpty() ||
                clothesTypeTextField.getText().isEmpty() ||
                clothesSerialNumber.getText().isEmpty() ||
                clothesYOPTextField.getText().isEmpty() ||
                (!xlCheckboxId.isSelected() && !lCheckboxId.isSelected() && !mCheckboxId.isSelected() && !sCheckboxId.isSelected())
        );
    }

    @Override
    public void updateItem(Item item) {
        clothesObservableList.set(clothesObservableList.indexOf(item), newClothes());
        if (clothesObservableList1 != null) {
            clothesObservableList1.set(clothesObservableList1.indexOf(item), newClothes());
        }

    }

    ArrayList<Constants.Sizes> putSizes() {
        ArrayList<Constants.Sizes> sizes = new ArrayList<>();

        if (xlCheckboxId.isSelected()) {
            sizes.add(Constants.Sizes.XL);
        }
        if (lCheckboxId.isSelected()) {
            sizes.add(Constants.Sizes.L);
        }
        if (mCheckboxId.isSelected()) {
            sizes.add(Constants.Sizes.M);
        }
        if (sCheckboxId.isSelected()) {
            sizes.add(Constants.Sizes.S);
        }
        return sizes;
    }

    Clothes newClothes() {
        return new Clothes(
                clothesManifacturerTextField.getText(),
                Integer.parseInt(clothesYOPTextField.getText()),
                clothesNameTextField.getText(),
                Integer.parseInt(clothesQuantityTextField.getText()),
                Double.parseDouble(clothesPriceTextField.getText()),
                clothesImageTextField.getText(),
                clothesTypeTextField.getText(),
                putSizes(),
                clothesSerialNumber.getText()
        );
    }


}
