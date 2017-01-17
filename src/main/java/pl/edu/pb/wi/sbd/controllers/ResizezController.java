package pl.edu.pb.wi.sbd.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by qwerte on 2017-01-17.
 */
public class ResizezController implements Initializable{

    @FXML
    Button font_plus;

    @FXML
    Button font_minus;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        font_plus.setOnAction(e->AbstractWindowController.getsObservable().update(true));
        font_minus.setOnAction(e->AbstractWindowController.getsObservable().update(false));
    }
}
