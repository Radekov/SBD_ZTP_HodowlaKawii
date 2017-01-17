package pl.edu.pb.wi.sbd.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import pl.edu.pb.wi.sbd.controllers.patterns.*;
import pl.edu.pb.wi.sbd.database.models.Hodowla;
import pl.edu.pb.wi.sbd.database.models.Login;
import pl.edu.pb.wi.sbd.database.models.Milosnik;
import pl.edu.pb.wi.sbd.database.models.Zarzad;

import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by Radosław Naruszewicz on 2017-01-05.
 */
public class MainController extends AbstractController {

    @FXML
    private VBox interface_user;
    @FXML
    private Label payment;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Strategy strategy= null;
        sObservable.addObserver(this);
        Login l = CONTEXT.getLogged();
        UserFactory intefaceUser = null;
        switch(l.getType()){
            case BREEDING:intefaceUser = new BreederFactory(this,bannerController); strategy = new StrategyBreeder(); break;
            case LOVER:intefaceUser = new LoverFactory(this,bannerController); strategy = new StrategyLover(); break;
            case CONTROL:intefaceUser = new ManagerFactory(this,bannerController); strategy = new StrategyManger(); break;
        }
        intefaceUser.createButtons();
        intefaceUser.createHeader();
        intefaceUser.createToolbar();
        interface_user.getChildren().addAll(intefaceUser.getHeader(),intefaceUser.getPanel());
        intefaceUser.getHeader().getChildren().forEach(e-> System.out.println(e));
        interface_user.getChildren().forEach(e-> System.out.println(e));
        addControls();
        payment.setText(String.format(Locale.US, "Do zapłaty %.2f zł",strategy.calculate(l)));
    }

    @Override
    protected void initData(FXMLLoader fxmlLoader) {

    }

    @Override
    protected void addControls() {
        controls.addAll(interface_user.getChildren());
    }
}
