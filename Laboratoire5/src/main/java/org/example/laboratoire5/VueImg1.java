package org.example.laboratoire5;

import javafx.fxml.FXML;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;

public class VueImg1 implements Observer{
    Controleur controleur;
    @FXML ImageView iv1;
    public VueImg1(ImageView imageView){
        iv1=imageView;
        System.out.println(iv1.getScaleX());
    }

    @Override
    public void update(Subject s) {
        iv1.setImage(s.getImage());
        iv1.setScaleX( s.getCurrentScale());
        iv1.setScaleY(s.getCurrentScale());
        System.out.println(iv1.getScaleX());
    }

    @Override
    public void afficher() {

    }
}
