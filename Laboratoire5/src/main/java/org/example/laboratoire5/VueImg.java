package org.example.laboratoire5;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;

public class VueImg implements Observer{
    Controleur controleur;
    @FXML ImageView iv1;
    public VueImg(ImageView imageView){
        iv1=imageView;

    }

    @Override
    public void update(Subject s) {
        iv1.setImage(s.getImage());
        iv1.setScaleX( s.getCurrentScale());
        iv1.setScaleY(s.getCurrentScale());
        iv1.setTranslateX(s.getPositionX());
        iv1.setTranslateY(s.getPositionY());
    }

    @Override
    public void afficher() {

    }
}
