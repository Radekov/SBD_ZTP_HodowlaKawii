package pl.edu.pb.wi.sbd.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import pl.edu.pb.wi.sbd.controllers.models.KawiaTable;
import pl.edu.pb.wi.sbd.database.models.Kawia;

import java.util.List;

/**
 * Created by Radosław Naruszewicz on 2016-12-11.
 */
public class AdapterKawia {

    public static ObservableList<KawiaTable> adapt(List<Kawia> list){
        ObservableList<KawiaTable> result = FXCollections.observableArrayList();
        for (Kawia k :
                list) {
            KawiaTable kt = new KawiaTable(k);
            result.add(kt);
        }
        return result;
    }

}
