package com.example.store_app.Controllers;

import com.example.store_app.Additions.Constants;
import javafx.application.Application;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CustomFreshProducesDialogBoxController extends Application {
    public TextField freshProducesImageTextField;
    private Stage stage;

    public void freshProducesChooseImageBtnClicked() {
        freshProducesImageTextField.setText(Constants.ChooseImage(stage));
    }

    @Override
    public void start(Stage stage) {
        this.stage = stage;
    }

    public void addNewFreshProducesBtn() {
        Constants.dialog.close();

    }
}
