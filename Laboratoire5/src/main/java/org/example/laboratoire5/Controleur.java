package org.example.laboratoire5;

public class Controleur {
    ImageSave image;

    public Controleur()
    {
        image = new ImageSave();
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
