package pl.edu.pb.wi.sbd.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
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
//NIEUZYWANE
public class AddNewCaviaController implements Initializable{

    @FXML
    Button addButton;
    @FXML
    Button cancelButton;

    @FXML
    ChoiceBox<String> rasaSelect;
    @FXML
    ChoiceBox<String> mascSelect;

    @FXML
    TextField nameCaviaField;
    @FXML TextField nrCaviaField;

    ConfigurableApplicationContext context = Context.getInstance();

    String rasa;
    String masc;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        rasaSelect.getItems().addAll("Sheltie","Texel");
        mascSelect.getItems().addAll("Czekoladowe","Czarne");

        rasaSelect.getSelectionModel().selectedItemProperty()
                .addListener((observable, oldValue, newValue) -> {
                    rasa = newValue;
                });

        mascSelect.getSelectionModel().selectedItemProperty()
                .addListener((observable, oldValue, newValue) -> {
                    masc = newValue;
                });
    }

    @FXML
    public void confirmAddNew(ActionEvent event){
        String name = nameCaviaField.getText();
        String nrCavia = nrCaviaField.getText();

        Kawia kawia = new Kawia();
        kawia.setImie(name);
        kawia.setNrIndywidualny(nrCavia);

        Rasa rasa = new Rasa();
        rasa.setMasc(masc);
        rasa.setRasa(this.rasa);
        RasaRepository rasaRepository = context.getBean(RasaRepository.class);
        Rasa result = rasaRepository.findByRasaAndMasc(masc,this.rasa);
        if(result == null){
            result = rasaRepository.save(rasa);
        }
        kawia.setIdRasa(result);
//        kawia.getHodowlaCollection().add((Hodowla)Context.getLogged());
//        kawia.set
    }

    @FXML
    public void cancelAddNew(ActionEvent event){

    }

}
