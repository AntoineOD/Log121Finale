package org.example.laboratoire5;

import javafx.fxml.FXML;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;

import java.io.Serializable;

public class VueImg1 implements Observer, Serializable {
    transient Controleur controleur;
    @FXML transient ImageView iv1;

    public VueImg1(ImageView imageView) {
        this.iv1 = imageView;
    }

    @Override
    public void update(Subject s) {
        if (iv1 != null) {
            iv1.setImage(s.getImage());
            iv1.setScaleX(s.getCurrentScale());
            iv1.setScaleY(s.getCurrentScale());
            iv1.setTranslateX(s.getPositionX());
            iv1.setTranslateY(s.getPositionY());
        }
    }
}
