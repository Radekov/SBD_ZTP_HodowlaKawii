package pl.edu.pb.wi.sbd.controllers;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import pl.edu.pb.wi.sbd.Context;
import pl.edu.pb.wi.sbd.database.models.Hodowla;
import pl.edu.pb.wi.sbd.database.models.Kawia;
import pl.edu.pb.wi.sbd.database.models.Miot;
import pl.edu.pb.wi.sbd.database.models.Rasa;
import pl.edu.pb.wi.sbd.database.repository.KawiaRepository;
import pl.edu.pb.wi.sbd.database.repository.MiotRepository;
import pl.edu.pb.wi.sbd.database.repository.RasaRepository;

import java.net.URL;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Observable;
import java.util.ResourceBundle;

/**
 * Created by Radosław Naruszewicz on 2016-12-14.
 */
public class AddNewCaviaController extends AbstractWindowController implements Initializable{

    @FXML
    private RadioButton radio_button_female;

    @FXML
    private Label label_mother_race;

    @FXML
    private TextField text_przydomek;

    @FXML
    private TextField text_race;

    @FXML
    private Label label_father_przydomek;

    @FXML
    private RadioButton radio_button_male;

    @FXML
    private Label label_error;

    @FXML
    private Label label_mother_colour;

    @FXML
    private DatePicker date_picker_born;

    @FXML
    private Label label_father_colour;

    @FXML
    private ComboBox<Kawia> combo_mother;

    @FXML
    private Button button_back;

    @FXML
    private ComboBox<Kawia> combo_father;

    @FXML
    private Label label_mother_przydomek;


    @FXML
    private Label label_father_race;

    @FXML
    private TextField text_name;

    @FXML
    private Button button_add_new_cavia;

    @FXML
    private TextField text_colour;

    @FXML
    private CheckBox checkbox_owner;

    @FXML
    private Label label_mother_name;

    @FXML
    private Label label_father_name;

    @FXML
    private ToggleGroup selected_sex;

    protected Context CONTEXT = Context.CONTEXT;

    private ObservableList<Kawia> fathersObservableList;
    private ObservableList<Kawia> mothersObservableList;
    private Kawia newKawia = new Kawia();
    private Miot newMiot = new Miot();

    TableView<Kawia> originalTableCavies;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        sObservable.addObserver(this);
        addControls();
        sObservable.update();
        KawiaRepository kawiaRepository = CONTEXT.getInstance().getBean(KawiaRepository.class);
        fathersObservableList = FXCollections.observableArrayList();
        fathersObservableList.addAll(kawiaRepository.findByPlec(true));
        mothersObservableList = FXCollections.observableArrayList();
        mothersObservableList.addAll(kawiaRepository.findByPlec(false));

        combo_father.setItems(fathersObservableList);
        combo_mother.setItems(mothersObservableList);
        combo_father.setConverter(converter);
        combo_mother.setConverter(converter);

        newKawia.setPlec(true);
        selected_sex.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
                RadioButton chk = (RadioButton)newValue.getToggleGroup().getSelectedToggle();
                if(newValue == radio_button_female)
                    newKawia.setPlec(false);
                else if (newValue == radio_button_male)
                    newKawia.setPlec(true);
            }
        });
        date_picker_born.setValue(LocalDate.now());
    }

    void initData(TableView<Kawia> table){
        originalTableCavies = table;
    }

    @FXML
    void actionAddNewCavia(ActionEvent event) {
        newKawia.setImie(text_name.getText());
        newKawia.setPrzydomek(text_przydomek.getText());

        String race = text_race.getText();
        String colour = text_colour.getText();

        RasaRepository rasaRepository = CONTEXT.getInstance().getBean(RasaRepository.class);
        //TODO Sprawdzić czy nowa rasa z maścią istnieje już
        Rasa rasa = new Rasa();
        rasa.setMasc(colour);
        rasa.setRasa(race);
        rasa = rasaRepository.save(rasa);
        newKawia.setIdRasa(rasa);

        if(checkbox_owner.isSelected()){
            newKawia.setIdHodowla((Hodowla) CONTEXT.getLogged());
        }
        //TODO w przeciwnym wypadku na podstawie przydomka stworzyć nową hodowlę
        rasa = rasaRepository.save(rasa);
        MiotRepository miotRepository = CONTEXT.getInstance().getBean(MiotRepository.class);
        newMiot = miotRepository.save(newMiot);
        KawiaRepository kawiaRepository = CONTEXT.getInstance().getBean(KawiaRepository.class);
        newKawia.setIdRasa(rasa);
        newKawia.setIdMiot(newMiot);
        newKawia = kawiaRepository.save(newKawia);

        //return newKawia;
        originalTableCavies.getItems().add(newKawia);
        actionCancelAddNewCavia(event);
    }

    @FXML
    void actionCancelAddNewCavia(ActionEvent event) {
        fathersObservableList = null;
        mothersObservableList = null;
        newMiot = null;
        newKawia = null;
        unregister();
        ((Stage)button_add_new_cavia.getScene().getWindow()).close();
    }

    @FXML
    void actionSetDate(ActionEvent event){
        Date date = Date.from(date_picker_born.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
        newMiot.setDataUrodzenia(date);
    }

    @FXML
    void actionSelectedFather(ActionEvent event) {
        Kawia father = combo_father.getValue();
        label_father_colour.setText(father.getIdRasa().getMasc());
        label_father_name.setText(father.getImie());
        label_father_przydomek.setText(father.getPrzydomek());
        label_father_race.setText(father.getIdRasa().getRasa());
        //TODO
        //newMiot.setKawia(father);
    }

    @FXML
    void actionSelectedMother(ActionEvent event) {
        Kawia mother = combo_father.getValue();
        label_mother_colour.setText(mother.getIdRasa().getMasc());
        label_mother_name.setText(mother.getImie());
        label_mother_przydomek.setText(mother.getPrzydomek());
        label_mother_race.setText(mother.getIdRasa().getRasa());
        newMiot.setKawia(mother);
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

    @Override
    public void update(Observable o, Object arg) {
        super.update(o, arg);
    }
}
