package pl.edu.pb.wi.sbd.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import pl.edu.pb.wi.sbd.Context;
import pl.edu.pb.wi.sbd.database.models.Osoba;
import pl.edu.pb.wi.sbd.database.repository.OsobaRepository;
import pl.edu.pb.wi.sbd.dialogs.AlertBox;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Radosław Naruszewicz on 2017-01-15.
 */
public class AddPersonController extends AbstractWindowController implements Initializable {

    @FXML // fx:id="PostelCode"
    private TextField PostelCode; // Value injected by FXMLLoader

    @FXML // fx:id="cancelButton"
    private Button cancelButton; // Value injected by FXMLLoader

    @FXML // fx:id="FirstName"
    private TextField FirstName; // Value injected by FXMLLoader

    @FXML // fx:id="Phone"
    private TextField Phone; // Value injected by FXMLLoader

    @FXML // fx:id="AddPersonButton"
    private Button AddPersonButton; // Value injected by FXMLLoader

    @FXML // fx:id="Street"
    private TextField Street; // Value injected by FXMLLoader

    @FXML // fx:id="LastName"
    private TextField LastName; // Value injected by FXMLLoader

    @FXML // fx:id="City"
    private TextField City; // Value injected by FXMLLoader

    @FXML // fx:id="ErrorsLabel"
    private Label ErrorsLabel; // Value injected by FXMLLoader

    @FXML
    void AddPerson(ActionEvent event) {
        String error = "";
        if(isEmpty(FirstName.getText())) error+="Wpisz imię. ";
        if(isEmpty(LastName.getText())) error+="Wpisz nazwisko. ";
        if(isEmpty(PostelCode.getText())) error+="Wpisz kod pocztowy. ";
        if(isEmpty(City.getText())) error+="Wpisz miasto. ";
        if(isEmpty(Street.getText())) error+="Wpisz ulicę. ";
        if(isEmpty(Phone.getText())) error+="Wpisz Telefon. ";
        ErrorsLabel.setText(error);
        if(!error.equals("")) return;
        //TODO sprawdzenie składni każdego pola

        Osoba o = new Osoba();
        o.setImie(FirstName.getText());
        o.setNazwisko(LastName.getText());
        o.setKodPocztowy(PostelCode.getText());
        o.setMiasto(City.getText());
        o.setUlica(Street.getText());
        o.setTelefon(Phone.getText());
        OsobaRepository osobaRepository = Context.CONTEXT.getInstance().getBean(OsobaRepository.class);
        osobaRepository.save(o);
        new AlertBox().display("Komunikat","Dodano nową osobę");
        this.cancel(event);
    }

    @FXML
    void cancel(ActionEvent event) {
        unregister();
        ((Stage)cancelButton.getScene().getWindow()).close();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ((Stage)cancelButton.getScene().getWindow()).setOnCloseRequest(e->unregister());
        sObservable.addObserver(this);
        addControls();
    }
    private boolean isEmpty(String text){
        if(text == null || text.equals("")) return true;
        return false;
    }
}
