package org.example.laboratoire5;

import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;

public class Translation implements Commande{

    Perspective perspective;
    double orgSceneX;
    double orgSceneY;
    double offsetX;
    double offsetY;
    double offsetXo;
    double offsetYo;
    double orgTranslationX;
    double orgTranslationY;

    public Translation(MouseEvent event,double orgSceneX,double orgSceneY, Perspective perspective)
    {
        this.orgSceneX =orgSceneX;
        this.orgSceneY=orgSceneY;
        offsetX = event.getSceneX();
        offsetY = event.getSceneY();
        this.perspective=perspective;
    }
    public void execute()
    {
        offsetXo= perspective.getPositionX();
        offsetYo= perspective.getPositionY();
        perspective.setPositionX(offsetX+offsetXo-orgSceneX);
        perspective.setPositionY(offsetY+offsetYo-orgSceneY);

    }
    public void undo()
    {
        perspective.setPositionX(offsetXo);
        perspective.setPositionY(offsetYo);
    }
}
