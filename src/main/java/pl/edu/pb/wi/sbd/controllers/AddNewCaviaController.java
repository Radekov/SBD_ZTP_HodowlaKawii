package pl.edu.pb.wi.sbd.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import org.springframework.context.ConfigurableApplicationContext;
import pl.edu.pb.wi.sbd.Context;
import pl.edu.pb.wi.sbd.database.models.Hodowla;
import pl.edu.pb.wi.sbd.database.models.Kawia;
import pl.edu.pb.wi.sbd.database.models.Rasa;
import pl.edu.pb.wi.sbd.database.repository.RasaRepository;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Radosław Naruszewicz on 2016-12-14.
 */
public class AddNewCaviaController extends AbstractController{

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
    private TextField text_weight;

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

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    void actionAddNewCavia(ActionEvent event) {

    }

    @FXML
    void actionCancelAddNewCavia(ActionEvent event) {

    }

}
