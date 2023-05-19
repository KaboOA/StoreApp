package com.example.store_app.Controllers;

import com.example.store_app.Additions.Constants;
import com.example.store_app.Classes.ClothesClass;
import com.example.store_app.DataModels.Clothes;
import com.example.store_app.HelloApplication;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class CustomClothesDialogBoxController extends Application implements Initializable {
    public TextField clothesNameTextField;
    public TextField clothesManifacturerTextField;
    public TextField clothesTypeTextField;
    public TextField clothesQuantityTextField;
    public TextField clothesPriceTextField;
    public TextField clothesYOPTextField;
    public CheckBox sCheckboxId;
    public CheckBox mCheckboxId;
    public CheckBox lCheckboxId;
    public CheckBox xlCheckboxId;
    public Label enterDataLblId;
    public TextField clothesImageTextField;
    public TextField clothesTextField;
    public TextField clothesSerialNumber;
    @FXML
    Button addNewClotheBtn;
    Clothes clothes;
    ClothesClass clothesClass;
    private Stage stage;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        clothesClass = new ClothesClass(
                clothesNameTextField,
                clothesManifacturerTextField,
                clothesTypeTextField,
                clothesQuantityTextField,
                clothesPriceTextField,
                clothesYOPTextField,
                sCheckboxId,
                mCheckboxId,
                lCheckboxId,
                xlCheckboxId,
                clothesImageTextField,
                clothesSerialNumber
        );

    }

    @Override
    public void start(Stage stage) {
        this.stage = stage;

    }

    @FXML
    void clothesChooseImageBtnClicked() {
        clothesImageTextField.setText(Constants.ChooseImage(stage));
    }

    public void addNewClothesBtn() {
        boolean isUnique = true;
        if (clothesClass.isValid()) {
            if (clothesPriceTextField.getText().matches("\\d*(\\.\\d*)?") && clothesQuantityTextField.getText().matches("[0-9]+") && clothesYOPTextField.getText().matches("[0-9]+")) {
                if (clothes == null) {
                    for (Clothes c : HelloApplication.clothesObservableList) {
                        if (clothesSerialNumber.getText().equals(c.getSerialNumber())) {
                            enterDataLblId.setText("This Serial Number Already Exist");
                            clothesSerialNumber.setText("");
                            isUnique = false;
                            break;
                        }
                    }
                    if (isUnique) {
                        HelloApplication.clothesObservableList.add((Clothes) clothesClass.insertNewItem());
                        Constants.dialog.close();
                    } else {
                        enterDataLblId.setText("Serial Number \nAlready Used");
                        clothesSerialNumber.setText("");
                    }
                } else {
                    clothesClass.updateItem(clothes);
                    Constants.dialog.close();
                }
            } else {
                enterDataLblId.setText("Enter Right Data");

                if (!clothesPriceTextField.getText().matches("\\d*(\\.\\d*)?")) {
                    clothesPriceTextField.setText("");
                }
                if (!clothesQuantityTextField.getText().matches("[0-9]+")) {
                    clothesQuantityTextField.setText("");
                }
                if (!clothesYOPTextField.getText().matches("[0-9]+")) {
                    clothesYOPTextField.setText("");
                }
            }
        } else {
            enterDataLblId.setText("Enter Full Data");
        }
    }

    public void initData(Clothes clothes) {
        this.clothes = clothes;
        if (clothes != null) {
            clothesSerialNumber.setEditable(false);
            addNewClotheBtn.setText("Update Clothes");
            clothesNameTextField.setText(clothes.getName());
            clothesSerialNumber.setText(clothes.getSerialNumber());
            clothesPriceTextField.setText(String.valueOf(clothes.getPrice()));
            clothesYOPTextField.setText(String.valueOf(clothes.getYearOfproduction()));
            clothesQuantityTextField.setText(String.valueOf(clothes.getQuantity()));
            clothesImageTextField.setText(clothes.getImage());
            clothesManifacturerTextField.setText(clothes.getSupplier());
            clothesTypeTextField.setText(clothes.getType());
            for (int i = 0; i < clothes.getSize().size(); i++) {
                switch (clothes.getSize().get(i)) {
                    case XL -> xlCheckboxId.setSelected(clothes.getSize().get(i).equals(Constants.Sizes.XL));
                    case L -> lCheckboxId.setSelected(clothes.getSize().get(i).equals(Constants.Sizes.L));
                    case M -> mCheckboxId.setSelected(clothes.getSize().get(i).equals(Constants.Sizes.M));
                    case S -> sCheckboxId.setSelected(clothes.getSize().get(i).equals(Constants.Sizes.S));
                }
            }
        }
    }
}
