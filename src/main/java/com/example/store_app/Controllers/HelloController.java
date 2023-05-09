package com.example.store_app.Controllers;

import com.example.store_app.Additions.Constants;
import com.example.store_app.Additions.ItemCell;
import com.example.store_app.DataModels.Clothes;
import com.example.store_app.HelloApplication;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;


public class HelloController implements Initializable {

    public static ObservableList<Clothes> clothesObservableList;
    public static ObservableList<Clothes> clothesObservableList1;
    public TextField clothesTextField;
    @FXML
    ListView<Clothes> clothesListView;
    @FXML
    ImageView detailsImageView;
    @FXML
    Text detailsText;

    @FXML
    AnchorPane backgroundId;

    @FXML
    void onSelectionChanged() {
        if (detailsText != null && detailsImageView != null) {
            detailsImageView.setImage(null);
            detailsText.setText("");
            backgroundId.setStyle("-fx-background-color: transparent");

            clothesListView.getSelectionModel().select(-1);
        }
    }

    @FXML
    void addNewClothesBtnClicked() {
        Constants.showCustomDialogBox(HelloApplication.class.getResource("CustomClothesDialogBox.fxml"), "Add New Clothes");
    }

    @FXML
    void addNewDairyBtnClicked() {
        Constants.showCustomDialogBox(HelloApplication.class.getResource("CustomDairyDialogBox.fxml"), "Add New Dairy");
    }

    @FXML
    void addNewSnacksBtnClicked() {
        Constants.showCustomDialogBox(HelloApplication.class.getResource("CustomSnacksDialogBox.fxml"), "Add New Snacks");
    }

    @FXML
    void addNewElectronicsBtnClicked() {
        Constants.showCustomDialogBox(HelloApplication.class.getResource("CustomElectronicsDialogBox.fxml"), "Add New Electronics");
    }

    @FXML
    void addNewGroceriesBtnClicked() {
        Constants.showCustomDialogBox(HelloApplication.class.getResource("CustomGroceriesDialogBox.fxml"), "Add New Groceries");
    }

    @FXML
    void addNewFreshProducesBtnClicked() {
        Constants.showCustomDialogBox(HelloApplication.class.getResource("CustomFreshProducesDialogBox.fxml"), "Add New Fresh Produces");
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        clothesObservableList = FXCollections.observableArrayList();
        clothesListView.setItems(clothesObservableList);
        clothesListView.setCellFactory(userListView -> new ItemCell());
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

    public void clothesSearchBtn() {
        clothesObservableList1 = FXCollections.observableArrayList();
        if (clothesTextField.getText().isEmpty()) {
            clothesListView.setItems(clothesObservableList);
        } else {
            for (Clothes c1 : clothesObservableList) {
                if (c1.getName().toLowerCase().contains(clothesTextField.getText().toLowerCase())) {
                    clothesObservableList1.add(c1);
                }
            }
            clothesListView.setItems(clothesObservableList1);
        }

    }


}