package pl.edu.pb.wi.sbd.controllers.patterns;

import javafx.scene.control.Button;
import pl.edu.pb.wi.sbd.controllers.BannerController;
import pl.edu.pb.wi.sbd.controllers.ToolbarController;

/**
 * Created by Radosław Naruszewicz on 2017-01-17.
 */
public class ManagerFactory extends UserFactory{

    public ManagerFactory(BannerController toolbarController) {
        super(toolbarController);
    }

    @Override
    public void createButtons() {
        Button listUser = new Button("Spis Użytkowników");
        Button addPerson = new Button("Dodaj osobę");
        Button addUser = new Button("Dodaj użytkownika");

        listUser.setOnAction(e->openWindow("/fxml/user_list.fxml"));
        addPerson.setOnAction(e->openWindow("/fxml/addPerson"));
        addUser.setOnAction(e->openWindow("/fxml/AddUser"));
        addToHBoxAndSet(panel,listUser,addPerson,addUser);

    }

    @Override
    public void createHeader() {
        super.createHeader();
        kind.setText("ZARZĄD");
        name.setText(l.getIdOsoba().getImie() + " " + l.getIdOsoba().getNazwisko());
        status.setText(l.getStatus());
        addToHBoxAndSet(header,kind,name,status);
    }

    @Override
    public void createCash() {
        //TODO Strategia?
    }
}
