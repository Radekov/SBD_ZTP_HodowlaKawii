package pl.edu.pb.wi.sbd.controllers;

import javafx.application.Platform;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.StringConverter;
import pl.edu.pb.wi.sbd.controllers.models.OwnerCavies;
import pl.edu.pb.wi.sbd.database.models.Kawia;
import pl.edu.pb.wi.sbd.database.models.Miot;
import pl.edu.pb.wi.sbd.database.repository.KawiaRepository;
import pl.edu.pb.wi.sbd.database.repository.WagaRepository;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.ResourceBundle;

/**
 * Created by Radosław Naruszewicz on 2017-01-09.
 */
public class TableCaviaController extends AbstractController {

    @FXML // fx:id="column_hodowla"
    private TableColumn<Kawia, String> column_hodowla; // Value injected by FXMLLoader

    @FXML // fx:id="column_colour"
    private TableColumn<Kawia, String> column_colour; // Value injected by FXMLLoader

    @FXML // fx:id="column_age"
    private TableColumn<Kawia, Date> column_age; // Value injected by FXMLLoader

    @FXML // fx:id="column_mom"
    private TableColumn<Kawia, String> column_mom; // Value injected by FXMLLoader

    @FXML // fx:id="column_weight"
    private TableColumn<Kawia, Double> column_weight; // Value injected by FXMLLoader

    @FXML // fx:id="table_cavia"
    private TableView<Kawia> table_cavia; // Value injected by FXMLLoader

    @FXML // fx:id="column_race"
    private TableColumn<Kawia, String> column_race; // Value injected by FXMLLoader

    @FXML // fx:id="column_name"
    private TableColumn<Kawia, String> column_name; // Value injected by FXMLLoader

    @FXML // fx:id="column_lp"
    private TableColumn<Kawia, Integer> column_lp; // Value injected by FXMLLoader

    @FXML // fx:id="column_sex"
    //TODO zmienić na String
    private TableColumn<Kawia, String> column_sex; // Value injected by FXMLLoader

    @FXML // fx:id="column_dad"
    private TableColumn<Kawia, String> column_dad; // Value injected by FXMLLoader

    @FXML // fx:id="button_remove_cavia"
    private Button button_remove_cavia; // Value injected by FXMLLoader

    @FXML // fx:id="button_add_cavia"
    private Button button_add_cavia; // Value injected by FXMLLoader

    @FXML // fx:id="button_add_cavia"
    private Button button_back; // Value injected by FXMLLoader

    private ObservableList<Kawia> data;

    WagaRepository wagaRepository = CONTEXT.getInstance().getBean(WagaRepository.class);

    @Override
    public void initialize(URL location, ResourceBundle resources) {
//        caviesList = new ArrayList<>();
        data = FXCollections.observableArrayList();
        OwnerCavies cavies = CONTEXT.getLogged();
        data.addAll(cavies.getAllCavies());//RYZYKO dla hodowli/miłośnika która nie ma żadnych, że nie zadziała
//        caviesList = cavies.getAllCavies();
        initializeColumns();
        table_cavia.setItems(data);
        table_cavia.setEditable(true);
    }

