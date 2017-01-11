package pl.edu.pb.wi.sbd.controllers;

import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableDoubleValue;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import pl.edu.pb.wi.sbd.controllers.models.OwnerCavies;
import pl.edu.pb.wi.sbd.database.models.Kawia;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Radosław Naruszewicz on 2017-01-09.
 */
public class TableCaviaController extends AbstractController{

    @FXML // fx:id="column_hodowla"
    private TableColumn<Kawia, String> column_hodowla; // Value injected by FXMLLoader

    @FXML // fx:id="column_colour"
    private TableColumn<Kawia, String> column_colour; // Value injected by FXMLLoader

    @FXML // fx:id="column_mom"
    private TableColumn<Kawia, String> column_mom; // Value injected by FXMLLoader

    @FXML // fx:id="column_weight"
    private TableColumn<Kawia, Double> column_weight; // Value injected by FXMLLoader

    @FXML // fx:id="table_cavia"
    private TableView<Kawia> table_cavia; // Value injected by FXMLLoader

    @FXML // fx:id="column_race"
    private TableColumn<Kawia, String> column_race; // Value injected by FXMLLoader

    @FXML // fx:id="column_name"
    private TableColumn<Kawia, String> column_name; // Value injected by FXMLLoader

    @FXML // fx:id="column_lp"
    private TableColumn<Kawia, Integer> column_lp; // Value injected by FXMLLoader

    @FXML // fx:id="column_sex"
    //TODO zmienić na String
    private TableColumn<Kawia, Boolean> column_sex; // Value injected by FXMLLoader

    @FXML // fx:id="column_dad"
    private TableColumn<Kawia, String> column_dad; // Value injected by FXMLLoader

    @FXML // fx:id="button_remove_cavia"
    private Button button_remove_cavia; // Value injected by FXMLLoader

    @FXML // fx:id="button_add_cavia"
    private Button button_add_cavia; // Value injected by FXMLLoader

    @FXML // fx:id="button_add_cavia"
    private Button button_back; // Value injected by FXMLLoader

    private ObservableList<Kawia> data;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        OwnerCavies cavies = CONTEXT.getLogged();
        data = FXCollections.observableArrayList();
        data.addAll(cavies.getAllCavies());
        initializeColumns();
        table_cavia.setItems(data);
    }

    private void initializeColumns(){
        column_lp.setCellValueFactory(new PropertyValueFactory<Kawia, Integer>("idKawia"));
        column_name.setCellValueFactory(new PropertyValueFactory<Kawia, String>("imie"));
        column_sex.setCellValueFactory(new PropertyValueFactory<Kawia, Boolean>("plec"));
        //Kawia->Miot->Hodowla->Nazwa
        column_hodowla.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Kawia,String>, ObservableValue<String>>(){
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Kawia, String> param) {
                return new SimpleStringProperty(param.getValue().getIdMiot().getIdHodowla().getNazwaHodowla());
            }
        });
        //Todo naprawić Miot rodzice
        //Kawia->Miot->Kawia_Mama->Imie
        column_mom.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Kawia,String>, ObservableValue<String>>(){
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Kawia, String> param) {
                return new SimpleStringProperty(param.getValue().getIdMiot().getKawia().getImie());//FIX
            }
        });
//        //Kawia->Miot->Kawia_Tata->Imie
//        column_mom.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Kawia,String>, ObservableValue<String>>(){
//            @Override
//            public ObservableValue<String> call(TableColumn.CellDataFeatures<Kawia, String> param) {
//                return new SimpleStringProperty(param.getValue().getIdMiot().getTata().getImie());
//            }
//        });
        column_race.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Kawia,String>, ObservableValue<String>>(){
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Kawia, String> param) {
                return new SimpleStringProperty(param.getValue().getIdRasa().getRasa());
            }
        });
        column_colour.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Kawia,String>, ObservableValue<String>>(){
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Kawia, String> param) {
                return new SimpleStringProperty(param.getValue().getIdRasa().getMasc());
            }
        });
        column_weight.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Kawia,Double>, ObservableValue<Double>>(){
            @Override
            public ObservableValue<Double> call(TableColumn.CellDataFeatures<Kawia, Double> param) {
                return new SimpleDoubleProperty(param.getValue().getLastWaga()).asObject();
            }
        });
    }

    @FXML
    void actionAddNewCavia(ActionEvent event) {

    }

    @FXML
    void actionDeleteSelectedCavia(ActionEvent event) {

    }

    @FXML
    void actionBack(ActionEvent event) {

    }
}
