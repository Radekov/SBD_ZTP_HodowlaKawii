package pl.edu.pb.wi.sbd.controllers;

/**
 * Created by Radosław Naruszewicz on 2016-12-11.
 */

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import pl.edu.pb.wi.sbd.database.models.Login;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
//NIEUZYWANE
public class ToolbarController implements Initializable {

    @FXML
    private ImageView logo_hodowla;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
//        if (Context.getLogged() == null)
//            setImage(null);
//        else
//            setImage(Context.getLogged());
    }

    public void setImage(Login l) {
        if (l == null)
            logo_hodowla.setVisible(false);
        else {
            File file = new File("src/resources/images/logo_"+l.getIdLogin()+".jpg");
            Image image = new Image(file.toURI().toString());
            logo_hodowla.setVisible(true);
            logo_hodowla.setImage(image);
        }
    }
}
