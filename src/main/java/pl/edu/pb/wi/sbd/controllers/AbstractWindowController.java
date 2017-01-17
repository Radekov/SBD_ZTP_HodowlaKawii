package pl.edu.pb.wi.sbd.controllers;

import javafx.scene.Node;
import javafx.scene.control.Control;
import javafx.scene.control.Labeled;
import pl.edu.pb.wi.sbd.controllers.patterns.SizeObservable;

import java.util.*;

/**
 * Created by qwerte on 2017-01-17.
 */

public abstract class AbstractWindowController implements Observer {
    List<Node> controls = new LinkedList<>();
    protected static SizeObservable sObservable = new SizeObservable();

    protected abstract void addControls();

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("AbstractWindowController update");
        controls.forEach(c->c.setStyle("-fx-font-size: " + String.valueOf((Integer)arg + ";")));
    }

    public static SizeObservable getsObservable() {
        return sObservable;
    }
}
