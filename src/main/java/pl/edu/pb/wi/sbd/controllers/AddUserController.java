package pl.edu.pb.wi.sbd.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import pl.edu.pb.wi.sbd.Context;
import pl.edu.pb.wi.sbd.controllers.models.TypeUser;
import pl.edu.pb.wi.sbd.database.models.*;
import pl.edu.pb.wi.sbd.database.repository.*;
import pl.edu.pb.wi.sbd.dialogs.AlertBox;
import pl.edu.pb.wi.sbd.security.HashPassword;

import java.net.URL;
import java.time.ZoneId;
import java.util.Date;
import java.util.ResourceBundle;

/**
 * Created by Radosław Naruszewicz on 2017-01-15.
 */
public class AddUserController extends AbstractWindowController implements Initializable {

    @FXML // fx:id="group_status"
    private ToggleGroup group_status; // Value injected by FXMLLoader

    @FXML // fx:id="label_adress"
    private Label label_adress; // Value injected by FXMLLoader

    @FXML // fx:id="CancelButton"
    private Button CancelButton; // Value injected by FXMLLoader

    @FXML // fx:id="Diseable"
    private RadioButton Diseable; // Value injected by FXMLLoader

    @FXML // fx:id="text_b"
    private TextField text_b; // Value injected by FXMLLoader

    @FXML // fx:id="Date"
    private DatePicker DateS; // Value injected by FXMLLoader

    @FXML // fx:id="Name"
    private TextField Name; // Value injected by FXMLLoader

    @FXML // fx:id="combo_father"
    private ComboBox<Osoba> combo_person; // Value injected by FXMLLoader

    @FXML // fx:id="type_new_user"
    private ComboBox<TypeUser> type_new_user; // Value injected by FXMLLoader

    @FXML // fx:id="Active"
    private RadioButton Active; // Value injected by FXMLLoader

    @FXML // fx:id="password"
    private PasswordField password; // Value injected by FXMLLoader

    @FXML // fx:id="label_phone"
    private Label label_phone; // Value injected by FXMLLoader

    @FXML // fx:id="label_street"
    private Label label_street; // Value injected by FXMLLoader

    @FXML // fx:id="AddButton"
    private Button AddButton; // Value injected by FXMLLoader

    @FXML // fx:id="Suspended"
    private RadioButton Suspended; // Value injected by FXMLLoader

    @FXML // fx:id="ErrorsLabel"
    private Label ErrorsLabel; // Value injected by FXMLLoader

    @FXML // fx:id="text_login"
    private AnchorPane text_login; // Value injected by FXMLLoader

    @FXML
    void typeChoose(ActionEvent event) {
        isVisible();
    }

    private boolean isVisible() {
        if (type_new_user.getValue() == TypeUser.BREEDING) {
            text_b.setVisible(true);
            return true;
        } else text_b.setVisible(false);
        return false;
    }

    @FXML
    void cancelWindow(ActionEvent event){
        unregister();close();
    }

    @FXML
    void add(ActionEvent event) {
        String st="";
        if (group_status.getSelectedToggle() == Active) st="Aktywny";
        else if (group_status.getSelectedToggle() == Diseable) st="Zawieszony";
        else if (group_status.getSelectedToggle() == Suspended) st="Usunięta";
        Date date = Date.from(DateS.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
        //
        switch (type_new_user.getValue()) {
            case BREEDING:
                Hodowla h = new Hodowla();
                h.setNazwa(Name.getText());
                h.setHaslo(HashPassword.get_SHA_512_SecurePassword(password.getText()));
                h.setNazwaHodowla(text_b.getText());
                HodowlaRepository hodowlaRepository = Context.getInstance().getBean(HodowlaRepository.class);
                h = hodowlaRepository.save(h);
                HodowlaStatus status = new HodowlaStatus();
                status.setHodowlaStatusPK(new HodowlaStatusPK(h.getIdHodowla(), date));
                status.setStatus(st);
                status.setHodowla(h);
                HodowlaStatusRepository hodowlaStatus = Context.getInstance().getBean(HodowlaStatusRepository.class);
                hodowlaStatus.save(status);
                break;
            case CONTROL:
                Zarzad z = new Zarzad();
                z.setHaslo(HashPassword.get_SHA_512_SecurePassword(password.getText()));
                z.setNazwa(Name.getText());
                z.setStatus(st);
                z.setDataNadania(date);
                z.setIdOsoba(combo_person.getValue());
                ZarzadRepository zarzadRepository = Context.getInstance().getBean(ZarzadRepository.class);
                zarzadRepository.save(z);
                break;
            case LOVER:
                Milosnik m = new Milosnik();
                m.setIdOsoba(combo_person.getValue());
                m.setHaslo(HashPassword.get_SHA_512_SecurePassword(password.getText()));
                m.setDataNadania(date);
                m.setNazwa(Name.getText());
                m.setStatus(st);
                MilosnikRepository milosnikRepository = Context.getInstance().getBean(MilosnikRepository.class);
                milosnikRepository.save(m);
        }
        new AlertBox().display("Komunikat","Dodano nowego użytkownika");
        close();
    }

    private void close(){
        ((Stage)AddButton.getScene().getWindow()).close();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        sObservable.addObserver(this);
        addControls();
        OsobaRepository osobaRepository = Context.CONTEXT.getInstance().getBean(OsobaRepository.class);
        ObservableList<Osoba> personOsobaObservableList = FXCollections.observableArrayList();
        personOsobaObservableList.addAll(osobaRepository.findAll());
        combo_person.setItems(personOsobaObservableList);
        combo_person.setConverter(converter);
        combo_person.setOnAction(e -> {
            Osoba o = combo_person.getValue();
            label_phone.setText(o.getTelefon());
            label_adress.setText(o.getMiasto() + " " + o.getKodPocztowy());
            label_street.setText(o.getUlica());
        });
        type_new_user.getItems().addAll(TypeUser.values());
    }

    StringConverter<Osoba> converter = new StringConverter<Osoba>() {
        @Override
        public String toString(Osoba object) {
            return object.getImie() + " " + object.getNazwisko();
        }

        @Override
        public Osoba fromString(String string) {
            return null;
        }
    };

}