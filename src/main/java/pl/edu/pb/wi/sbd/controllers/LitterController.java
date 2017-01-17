package pl.edu.pb.wi.sbd.controllers;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import pl.edu.pb.wi.sbd.Context;
import pl.edu.pb.wi.sbd.controllers.models.TableViewColumns;
import pl.edu.pb.wi.sbd.database.models.Hodowla;
import pl.edu.pb.wi.sbd.database.models.Kawia;
import pl.edu.pb.wi.sbd.database.models.Miot;
import pl.edu.pb.wi.sbd.database.models.Rasa;
import pl.edu.pb.wi.sbd.database.repository.KawiaRepository;
import pl.edu.pb.wi.sbd.database.repository.MiotRepository;
import pl.edu.pb.wi.sbd.database.repository.RasaRepository;
import pl.edu.pb.wi.sbd.dialogs.AlertBox;

import java.net.URL;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Created by Radosław Naruszewicz on 2017-01-14.
 */
public class LitterController extends AbstractWindowController implements Initializable {

    @FXML // fx:id="label_mother_race"
    private Label label_mother_race; // Value injected by FXMLLoader

    @FXML // fx:id="column_colour"
    private TableColumn<Kawia, String> column_colour; // Value injected by FXMLLoader

    @FXML // fx:id="label_father_przydomek"
    private Label label_father_przydomek; // Value injected by FXMLLoader

    @FXML // fx:id="column_race"
    private TableColumn<Kawia, String> column_race; // Value injected by FXMLLoader

    @FXML // fx:id="column_name"
    private TableColumn<Kawia, String> column_name; // Value injected by FXMLLoader

    @FXML // fx:id="label_mother_colour"
    private Label label_mother_colour; // Value injected by FXMLLoader

    @FXML // fx:id="button_add_litter"
    private Button button_add_litter; // Value injected by FXMLLoader

    @FXML // fx:id="combo_mother"
    private ComboBox<Kawia> combo_mother; // Value injected by FXMLLoader

    @FXML // fx:id="label_father_colour"
    private Label label_father_colour; // Value injected by FXMLLoader

    @FXML // fx:id="button_back"
    private Button button_back; // Value injected by FXMLLoader

    @FXML // fx:id="combo_father"
    private ComboBox<Kawia> combo_father; // Value injected by FXMLLoader

    @FXML // fx:id="label_mother_przydomek"
    private Label label_mother_przydomek; // Value injected by FXMLLoader

    @FXML // fx:id="button_add_next"
    private Button button_add_next; // Value injected by FXMLLoader

    @FXML // fx:id="label_father_race"
    private Label label_father_race; // Value injected by FXMLLoader

    @FXML // fx:id="date_born"
    private DatePicker date_born; // Value injected by FXMLLoader

    @FXML // fx:id="button_remove"
    private Button button_remove; // Value injected by FXMLLoader

    @FXML // fx:id="nrLitter"
    private Label nrLitter; // Value injected by FXMLLoader

    @FXML // fx:id="column_sex"
    private TableColumn<Kawia, String> column_sex; // Value injected by FXMLLoader

    @FXML // fx:id="label_mother_name"
    private Label label_mother_name; // Value injected by FXMLLoader

    @FXML // fx:id="label_father_name"
    private Label label_father_name; // Value injected by FXMLLoader

    @FXML
    private TableView<Kawia> tableLitter;

    private KawiaRepository kawiaRepository;
    MiotRepository miotRepository;
    private Miot newMiot = new Miot();
    private List<Kawia> listKawia;
    private ObservableList<Kawia> fathersObservableList;
    private ObservableList<Kawia> mothersObservableList;

    private ObservableList<Kawia> miotObservableList;

    Kawia prototyp;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        sObservable.addObserver(this);
        addControls();
        kawiaRepository = Context.CONTEXT.getInstance().getBean(KawiaRepository.class);
        miotRepository = Context.CONTEXT.getInstance().getBean(MiotRepository.class);
        fathersObservableList = FXCollections.observableArrayList();
        fathersObservableList.addAll(kawiaRepository.findByPlec(true));
        mothersObservableList = FXCollections.observableArrayList();
        mothersObservableList.addAll(kawiaRepository.findByPlec(false));

