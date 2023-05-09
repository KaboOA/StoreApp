package com.example.store_app.Controllers;

import com.example.store_app.Additions.Constants;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CustomDairyDialogBoxController extends Application {

    public TextField dairyImageTextField;
    Stage stage;
    @FXML
    TextField dairyTextField;

    @Override
    public void start(Stage stage) {
        this.stage = stage;
    }

    public void dairyChooseImageBtnClicked() {
        dairyImageTextField.setText(Constants.ChooseImage(stage));
    }

    @FXML
    void addNewDairyBtn() {
        Constants.dialog.close();
    }
}
