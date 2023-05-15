package com.example.store_app.Controllers;

import com.example.store_app.Additions.Constants;
import com.example.store_app.Classes.ClothesClass;
import com.example.store_app.Classes.DairyClass;
import com.example.store_app.DataModels.Clothes;
import com.example.store_app.DataModels.Dairy;
import com.example.store_app.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import static com.example.store_app.Additions.Constants.isAdmin;


public class HelloController implements Initializable {


    public TextField clothesTextField;
    public Text detailsText;
    public TextField dairyTextField;
    public ListView<Dairy> dairyListView;
    public ClothesClass clothesClass;
    public DairyClass dairyClass;

    public ListView<Clothes> clothesListView;
    public ImageView detailsImageView;
    public AnchorPane backgroundId;

    @FXML
    void onSelectionChanged() {
        if (detailsText != null && detailsImageView != null) {
            detailsImageView.setImage(null);
            detailsText.setText("");
            backgroundId.setStyle("-fx-background-color: transparent");

            clothesListView.getSelectionModel().select(-1);
            dairyListView.getSelectionModel().select(-1);

        }
    }

    @FXML
    void addNewClothesBtnClicked() {
        if (isAdmin) {
            Constants.showCustomDialogBox(HelloApplication.class.getResource("CustomClothesDialogBox.fxml"), "Add New Clothes");
        } else {
            Constants.showWarningAlert("Only Admin Can Do This Operation");
        }
    }

    @FXML
    void addNewDairyBtnClicked() {
        if (isAdmin) {
            Constants.showCustomDialogBox(HelloApplication.class.getResource("CustomDairyDialogBox.fxml"), "Add New Dairy");
        } else {
            Constants.showWarningAlert("Only Admin Can Do This Operation");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        clothesClass = new ClothesClass(clothesListView);
        clothesClass.setData(detailsImageView, detailsText, backgroundId);
        dairyClass = new DairyClass(dairyListView);
        dairyClass.setData(detailsImageView, detailsText, backgroundId);
    }


    public void clothesKeyTapped() {
        clothesClass.searchItem(clothesTextField);
    }

    public void dairyKeyTaped() {
        dairyClass.searchItem(dairyTextField);
    }

    public void exitBtn(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("CONFIRMATION");
        alert.setHeaderText("Are You Sure To Exit?");
        Optional<ButtonType> optionalButtonType = alert.showAndWait();
        if (optionalButtonType.get() == ButtonType.OK) {
            Constants.transitionFromTo(actionEvent, "login.fxml");
        }
    }
}