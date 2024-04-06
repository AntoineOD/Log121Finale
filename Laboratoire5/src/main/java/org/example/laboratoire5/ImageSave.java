package org.example.laboratoire5;

import java.util.ArrayList;
import java.util.List;

public class ImageSave implements Subject {
    ImageSave image;
    List<Observer> observerList= new ArrayList<Observer>();

    public ImageSave getImage() {
        return image;
    }

    public void setImage(ImageSave image) {
        this.image = image;
    }

    public void addObserver(Observer o)
    {
        observerList.add(o);
    }
    public void removeObserver(Observer o)
    {
        observerList.add(o);
    }
    public void notifyObservers()
    {
        for(Observer o :observerList)
        {
            o.update(this);
        }
    }

}
