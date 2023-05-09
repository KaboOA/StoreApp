package com.example.store_app.Controllers;

import com.example.store_app.Additions.Constants;
import com.example.store_app.DataModels.Clothes;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.control.DialogPane;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CustomClothesDialogBoxController extends Application {
    public DialogPane clothesDialogPane;
    public TextField clothesNameTextField;
    public TextField clothesManifacturerTextField;
    public TextField clothesTypeTextField;
    public TextField clothesQuantityTextField;
    public TextField clothesPriceTextField;
    public TextField clothesYOPTextField;
    @FXML
    TextField clothesImageTextField;
    private Stage stage;

    @Override
    public void start(Stage stage) {
        this.stage = stage;
    }

    @FXML
    void clothesChooseImageBtnClicked() {
        clothesImageTextField.setText(Constants.ChooseImage(stage));
    }

    public void addNewClothesBtn() {
        HelloController.clothesObservableList.add(new Clothes(clothesManifacturerTextField.getText(),
                Integer.parseInt(clothesYOPTextField.getText()), clothesNameTextField.getText(),
                Integer.parseInt(clothesQuantityTextField.getText()),
                Double.parseDouble(clothesPriceTextField.getText()),
                clothesImageTextField.getText(),
                clothesTypeTextField.getText(),
                Constants.sizes.XL));
        Constants.dialog.close();
    }
}