    private void initializeColumns() {
        initializeColumnLp();
        initializeColumnName();
        initializeColumnSex();
        initializeColumnAge();
        initializeColumnHodowla();
        //Todo naprawić Miot rodzice
        //Kawia->Miot->Kawia_Mama->Imie
        column_mom.setCellValueFactory(param -> {
            Miot miot = param.getValue().getIdMiot();
            String value = miot.getKawia() != null ? miot.getKawia().getImie() : "---";
            return new SimpleStringProperty(value);//FIX
        });
//        //Kawia->Miot->Kawia_Tata->Imie
//        column_mom.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Kawia,String>, ObservableValue<String>>(){
//            @Override
//            public ObservableValue<String> call(TableColumn.CellDataFeatures<Kawia, String> param) {
//                return new SimpleStringProperty(param.getValue().getIdMiot().getTata().getImie());
//            }
//        });
        column_race.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getIdRasa().getRasa()));
        column_colour.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getIdRasa().getMasc()));
        column_weight.setCellValueFactory(param -> {
            Double weight = wagaRepository.findByLastWaga(param.getValue().getIdKawia());
            if (weight == null) weight = 0.0;
            return new SimpleDoubleProperty(weight).asObject();
        });
    }

    private void initializeColumnLp() {
        column_lp.setCellValueFactory(new PropertyValueFactory<Kawia, Integer>("idKawia"));
    }

    private void initializeColumnName() {
        column_name.setCellValueFactory(new PropertyValueFactory<Kawia, String>("imie"));
        column_name.setCellFactory(TextFieldTableCell.<Kawia>forTableColumn());
    }

    private void initializeColumnHodowla() {
        column_hodowla.setCellValueFactory(new PropertyValueFactory<Kawia, String>("przydomek"));
        column_name.setCellFactory(TextFieldTableCell.<Kawia>forTableColumn());
    }

    private void initializeColumnSex() {
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
        column_sex.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Kawia, String>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<Kawia, String> t) {
                        String newValue = t.getNewValue();
                        Boolean sex = true;
                        if (t.getNewValue().equals("1,0")) sex = true;
                        if (t.getNewValue().equals("0,1")) sex = false;
                        ((Kawia) t.getTableView().getItems().get(t.getTablePosition().getRow())).setPlec(sex);
                    }
                }
        );
