package org.example.laboratoire5;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;

public class Controleur {
    @FXML
    ImageView iv1;
    @FXML
    ImageView iv2;
    @FXML
    ImageView ivMini;
    Image image = new Image(getClass().getResourceAsStream("/Images/beautiful-fantasy-landscape-desktop-wallpaper-preview.png"));
    public void initialize() {
        iv1.setImage(image);
        iv2.setImage(image);
        ivMini.setImage(image);
    }
}
