package com.example.store_app.Controllers;

import com.example.store_app.Additions.Constants;
import javafx.application.Application;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CustomSnacksDialogBoxController extends Application {
    public TextField snacksImageTextField;
    private Stage stage;

    public void snacksChooseImageBtnClicked() {

        snacksImageTextField.setText(Constants.ChooseImage(stage));
    }

    @Override
    public void start(Stage stage) throws Exception {
        this.stage = stage;
    }

    public void addNewSnacksBtn() {
        Constants.dialog.close();
    }
}