//        column_sex.setCellFactory(p -> new RadioButtonCell<Kawia, Boolean>());
    }

    private void initializeColumnAge() {
        column_age.setCellValueFactory(param -> new SimpleObjectProperty<Date>(param.getValue().getIdMiot().getDataUrodzenia()));
        column_age.setCellFactory(p -> new DatePickerCell(data));
    }

    @FXML
    void actionAddNewCavia(ActionEvent event) {
        openWindow("/fxml/add_new_cavia.fxml");
    }

    @FXML
    void actionDeleteSelectedCavia(ActionEvent event) {
        Kawia kawia = table_cavia.getSelectionModel().getSelectedItem();
        if(kawia == null) return;
        kawia.setIdHodowla(null);
        data.remove(kawia);
        KawiaRepository kawiaRepository = CONTEXT.getInstance().getBean(KawiaRepository.class);
        kawiaRepository.updateHodowla(kawia.getIdKawia(),null);
    }

    @FXML
    void actionBack(ActionEvent event) {
        openScene(event,"/fxml/main.fxml");
    }

    @Override
    protected void initData(FXMLLoader fxmlLoader) {
        AddNewCaviaController controller = fxmlLoader.<AddNewCaviaController>getController();
        controller.initData(table_cavia);
    }

    StringConverter<Boolean> converter = new StringConverter<Boolean>() {
        @Override
        public String toString(Boolean object) {
            if (object == null) return "---";
            if (object) return "1,0";
            return "0,1";
        }

        @Override
        public Boolean fromString(String string) {
            if (string == null || string.equals("")) return null;
            if (string.equals("1,0")) return true;
            if (string.equals("0,1")) return false;
            return null;
        }
    };

    public class DatePickerCell<S, T> extends TableCell<Kawia, Date> {

        private DatePicker datePicker;
        private ObservableList<Kawia> birthdayData;

        public DatePickerCell(ObservableList<Kawia> listBirthdays) {

            super();

            this.birthdayData = listBirthdays;

            if (datePicker == null) {
                createDatePicker();
            }
            setGraphic(datePicker);
            setContentDisplay(ContentDisplay.GRAPHIC_ONLY);

            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    datePicker.requestFocus();
                }
            });
        }

        @Override
        public void updateItem(Date item, boolean empty) {

            super.updateItem(item, empty);

            SimpleDateFormat smp = new SimpleDateFormat("dd/MM/yyyy");

            if (null == this.datePicker) {
                System.out.println("datePicker is NULL");
            }

            if (empty) {
                setText(null);
                setGraphic(null);
            } else {

                if (isEditing()) {
                    setContentDisplay(ContentDisplay.TEXT_ONLY);

                } else {
                    setDatepikerDate(smp.format(item));
                    setText(smp.format(item));
                    setGraphic(this.datePicker);
                    setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
                }
            }
        }

        private void setDatepikerDate(String dateAsStr) {

            LocalDate ld = null;
            int jour, mois, annee;

            jour = mois = annee = 0;
            try {
                jour = Integer.parseInt(dateAsStr.substring(0, 2));
                mois = Integer.parseInt(dateAsStr.substring(3, 5));
                annee = Integer.parseInt(dateAsStr.substring(6, dateAsStr.length()));
            } catch (NumberFormatException e) {
                System.out.println("setDatepikerDate / unexpected error " + e);
            }

            ld = LocalDate.of(annee, mois, jour);
            datePicker.setValue(ld);
        }

        private void createDatePicker() {
            this.datePicker = new DatePicker();
            datePicker.setPromptText("jj/mm/aaaa");
            datePicker.setEditable(true);

            datePicker.setOnAction(new EventHandler() {
                public void handle(Event t) {
                    LocalDate date = datePicker.getValue();
                    int index = getIndex();

                    SimpleDateFormat smp = new SimpleDateFormat("dd/MM/yyyy");
                    Calendar cal = Calendar.getInstance();
                    cal.set(Calendar.DAY_OF_MONTH, date.getDayOfMonth());
                    cal.set(Calendar.MONTH, date.getMonthValue() - 1);
                    cal.set(Calendar.YEAR, date.getYear());

                    setText(smp.format(cal.getTime()));
                    commitEdit(cal.getTime());

                    if (null != getBirthdayData()) {
                        getBirthdayData().get(index).getIdMiot().setDataUrodzenia(cal.getTime());
                    }
                }
            });

            setAlignment(Pos.CENTER);
        }

        @Override
        public void startEdit() {
            super.startEdit();
        }

        @Override
        public void cancelEdit() {
            super.cancelEdit();
            setContentDisplay(ContentDisplay.TEXT_ONLY);
        }

        public ObservableList<Kawia> getBirthdayData() {
            return birthdayData;
        }

        public void setBirthdayData(ObservableList<Kawia> birthdayData) {
            this.birthdayData = birthdayData;
        }

        public DatePicker getDatePicker() {
            return datePicker;
        }

        public void setDatePicker(DatePicker datePicker) {
            this.datePicker = datePicker;
        }

    }
}
//public static class RadioButtonCell<S, T extends Boolean> extends TableCell<S, T> {
//
//    @Override
//    protected void updateItem(T item, boolean empty) {
//        super.updateItem(item, empty);
//        if (!empty) {
//            // gui setup
//            HBox hb = new HBox(7);
//            hb.setAlignment(Pos.CENTER);
//            final ToggleGroup group = new ToggleGroup();
//
//            // create a radio button for each 'element' of the enumeration
//            RadioButton male = new RadioButton("1,0");
//            male.setUserData(true);
//            male.setToggleGroup(group);
//            if (item.equals(true)) {
//                male.setSelected(true);
//            }
//
//            RadioButton female = new RadioButton("1,0");
//            female.setUserData(false);
//            female.setToggleGroup(group);
//            if (item.equals(false)) {
//                female.setSelected(false);
//            }
//
//            hb.getChildren().addAll(male, female);
//
//
//            // issue events on change of the selected radio button
//            group.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
//
//                @SuppressWarnings("unchecked")
//                @Override
//                public void changed(ObservableValue<? extends Toggle> observable,
//                                    Toggle oldValue, Toggle newValue) {
//                    getTableView().edit(getIndex(), getTableColumn());
//                    RadioButtonCell.this.commitEdit((T) newValue.getUserData());
//                }
//            });
//            setGraphic(hb);
//        }
//    }
//}
