package pl.edu.pb.wi.sbd.controllers.models;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.ComboBoxTableCell;
import pl.edu.pb.wi.sbd.database.models.Kawia;

/**
 * Created by Radosław Naruszewicz on 2017-01-14.
 */
public class TableViewColumns {
    public static void initializeColumnSex(TableColumn<Kawia, String> column_sex){
        column_sex.setCellValueFactory(param -> {
                    String result = "1,0";
                    Boolean plec = param.getValue().getPlec();
                    if (plec == null) return new SimpleStringProperty("---");
                    return plec ? new SimpleStringProperty("1,0") : new SimpleStringProperty("0,1");
                }
        );
        column_sex.setCellFactory(ComboBoxTableCell.forTableColumn(FXCollections.observableArrayList(
                new String("1,0"),
                new String("0,1")
        )));
        column_sex.setOnEditCommit(t -> {
            String newValue = t.getNewValue();
            Boolean sex = true;
            if (t.getNewValue().equals("1,0")) sex = true;
            if (t.getNewValue().equals("0,1")) sex = false;
            ((Kawia) t.getTableView().getItems().get(t.getTablePosition().getRow())).setPlec(sex);
        });
    }
}
