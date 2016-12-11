package pl.edu.pb.wi.sbd.controllers;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Controller;
import pl.edu.pb.wi.sbd.Context;
import pl.edu.pb.wi.sbd.controllers.models.KawiaTable;
import pl.edu.pb.wi.sbd.database.models.Hodowla;
import pl.edu.pb.wi.sbd.database.models.Kawia;
import pl.edu.pb.wi.sbd.database.models.Rasa;
import pl.edu.pb.wi.sbd.database.repository.KawiaRepository;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Radosław Naruszewicz on 2016-12-11.
 */
@Controller
public class MainController implements Initializable {

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
    ListView<String> listViewCategory;
    @FXML
    Button logoutButton;
    @FXML
    Button addNewCaviaButton;

    private ConfigurableApplicationContext context = Context.getInstance();

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
    }

    public void logoutClick() {
        Context.setLogged(null);
        Stage stage = (Stage) logoutButton.getScene().getWindow();
        stage.close();
    }

    public void addCaviaClick(){

    }

    private ObservableList<KawiaTable> getAllCavia() {
        KawiaRepository kawiaRepository = context.getBean(KawiaRepository.class);
        return AdapterKawia.adapt(kawiaRepository.findByWlasiciel(Context.getLogged().getIdLogin()));
    }
}
