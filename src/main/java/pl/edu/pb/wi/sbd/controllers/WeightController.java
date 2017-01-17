package pl.edu.pb.wi.sbd.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import pl.edu.pb.wi.sbd.Context;
import pl.edu.pb.wi.sbd.controllers.models.OwnerCavies;
import pl.edu.pb.wi.sbd.database.models.Kawia;
import pl.edu.pb.wi.sbd.database.models.Waga;
import pl.edu.pb.wi.sbd.database.repository.KawiaRepository;
import pl.edu.pb.wi.sbd.database.repository.WagaRepository;
import pl.edu.pb.wi.sbd.dialogs.AlertBox;

import java.net.URL;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.ResourceBundle;

/**
 * Created by Radosław Naruszewicz on 2017-01-14.
 */
public class WeightController extends AbstractWindowController  implements Initializable {
    @FXML // fx:id="DateWeight"
    private DatePicker DateWeight; // Value injected by FXMLLoader

    @FXML // fx:id="AddWeightButton"
    private Button AddWeightButton; // Value injected by FXMLLoader

    @FXML // fx:id="CancelWeightButton"
    private Button CancelWeightButton; // Value injected by FXMLLoader

    @FXML // fx:id="ComboCavia"
    private ComboBox<Kawia> ComboCavia; // Value injected by FXMLLoader

    @FXML // fx:id="ErrorsLabel"
    private Label ErrorsLabel; // Value injected by FXMLLoader

    @FXML // fx:id="Weight"
    private TextField Weight; // Value injected by FXMLLoader

    KawiaRepository kawiaRepository = Context.getInstance().getBean(KawiaRepository.class);
    private ObservableList<Kawia> data;
    private Waga newWaga;

    @FXML
    void AddWeight(ActionEvent event) {
        setDate();
        setKawia();
        newWaga.setWaga(Double.parseDouble(Weight.getText()));
        WagaRepository wagaRepository = Context.getInstance().getBean(WagaRepository.class);
        wagaRepository.save(newWaga);
        new AlertBox().display("Komunikat","Zaaktualizowano wagę kawii"+ComboCavia.getValue().getImie() + " " + ComboCavia.getValue().getPrzydomek());
        ((Stage)AddWeightButton.getScene().getWindow()).close();
    }

    @FXML
    void CancelWeight(ActionEvent event) {unregister();
        ((Stage)CancelWeightButton.getScene().getWindow()).close();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        sObservable.addObserver(this);
        addControls();
        data = FXCollections.observableArrayList();
        OwnerCavies cavies = Context.CONTEXT.getLogged();
        data.addAll(cavies.getAllCavies());
        ComboCavia.setItems(data);
        ComboCavia.setConverter(converter);
        DateWeight.setValue(LocalDate.now());

        newWaga = new Waga(null, new Date());
    }

    private void setDate(){
        Date date = Date.from(DateWeight.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
        newWaga.getWagaPK().setDataWazenia(date);
    }

    private void setKawia(){
        newWaga.setKawia(ComboCavia.getValue());
        newWaga.getWagaPK().setIdKawia(ComboCavia.getValue().getIdKawia());
    }

    StringConverter<Kawia> converter = new StringConverter<Kawia>() {
        @Override
        public String toString(Kawia object) {
            return object.getImie() + " " + object.getPrzydomek();
        }

        @Override
        public Kawia fromString(String string) {
            return null;
        }
    };
}
