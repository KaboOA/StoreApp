package com.example.store_app.Additions;

import com.example.store_app.Controllers.CustomClothesDialogBoxController;
import com.example.store_app.DataModels.Clothes;
import com.example.store_app.HelloApplication;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListCell;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import java.util.Optional;

import static com.example.store_app.Additions.Constants.addImage;
import static com.example.store_app.Additions.Constants.isAdmin;
import static com.example.store_app.HelloApplication.clothesObservableList;
import static com.example.store_app.HelloApplication.clothesObservableList1;

public class ClothesItemCell extends ListCell<Clothes> {


    @Override
    protected void updateItem(Clothes clothes, boolean b) {
        super.updateItem(clothes, b);
        if (clothes == null) {
            setGraphic(null);
        } else {
            setGraphic(itemDesign(clothes));
        }
    }

    private Node itemDesign(Clothes clothes) {
        ImageView imageView = new ImageView(clothes.getImage());
        imageView.setFitWidth(50);
        imageView.setFitHeight(50);
        Font f1 = Font.font("system", FontWeight.BOLD, 15);
        Text name = new Text(clothes.getName());
        name.setWrappingWidth(180);
        // name.setTextOverrun(OverrunStyle.ELLIPSIS);
        name.setFont(f1);
        Text price = new Text(clothes.getPrice() + " EGP");
        price.setWrappingWidth(180);
        //  price.setTextOverrun(OverrunStyle.ELLIPSIS);
        VBox vBox = new VBox(name, price);
        vBox.setAlignment(Pos.CENTER_LEFT);
        vBox.setPrefWidth(220);
        Text quantity = new Text(String.valueOf(clothes.getQuantity()));
        Button del = new Button();
        del.setGraphic(addImage("D:\\My_Works\\Store Java GUI Project\\trash-6-512.png"));
        del.setOnAction(actionEvent -> {
            if (isAdmin) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("CONFIRMATION");
                alert.setHeaderText("Are You Sure To Delete This Item?");
                Optional<ButtonType> optionalButtonType = alert.showAndWait();
                if (optionalButtonType.get() == ButtonType.OK) {
                    clothesObservableList.remove(clothes);
                    if (clothesObservableList1 != null) {
                        clothesObservableList1.remove(clothes);
                    }
                }
            } else {
                Constants.showWarningAlert("Only Admin Can Do This Operation");
            }

        });
        Button edit = new Button();
        edit.setGraphic(addImage("D:\\My_Works\\Store Java GUI Project\\39d0ca31697da0067cc6fc38e42d849d.png"));
        edit.setOnAction(actionEvent -> {
            if (isAdmin) {
                CustomClothesDialogBoxController clothesDialogBoxController = Constants.showCustomDialogBox(HelloApplication.class.getResource("CustomClothesDialogBox.fxml"), "Update Clothes").getController();
                clothesDialogBoxController.initData(clothes);
            } else {
                Constants.showWarningAlert("Only Admin Can Do This Operation");
            }

        });
        del.setStyle("-fx-text-fill: red");
        HBox hBox = new HBox(imageView, vBox, quantity, edit, del);
        hBox.setSpacing(8);
        hBox.setAlignment(Pos.CENTER_LEFT);

        return hBox;
    }


}
