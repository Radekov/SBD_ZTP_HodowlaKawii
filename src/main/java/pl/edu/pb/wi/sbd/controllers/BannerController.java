package pl.edu.pb.wi.sbd.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Radosław Naruszewicz on 2017-01-04.
 */
public class BannerController implements Initializable {

    @FXML
    ImageView logoImageHodowla;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void setVisibleLogoImageHodowla(boolean visible){
        logoImageHodowla.setVisible(visible);
    }
}
