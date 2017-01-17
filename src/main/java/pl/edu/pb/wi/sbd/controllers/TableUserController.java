package pl.edu.pb.wi.sbd.controllers;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import pl.edu.pb.wi.sbd.Context;
import pl.edu.pb.wi.sbd.controllers.models.Model;
import pl.edu.pb.wi.sbd.database.repository.LoginRepository;
import pl.edu.pb.wi.sbd.database.repository.OsobaRepository;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Created by Radosław Naruszewicz on 2017-01-16.
 */
public class TableUserController extends AbstractWindowController implements Initializable {

    @FXML
    private TableColumn<Model, String> column_adress;

    @FXML
    private TableColumn<Model, String> column_fname;

    @FXML
    private TableColumn<Model, String> column_phone;

    @FXML
    private TableColumn<Model, String> column_street;

    @FXML
    private TableColumn<Model, String> column_sname;

    @FXML
    private TableView<Model> table_user;

    @FXML
    private TableColumn<Model, String> column_kind;

    @FXML
    private TableColumn<Model, Integer> column_lp;

    @FXML
    private TableColumn<Model, String> column_status;

    @FXML
    private Button button_back;

    @FXML
    private Button button_remove_user;

    @FXML
    private TableColumn<Model, String> column_login;

    @FXML
    void actionBack(ActionEvent event) {
        unregister();
        ((Stage)button_back.getScene().getWindow()).close();
    }

    @FXML
    void actionDeleteUser(ActionEvent event) {
        Model m = table_user.getSelectionModel().getSelectedItem();
        if(m.getId() == Context.CONTEXT.getLogged().getIdLogin()) return;
        loginRepository.delete(m.getId());
        table_user.getItems().remove(m);
    }

    OsobaRepository osobaRepository = Context.getInstance().getBean(OsobaRepository.class);
    LoginRepository loginRepository = Context.getInstance().getBean(LoginRepository.class);

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        sObservable.addObserver(this);
        addControls();
        List<Model> dataModel = new ArrayList<>();
        loginRepository.findAll().forEach(l -> dataModel.add(new Model(l)));
        ObservableList<Model> data = FXCollections.observableArrayList();
        data.addAll(dataModel);

        column_lp.setCellValueFactory(new PropertyValueFactory<>("id"));
        column_login.setCellValueFactory(new PropertyValueFactory<>("login"));
        column_kind.setCellValueFactory(new PropertyValueFactory<>("kind"));//?
        column_status.setCellValueFactory(e -> new SimpleStringProperty(e.getValue().getStatus().toString()));
        column_fname.setCellValueFactory(new PropertyValueFactory<>("fname"));
        column_sname.setCellValueFactory(new PropertyValueFactory<>("lname"));
        column_phone.setCellValueFactory(new PropertyValueFactory<>("phone"));
        column_adress.setCellValueFactory(new PropertyValueFactory<>("adress"));
        column_street.setCellValueFactory(new PropertyValueFactory<>("street"));
        table_user.setItems(data);
    }


}
