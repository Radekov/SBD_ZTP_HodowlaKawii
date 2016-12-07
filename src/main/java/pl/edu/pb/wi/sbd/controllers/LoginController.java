package pl.edu.pb.wi.sbd.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import org.springframework.stereotype.Controller;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Radosław Naruszewicz on 2016-12-07.
 */
//Dlaczego Controller
//http://stackoverflow.com/questions/6827752/whats-the-difference-between-component-repository-service-annotations-in
@Controller
public class LoginController implements Initializable {

    @FXML Button button;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
