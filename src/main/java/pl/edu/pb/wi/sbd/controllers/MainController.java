package pl.edu.pb.wi.sbd.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import pl.edu.pb.wi.sbd.SbdSwinieApplication;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Radosław Naruszewicz on 2017-01-05.
 */
public class MainController extends AbstractController {

    @FXML
    private Button button_logout;

    @FXML
    private Button button_list_cavies;

    @FXML
    private Label label_kind;

    @FXML
    private Label label_name_user;

    @FXML
    private Label label_status;

    @FXML
    void logoutActionClick(ActionEvent event) {

    }

    @FXML
    void actionOpenListCavies(ActionEvent event) {
        openWindow("/fxml/add_new_cavia.fxml");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    private void openWindow(String path){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(path));
        Parent root1 = null;
        try {
            System.out.println(fxmlLoader);
            root1 = (Parent) fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage stage = new Stage();
//        stage.initModality(Modality.APPLICATION_MODAL);
//        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(new Scene(root1));
        stage.setResizable(true);
        stage.centerOnScreen();
        stage.show();
    }
}
