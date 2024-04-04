package org.example.laboratoire5;

import javafx.scene.image.Image;

public class Zoom implements Commande {
    private Image state;
    public void execute()
    {
        state = Gestionnaire.getInstance().getPerspective().getImage();


    }
    public void undo()
    {
        Gestionnaire.getInstance().getPerspective().setImage(state);

    }
}
