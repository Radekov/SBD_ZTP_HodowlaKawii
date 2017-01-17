package pl.edu.pb.wi.sbd.controllers.patterns;

import javafx.scene.control.Button;
import pl.edu.pb.wi.sbd.controllers.AbstractWindowController;
import pl.edu.pb.wi.sbd.controllers.BannerController;
import pl.edu.pb.wi.sbd.database.models.Milosnik;
/**
 * Created by Radosław Naruszewicz on 2017-01-17.
 */
public class LoverFactory extends UserFactory {

    public LoverFactory(AbstractWindowController awc,BannerController toolbarController) {
        super(awc, toolbarController);
    }

    @Override
    public void createHeader() {
        super.createHeader();
        Milosnik m = (Milosnik) l;
        kind.setText("MILOSNIK");
        name.setText(m.getIdOsoba().getImie() + " " + m.getIdOsoba().getNazwisko());
        status.setText(m.getStatus());
        addToHBoxAndSet(header,kind,name,status);
    }

    @Override
    public void createButtons() {
        Button listCavia = new Button("Spis Kawii");
        Button setWeight = new Button("Ustaw wagę");
        Button createLineage = new Button("Rodowód");

        listCavia.setOnAction(e -> {awc.unregister(); openScene(e, "/fxml/cavia_list.fxml");});
        setWeight.setOnAction(e -> openWindow("/fxml/weight.fxml"));
        createLineage.setOnAction(e -> openWindow("/fxml/Lineage.fxml"));
        addToHBoxAndSet(panel, listCavia, setWeight, createLineage);
    }

    @Override
    public void createCash() {

    }
}
