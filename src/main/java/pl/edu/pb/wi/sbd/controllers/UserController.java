package pl.edu.pb.wi.sbd.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Controller;
import pl.edu.pb.wi.sbd.Context;
import pl.edu.pb.wi.sbd.SbdSwinieApplication;
import pl.edu.pb.wi.sbd.controllers.models.KawiaTable;
import pl.edu.pb.wi.sbd.database.models.Hodowla;
import pl.edu.pb.wi.sbd.database.models.Kawia;
import pl.edu.pb.wi.sbd.database.models.Rasa;
import pl.edu.pb.wi.sbd.database.repository.KawiaRepository;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Radosław Naruszewicz on 2016-12-11.
 */
public class UserController implements Initializable {

    @FXML
    Label userLabel;

    @FXML
    TableView<KawiaTable> tableCavia;
    @FXML
    TableColumn<KawiaTable, String> imieColumn;
    @FXML
    TableColumn<KawiaTable, String> nrIndywidualnyColumn;
    @FXML
    TableColumn<KawiaTable, Integer> plecColumn;

    @FXML
    TableColumn<KawiaTable, String> rasaColumn;
    @FXML
    TableColumn<KawiaTable, String> przydomekColumn;

    @FXML
    ListView<SelectList> listViewCategory;
    ObservableList observableList = FXCollections.observableArrayList();

    @FXML
    Button logoutButton;
    @FXML
    Button addNewCaviaButton;

    @FXML
    HBox toolbar_controller;


    private ConfigurableApplicationContext context = Context.getInstance();

    enum SelectList {
        ALL("wszystkie"), MIOTY("mioty"),
        CHAMPIONS("champions"), AWARDS("tytuły hodowli");
        String s;

        private SelectList(String s) {
            this.s = s;
        }

        @Override
        public String toString() {
            return s;
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        String label = Context.getLogged().write();
        imieColumn.setCellValueFactory(new PropertyValueFactory<KawiaTable, String>("imie"));
        nrIndywidualnyColumn.setCellValueFactory(new PropertyValueFactory<KawiaTable, String>("nrIndywidualny"));
        plecColumn.setCellValueFactory(new PropertyValueFactory<KawiaTable, Integer>("plec"));
        rasaColumn.setCellValueFactory(new PropertyValueFactory<KawiaTable, String>("rasa"));
        przydomekColumn.setCellValueFactory(new PropertyValueFactory<KawiaTable, String>("nazwaHodowla"));

        tableCavia.setItems(getAllCavia());

        listViewCategory.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {

        });

        userLabel.setText(Context.getLogged().write());

        listViewCategory.getItems().addAll(SelectList.ALL,SelectList.MIOTY,SelectList.CHAMPIONS,SelectList.AWARDS);
        listViewCategory.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        listViewCategory.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {

        });

    }

    public void logoutClick() {
        Context.setLogged(null);
//DUPLIKAT
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/faxml/main.fxml"));
            Stage root1 = fxmlLoader.load();
            Stage stage = SbdSwinieApplication.getWindow();
            stage = fxmlLoader.load();
            stage.setResizable(true);
            stage.centerOnScreen();
            //stage.setScene(root1);

            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addCaviaClick(){

    }

    private ObservableList<KawiaTable> getAllCavia() {
        KawiaRepository kawiaRepository = context.getBean(KawiaRepository.class);
        return AdapterKawia.adapt(kawiaRepository.findByWlasiciel(Context.getLogged().getIdLogin()));
    }
}
