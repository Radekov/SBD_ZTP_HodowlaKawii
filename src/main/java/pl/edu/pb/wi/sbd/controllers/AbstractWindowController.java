package pl.edu.pb.wi.sbd.controllers;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import pl.edu.pb.wi.sbd.controllers.patterns.SizeObservable;

import java.util.LinkedList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by qwerte on 2017-01-17.
 */

public abstract class AbstractWindowController implements Observer {
    List<Node> controls = new LinkedList<>();
    protected static SizeObservable sObservable = new SizeObservable();
    @FXML
    AnchorPane root_anchor;

    protected void addControls(){
        controls.addAll(root_anchor.getChildren());
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("AbstractWindowController update");
        controls.forEach(c->c.setStyle("-fx-font-size: " + String.valueOf((Integer)arg + ";")));
    }

    public static SizeObservable getsObservable() {
        return sObservable;
    }

    public void unregister(){
        controls = null;
        sObservable.deleteObserver(this);
    }
}
