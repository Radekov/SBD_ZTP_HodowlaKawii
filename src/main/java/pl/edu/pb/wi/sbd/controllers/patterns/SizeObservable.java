package pl.edu.pb.wi.sbd.controllers.patterns;

import java.util.Observable;

/**
 * Created by qwerte on 2017-01-17.
 */
public class SizeObservable extends Observable {
    Integer size;

    public SizeObservable() {
        this.size = 10;
    }

    public void update(){
        notifyObservers(size);
    }

    public void update(boolean a) {
        System.out.println("SizeObservable update "+a);
        if (a && size < 64) {
            setChanged();
            notifyObservers(++size);
        } else if (size > 10) {
            setChanged();
            notifyObservers(--size);
        }
    }


}
