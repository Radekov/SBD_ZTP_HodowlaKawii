package pl.edu.pb.wi.sbd.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

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
    private Button admin_table_users;

    @FXML
    private Button adminAddPerson;

    @FXML
    private Button adminAddUser;


    @FXML
    private Label label_kind;

    @FXML
    private Label label_name_user;

    @FXML
    private Label label_status;

    @FXML
    void logoutActionClick(ActionEvent event) {
        CONTEXT.setLogged(null);
        openScene(event,"/fxml/login.fxml");
    }

    @FXML
    void actionOpenListCavies(ActionEvent event) {
        openScene(event, "/fxml/cavia_list.fxml");
    }

    @FXML
    void actionOpenWeight(ActionEvent event) {
        openWindow("/fxml/weight.fxml");
    }

    @FXML
    void actionOpenAddLitter(ActionEvent event) {
        openWindow("/fxml/litter.fxml");
    }

    @FXML
    void actionOpenLineage(ActionEvent event) {
        openWindow("/fxml/Lineage.fxml");
    }

    @FXML
    void actionOpenAddPerson(ActionEvent event) {
        openWindow("/fxml/addPerson.fxml");
    }

    @FXML
    void actionOpenAddBreeding(ActionEvent event) {
        openWindow("/fxml/AddUser.fxml");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        admin_table_users.setOnAction(e->{
            openWindow("/fxml/user_list.fxml");
        });
    }

    @Override
    protected void initData(FXMLLoader fxmlLoader) {

    }
}