        combo_father.setItems(fathersObservableList);
        combo_mother.setItems(mothersObservableList);
        combo_father.setConverter(converter);
        combo_mother.setConverter(converter);
        combo_father.setOnAction(e->{
            Kawia f = combo_father.getValue();
            label_father_colour.setText(f.getIdRasa().getMasc());
            label_father_name.setText(f.getImie());
            label_father_przydomek.setText(f.getPrzydomek());
            label_father_race.setText(f.getIdRasa().getRasa());
        });
        combo_mother.setOnAction(e->{
            Kawia m = combo_mother.getValue();
            label_mother_colour.setText(m.getIdRasa().getMasc());
            label_mother_name.setText(m.getImie());
            label_mother_przydomek.setText(m.getPrzydomek());
            label_mother_race.setText(m.getIdRasa().getRasa());
        });
        initButtons();
        initColumns();
        newMiot.setIdHodowla(((Hodowla) Context.CONTEXT.getLogged()));
        Hodowla h = (Hodowla) Context.CONTEXT.getLogged();
        Integer count = miotRepository.getCount(h);
        if (count == null) count = 0;
        char firstLetter = (char) ('A' + count % ('Z' - 'A'));
        newMiot.setNrMiotu(++count);
        nrLitter.setText(count.toString());

        prototyp = new Kawia();
        prototyp.setIdHodowla(h);
        prototyp.setPrzydomek(h.getNazwaHodowla());
        System.out.println(h.getNazwaHodowla());
        prototyp.setImie(firstLetter + "");
        prototyp.setPlec(false);
        prototyp.setIdRasa(new Rasa());

        miotObservableList = FXCollections.observableArrayList();
        try {
            miotObservableList.add((Kawia) prototyp.clone());
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        tableLitter.setItems(miotObservableList);
        tableLitter.setEditable(true);
    }

    private void initButtons() {
        button_remove.setOnAction(e -> {
            Kawia kawia = tableLitter.getSelectionModel().getSelectedItem();
            if (kawia == null) return;
            if(tableLitter.getItems().size() == 1 ) return;
            tableLitter.getItems().remove(kawia);
            kawia.setIdHodowla(null);
        });
        button_back.setOnAction(e -> {unregister();close();});
        button_add_next.setOnAction(e -> {
            try {
                tableLitter.getItems().add((Kawia)prototyp.clone());
            } catch (CloneNotSupportedException e1) {
                e1.printStackTrace();
            }
        });
        button_add_litter.setOnAction(e -> {
            miotObservableList = tableLitter.getItems();
            if (miotObservableList.isEmpty()) return;
            Kawia f = combo_father.getValue();
            if (f == null) return;
            Kawia m = combo_mother.getValue();
            if (m == null) return;
            Date date = Date.from(date_born.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
            newMiot.setDataUrodzenia(date);
            newMiot.setKawia(m);
            newMiot = miotRepository.save(newMiot);
            miotObservableList.forEach(k->{
                if(k.getIdRasa().getRasa() == null || k.getIdRasa().getRasa().equals("")) return;
                if(k.getIdRasa().getMasc() == null || k.getIdRasa().getMasc().equals("")) return;
                RasaRepository rasaRepository = Context.CONTEXT.getInstance().getBean(RasaRepository.class);
                Rasa rasa = rasaRepository.save(k.getIdRasa());
                k.setIdRasa(rasa);
                k.setIdMiot(newMiot);
                kawiaRepository.save(k);
            });
            new AlertBox().display("Komunikat","Dodano nowy miot");
            close();
        });
    }
    private void close(){
        ((Stage) button_back.getScene().getWindow()).close();
    }

    private void initColumns() {
        column_name.setCellValueFactory(new PropertyValueFactory<Kawia, String>("imie"));
        column_name.setCellFactory(TextFieldTableCell.<Kawia>forTableColumn());
        column_name.setOnEditCommit(event -> {
            event.getRowValue().setImie(event.getNewValue());
        });
        TableViewColumns.initializeColumnSex(column_sex);
        column_race.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getIdRasa().getRasa()));
        column_race.setCellFactory(TextFieldTableCell.<Kawia>forTableColumn());
        column_race.setOnEditCommit(event -> {event.getRowValue().getIdRasa().setRasa(event.getNewValue());
            prototyp.getIdRasa().setRasa(event.getNewValue());
        });
        column_colour.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getIdRasa().getMasc()));
        column_colour.setCellFactory(TextFieldTableCell.<Kawia>forTableColumn());
        column_colour.setOnEditCommit(event -> {event.getRowValue().getIdRasa().setMasc(event.getNewValue());
            prototyp.getIdRasa().setMasc(event.getNewValue());
        });
    }

    StringConverter<Kawia> converter = new StringConverter<Kawia>() {
        @Override
        public String toString(Kawia object) {
            return object.getImie() + object.getPrzydomek();
        }

        @Override
        public Kawia fromString(String string) {
            return null;
        }
    };
}
