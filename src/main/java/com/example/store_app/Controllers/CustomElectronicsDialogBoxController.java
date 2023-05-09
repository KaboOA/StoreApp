package com.example.store_app.Controllers;

import com.example.store_app.Additions.Constants;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CustomElectronicsDialogBoxController extends Application {
    public TextField electronicsImageTextField;
    private Stage stage;

    public void electronicsChooseImageBtnClicked(ActionEvent actionEvent) {
        electronicsImageTextField.setText(Constants.ChooseImage(stage));
    }

    @Override
    public void start(Stage stage) throws Exception {
        this.stage = stage;
    }

    public void addNewElectronicsBtn() {
        Constants.dialog.close();

    }
}
