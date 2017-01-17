package pl.edu.pb.wi.sbd.controllers.patterns;

import javafx.scene.control.Button;
import pl.edu.pb.wi.sbd.controllers.AbstractWindowController;
import pl.edu.pb.wi.sbd.controllers.BannerController;
import pl.edu.pb.wi.sbd.database.models.Hodowla;
/**
 * Created by Radosław Naruszewicz on 2017-01-17.
 */
public class BreederFactory extends LoverFactory {

    public BreederFactory(AbstractWindowController awc, BannerController toolbarController) {
        super(awc, toolbarController);
    }

    @Override
    public void createHeader() {
        addButtonToLabel();
        Hodowla h = (Hodowla) l;
        kind.setText("Hodowla");
        name.setText(h.getNazwaHodowla());
        status.setText(h.getStatus());
        addToHBoxAndSet(header,kind,name,status);
    }

    @Override
    public void createButtons() {
        super.createButtons();
        Button createLitter = new Button("Miot");
        createLitter.setOnAction(e -> openWindow("/fxml/litter.fxml"));
        addToHBoxAndSet(panel,createLitter);
    }

    @Override
    public void createCash() {

    }
}
