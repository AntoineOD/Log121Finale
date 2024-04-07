package org.example.laboratoire5;

import javafx.fxml.FXML;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;

public class Controleur{
    @FXML
    ImageView iv1;
    @FXML
    ImageView iv2;
    @FXML
    ImageView ivMini;
    @FXML
    ScrollPane paneI1;
    @FXML
    ScrollPane paneI2;
    Rectangle rec1;
    Rectangle rec2;
    Image image = new Image(getClass().getResourceAsStream("/Images/beautiful-fantasy-landscape-desktop-wallpaper-preview.png"));
    private double orgSceneX, orgSceneY;
    private double orgTranslateX, orgTranslateY;
    private double minScale = 0.5;
    private double maxScale = 2.0;

    public void initialize() {

        iv1.setImage(image);
        iv2.setImage(image);
        ivMini.setImage(image);


        iv1.setOnScroll(event -> handleScroll(event, iv1));
        iv2.setOnScroll(event -> handleScroll(event, iv2));

        iv1.setOnMousePressed(this::handleMousePressed);
        iv1.setOnMouseDragged(this::handleMouseDragged);
        iv2.setOnMousePressed(this::handleMousePressed);
        iv2.setOnMouseDragged(this::handleMouseDragged);
    }

    private void handleScroll(ScrollEvent event, ImageView iv) {
        double deltaY = event.getDeltaY();
        double scaleFactor = (deltaY > 0) ? 1.05 : 1 / 1.05;

        double scale = iv.getScaleX() * scaleFactor;
        if (scale < minScale || scale > maxScale)
            return;

        iv.setScaleX(scale);
        iv.setScaleY(scale);

        ((Rectangle) iv.getClip()).setWidth(iv.getBoundsInParent().getWidth() / scale);
        ((Rectangle) iv.getClip()).setHeight(iv.getBoundsInParent().getHeight() / scale);

        event.consume();
    }

    private void handleMousePressed(MouseEvent event) {
        orgSceneX = event.getSceneX();
        orgSceneY = event.getSceneY();
        orgTranslateX = ((ImageView) (event.getSource())).getTranslateX();
        orgTranslateY = ((ImageView) (event.getSource())).getTranslateY();
    }

    private void handleMouseDragged(MouseEvent event) {
        double offsetX = event.getSceneX() - orgSceneX;
        double offsetY = event.getSceneY() - orgSceneY;
        double newTranslateX = orgTranslateX + offsetX;
        double newTranslateY = orgTranslateY + offsetY;

        ((ImageView) (event.getSource())).setTranslateX(newTranslateX);
        ((ImageView) (event.getSource())).setTranslateY(newTranslateY);
    }
    public
    ImageSave imageSave;

    public Controleur()
    {
        imageSave = new ImageSave();
    }

    public void importer()
    {

    }

    public void sauvegarder(){

    }
    public void zoom()
    {
        Zoom z= new Zoom();
        Gestionnaire.getInstance().execute(z);

    }
    public void translation()
    {
        Commande c= new Translation();
        Gestionnaire.getInstance().execute(c);
    }
    public void undo()
    {
        Gestionnaire.getInstance().undo();
    }
}
