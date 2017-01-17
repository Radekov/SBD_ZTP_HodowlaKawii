package pl.edu.pb.wi.sbd.controllers;

import javafx.scene.control.Labeled;
import pl.edu.pb.wi.sbd.controllers.patterns.InterfaceChangeSize;

import java.util.List;

/**
 * Created by qwerte on 2017-01-17.
 */

public abstract class AbstractWindowController implements InterfaceChangeSize {
    List<Labeled> controls;

    @Override
    public void changeSize(Integer size) {
        controls.forEach(c->c.setStyle("-fx-font-size: " + String.valueOf(size) + ";"));
    }
}
