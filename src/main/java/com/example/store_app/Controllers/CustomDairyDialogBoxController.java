package com.example.store_app.Controllers;

import com.example.store_app.Additions.Constants;
import com.example.store_app.Classes.DairyClass;
import com.example.store_app.DataModels.Dairy;
import com.example.store_app.HelloApplication;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class CustomDairyDialogBoxController extends Application implements Initializable {

    public TextField dairyImageTextField;
    public TextField dairyNameTextField;
    public TextField dairyPriceTextField;
    public TextField dairyQuantityTextField;
    public TextField dairyTypeTextField;
    public DatePicker dairyProdDateTextField;
    public DatePicker dairyExpDateTextField;
    public Label enterAllDataLbl;
    public TextField dairySerialNumber;
    public Button addNewDairyBtnId;
    Stage stage;
    DairyClass dairyClass;
    Dairy dairy;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        dairyClass = new DairyClass(
                dairyImageTextField,
                dairyNameTextField,
                dairyPriceTextField,
                dairyQuantityTextField,
                dairyTypeTextField,
                dairyProdDateTextField,
                dairyExpDateTextField,
                dairySerialNumber
        );
    }

    @Override
    public void start(Stage stage) {
        this.stage = stage;
    }

    public void dairyChooseImageBtnClicked() {
        dairyImageTextField.setText(Constants.ChooseImage(stage));
    }

    @FXML
    void addNewDairyBtn() {
        boolean isUnique = true;
        if (dairyClass.isValid()) {
            if (dairyPriceTextField.getText().matches("\\d*(\\.\\d*)?") && dairyQuantityTextField.getText().matches("[0-9]+")) {
                if (dairy == null) {
                    for (Dairy c : HelloApplication.dairyObservableList) {
                        if (dairySerialNumber.getText().equals(c.getSerialNumber())) {
                            enterAllDataLbl.setText("This Serial Number Already Exist");
                            dairySerialNumber.setText("");
                            isUnique = false;
                            break;
                        }
                    }
                    if (isUnique) {
                        HelloApplication.dairyObservableList.add((Dairy) dairyClass.insertNewItem());
                        Constants.dialog.close();
                    } else {
                        enterAllDataLbl.setText("Serial Number \nAlready Used");
                        dairySerialNumber.setText("");
                    }
                } else {
                    dairyClass.updateItem(dairy);
                    Constants.dialog.close();
                }
            } else {
                enterAllDataLbl.setText("Enter Right Data");
                if (!dairyPriceTextField.getText().matches("\\d*(\\.\\d*)?")) {
                    dairyPriceTextField.setText("");
                }
                if (!dairyQuantityTextField.getText().matches("[0-9]+")) {
                    dairyQuantityTextField.setText("");
                }
            }
        } else {
            enterAllDataLbl.setText("Enter Full Data");
        }
    }

    public void initData(Dairy dairy) {
        this.dairy = dairy;
        if (dairy != null) {
            dairySerialNumber.setEditable(false);
            addNewDairyBtnId.setText("Update Dairy");
            dairyImageTextField.setText(dairy.getImage());
            dairyNameTextField.setText(dairy.getName());
            dairyPriceTextField.setText(String.valueOf(dairy.getPrice()));
            dairyQuantityTextField.setText(String.valueOf(dairy.getQuantity()));
            dairyTypeTextField.setText(dairy.getType());
            dairyProdDateTextField.setValue(dairy.getDateOfproduction());
            dairyExpDateTextField.setValue(dairy.getDateOfexpiration());
            dairySerialNumber.setText(dairy.getSerialNumber());
        }
    }
}
