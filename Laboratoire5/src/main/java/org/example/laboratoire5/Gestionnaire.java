package org.example.laboratoire5;

import java.util.ArrayList;
import java.util.List;

public final class Gestionnaire {
    private static Gestionnaire gestionnaire;
    private Perspective p;
    private List<Commande> historique=new ArrayList<Commande>();
    public static Gestionnaire getInstance(){
        if(gestionnaire==null)
        {
            gestionnaire= new Gestionnaire();
        }
        return gestionnaire;
    }

    public Perspective getPerspective()
    {
        return p;
    }

    public void execute(Commande c) {

        historique.add(c);
        c.execute();
    }
    public void undo(){
        historique.removeLast().undo();
    }

}
