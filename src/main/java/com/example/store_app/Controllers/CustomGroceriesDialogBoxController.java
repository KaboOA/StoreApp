package com.example.store_app.Controllers;

import com.example.store_app.Additions.Constants;
import javafx.application.Application;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CustomGroceriesDialogBoxController extends Application {
    public TextField groceryImageTextField;
    private Stage stage;

    public void groceryChooseImageBtnClicked() {
        groceryImageTextField.setText(Constants.ChooseImage(stage));
    }

    @Override
    public void start(Stage stage) throws Exception {
        this.stage = stage;
    }

    public void addNewGroceryBtn() {
        Constants.dialog.close();

    }
}
