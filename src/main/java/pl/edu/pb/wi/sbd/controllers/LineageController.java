/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.edu.pb.wi.sbd.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import pl.edu.pb.wi.sbd.Context;
import pl.edu.pb.wi.sbd.controllers.models.OwnerCavies;
import pl.edu.pb.wi.sbd.database.models.Kawia;
import pl.edu.pb.wi.sbd.database.models.Miot;
import pl.edu.pb.wi.sbd.database.repository.KawiaRepository;
import pl.edu.pb.wi.sbd.database.repository.WagaRepository;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;

/**
 * FXML Controller class
 *
 * @author Admin
 */
public class LineageController extends AbstractWindowController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private Label label_kawia_przydomek;

    @FXML
    private Label label_kawia_sex;

    @FXML
    private Label label_kawia_colour;

    @FXML
    private Label label_kawia_race;

    @FXML
    private Label label_kawia_birthday;

    @FXML
    private Label label_kawia_colour1;

    @FXML
    private ComboBox<FileType> combo_file;

    @FXML
    private Label label_kawia_przydomek1;

    @FXML
    private Label label_kawia_race1;

    @FXML
    private Button button_back;

    @FXML
    private ComboBox<Kawia> combo_kawii;

    @FXML
    private Label label_kawia_name;

    @FXML
    private Label label_kawia_weight;

    @FXML
    private Button button_generate;

    @FXML
    private Label label_kawia_name1;


    private WagaRepository wagaRepository;

    @FXML
    void updateAll(ActionEvent event) {
        Kawia k = combo_kawii.getValue();
        label_kawia_name.setText(k.getImie());
        label_kawia_przydomek.setText(k.getPrzydomek());
        label_kawia_race.setText(k.getIdRasa().getRasa());
        label_kawia_colour.setText(k.getIdRasa().getMasc());
        label_kawia_sex.setText(k.getPlec()?"1,0":"0,1");
        Double weight = wagaRepository.findByLastWaga(k.getIdKawia());
        if(weight != null) label_kawia_weight.setText(weight.toString());
        else label_kawia_weight.setText("0");

        Miot m = k.getIdMiot();
        if(k.getIdMiot()==null) return;

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        if(k.getIdMiot().getDataUrodzenia()!=null)
        label_kawia_birthday.setText(sdf.format(k.getIdMiot().getDataUrodzenia()));

        Kawia mot = m.getKawia();
        if(mot == null) return;
        label_kawia_name1.setText(mot.getImie());
        label_kawia_przydomek1.setText(mot.getPrzydomek());
        if(mot.getIdRasa() == null) return;
        label_kawia_race1.setText(mot.getIdRasa().getRasa());
        label_kawia_colour1.setText(mot.getIdRasa().getMasc());

    }

    @FXML
    void generate(ActionEvent event) {
        Kawia k = combo_kawii.getValue();
//        TODO
        switch (combo_file.getValue()){
            case GSON:
            case HTML:
            case JSON:
            case TXT:
            case XML:
        }
    }

    @FXML
    void back(ActionEvent event) {
        unregister();((Stage) button_back.getScene().getWindow()).close();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        sObservable.addObserver(this);
        addControls();
        KawiaRepository kawiaRepository = Context.CONTEXT.getInstance().getBean(KawiaRepository.class);
        wagaRepository = Context.CONTEXT.getInstance().getBean(WagaRepository.class);
        ObservableList<Kawia> data = FXCollections.observableArrayList();
        OwnerCavies cavies = Context.CONTEXT.getLogged();
        data.addAll(cavies.getAllCavies());
        combo_kawii.setItems(data);
        combo_kawii.setConverter(converter);
    }    

    enum FileType{
        GSON("GSON"),JSON("JSON"),HTML("HTML"),XML("XML"),TXT("TXT");

        private final String type;
        private FileType(String type){this.type = type;}

        @Override
        public String toString() { return type; }
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
