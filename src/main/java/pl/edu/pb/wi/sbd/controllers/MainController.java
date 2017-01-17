package pl.edu.pb.wi.sbd.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.VBox;
import pl.edu.pb.wi.sbd.controllers.patterns.BreederFactory;
import pl.edu.pb.wi.sbd.controllers.patterns.LoverFactory;
import pl.edu.pb.wi.sbd.controllers.patterns.ManagerFactory;
import pl.edu.pb.wi.sbd.controllers.patterns.UserFactory;
import pl.edu.pb.wi.sbd.database.models.Hodowla;
import pl.edu.pb.wi.sbd.database.models.Login;
import pl.edu.pb.wi.sbd.database.models.Milosnik;
import pl.edu.pb.wi.sbd.database.models.Zarzad;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Radosław Naruszewicz on 2017-01-05.
 */
public class MainController extends AbstractController {

    @FXML
    private VBox interface_user;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        sObservable.addObserver(this);
        Login l = CONTEXT.getLogged();
        UserFactory intefaceUser = null;
        if(l instanceof Hodowla)intefaceUser = new BreederFactory(this,bannerController);
        if(l instanceof Milosnik)intefaceUser = new LoverFactory(this,bannerController);
        if(l instanceof Zarzad) intefaceUser = new ManagerFactory(this,bannerController);
        intefaceUser.createButtons();
        intefaceUser.createHeader();
        intefaceUser.createToolbar();
        interface_user.getChildren().addAll(intefaceUser.getHeader(),intefaceUser.getPanel());
        intefaceUser.getHeader().getChildren().forEach(e-> System.out.println(e));
        interface_user.getChildren().forEach(e-> System.out.println(e));
        addControls();
    }

    @Override
    protected void initData(FXMLLoader fxmlLoader) {

    }

    @Override
    protected void addControls() {
        controls.addAll(interface_user.getChildren());
    }
}
