package org.example.laboratoire5;

public class Controleur {
    Image image;
    Perspective perspective;

    public Controleur()
    {
        perspective=new Perspective();

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
