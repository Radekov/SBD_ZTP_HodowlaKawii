package pl.edu.pb.wi.sbd;

import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import pl.edu.pb.wi.sbd.database.models.*;
import pl.edu.pb.wi.sbd.database.repository.HodowlaRepository;
import pl.edu.pb.wi.sbd.database.repository.HodowlaStatusRepository;
import pl.edu.pb.wi.sbd.database.repository.KlubRepository;
import pl.edu.pb.wi.sbd.database.repository.LoginRepository;
import pl.edu.pb.wi.sbd.security.HashPassword;

import java.util.Date;

@SpringBootApplication
@ComponentScan
public class SbdSwinieApplication extends AbstractJavaFxApplicationSupport {

    @Value("${app.ui.title:Example App}")//
    private String windowTitle;

//	@Autowired
//	ProjectsView projectsView;

    /*Z samouczka
    Button button;
    Stage window;
    Scene scene1, scene2;
    */

    @Override
    public void start(Stage stage) throws Exception {
        /*Z samouczka
        window = stage;

        Label label1 = new Label("Witaj #1");
        Button button1 = new Button("Go #2");
        button1.setOnAction(e -> window.setScene(scene2));

        button = new Button();
        button.setText("Login");
        button.setOnAction(e -> {
            new AlertBox().display("Błąd", "Nie można");
        });

        Button buttonConfirmBox = new Button("Confirm");
        buttonConfirmBox.setOnAction(event ->
                {
                    boolean answer = new ConfirmBox().display("Potwierdzenie", "Czy chcesz?");
                    System.out.println(answer);
                }
        );

        Button closeProgram = new Button("Close");
        closeProgram.setOnAction(event -> window.close());


        HBox topMenu = new HBox();
        Button buttonA = new Button("File");
        Button buttonB = new Button("Edit");
        Button buttonC = new Button("View");
        TextField textField = new TextField("Bucky");

        buttonA.setOnAction(e->{
            setUserAgentStylesheet(STYLESHEET_CASPIAN);
        });

        buttonB.setOnAction(e -> {
            setUserAgentStylesheet(STYLESHEET_MODENA);
        });

        topMenu.getChildren().addAll(buttonA, buttonB, buttonC, textField);

        ChoiceBox<String> choiceBox = new ChoiceBox<String>();
        choiceBox.getItems().addAll("Tellur", "Trejn", "Holy", "Bzdura", "Welma", "Dora");
        choiceBox.setValue("Dora");
        choiceBox.getSelectionModel().selectedItemProperty()
                .addListener((observable, oldValue, newValue) -> {
                    System.out.println("Observable: " + observable + " " + observable.getValue());
                    System.out.println("Old Value: " + oldValue);
                    System.out.println("New Value: " + newValue);
                });

        ComboBox<String> comboBox = new ComboBox<>();
        comboBox.getItems().addAll("Radek", "Król Radek", "Królewicz Radek");
        comboBox.setValue("Radek");
        comboBox.setOnAction(event -> {
            System.out.println(event.getEventType());
        });

        VBox layout1 = new VBox(20);
        layout1.getChildren().addAll(label1, button1, button, buttonConfirmBox, closeProgram);
        layout1.getChildren().add(choiceBox);
        layout1.getChildren().add(comboBox);
        //layout1.getChildren().add(button);

        ListView<String> listView = new ListView<>();
        listView.getItems().addAll("Ja", "Ty", "My", "AAA", "BBB");
        listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        Button bListView = new Button("Wyplluj");
        bListView.setOnAction(e -> {
            String message = "";
            ObservableList<String> movies;
            movies = listView.getSelectionModel().getSelectedItems();
            for (String m : movies) {
                message += m + "\t";
            }
            System.out.println(message);
        });

        VBox rightLayout = new VBox(10);
        rightLayout.getChildren().addAll(listView, bListView);

        TableView<Login> table = new TableView<>();
        TableColumn<Login, Integer> idColumn= new TableColumn<>("Name");
        idColumn.setMinWidth(100);
        idColumn.setCellValueFactory(new PropertyValueFactory<Login, Integer>("idLogin"));

        TableColumn<Login, String> passwordColumn= new TableColumn<>("Password");
        passwordColumn.setMinWidth(100);
        passwordColumn.setCellValueFactory(new PropertyValueFactory<Login, String>("haslo"));

        TextField idInput= new TextField();
        idInput.setPromptText("ID");

        TextField passwordInput = new TextField();
        idInput.setPromptText("ID");

        table.setItems(getLogin());
        table.getColumns().addAll(idColumn,passwordColumn);

        VBox centerLayout = new VBox(60);
        centerLayout.getChildren().addAll(table);

        BorderPane borderPane = new BorderPane();
        borderPane.setTop(topMenu);
        borderPane.setLeft(layout1);
        borderPane.setRight(rightLayout);
        borderPane.setCenter(centerLayout);


        scene1 = new Scene(borderPane, 800, 800);
        scene1.getStylesheets().add("Custom.css");

        Button button2 = new Button("Back to #1");
        button2.setOnAction(e -> window.setScene(scene1));

        StackPane layout2 = new StackPane();
        layout2.getChildren().add(button2);
        scene2 = new Scene(layout2, 700, 400);

        window.setTitle("Title main");
        window.setScene(scene1);
        window.setOnCloseRequest(e -> {
            e.consume();
            ;
            Boolean answer = new ConfirmBox().display("Wyjście", "Czy na pewno?");
            if (answer)
                window.close();
        });
        window.show();
        */

//        setFirstValues();
//
//        stage = FXMLLoader.load(getClass().getResource("/faxml/main.fxml"));
//        stage.setResizable(true);
//        stage.centerOnScreen();
//        stage.show();

    }

    public static void main(String[] args) {
        launchApp(SbdSwinieApplication.class, args);
    }

    private void setFirstValues(){
        //Dostępny cały CRUD resztę specyficznych zapytań poszukać w poradnikach - dodawać w interfejsie
//        LoginRepository loginRepository = Context.getInstance().getBean(LoginRepository.class);
//        Login l = new Login();
//        l.setHaslo(HashPassword.get_SHA_512_SecurePassword("q"));
//        l.setNazwa("q");
//        l = loginRepository.save(l);
//
        KlubRepository klubRepository = Context.getInstance().getBean(KlubRepository.class);
        Klub k = new Klub();
        k.setKraj("Polska");
        k.setNazwa("Cavies Club of Poland");
        k = klubRepository.save(k);

        HodowlaRepository hodowlaRepository = Context.getInstance().getBean(HodowlaRepository.class);
        Hodowla h = new Hodowla();
        h.setNazwaHodowla("Świńskie Kresy");
        h.setIdKlub(k);
        h.setHaslo(HashPassword.get_SHA_512_SecurePassword("q"));
        h.setNazwa("q");
//        h.setLogin(l);
//        h.setIdHodowla(l.getIdLogin());
        System.out.println("--------------------------------"+ h);
        h = hodowlaRepository.save(h);
//
        HodowlaStatusRepository hodowlaStatusRepository = Context.getInstance().getBean(HodowlaStatusRepository.class);
        HodowlaStatus hs = new HodowlaStatus();
        hs.setHodowlaStatusPK(new HodowlaStatusPK(h.getIdHodowla(),new Date()));
        hs.setStatus("AKTYWNY");
        hs.setHodowla(h);
        hs = hodowlaStatusRepository.save(hs);
    }

    /*
    public ObservableList<Login> getLogin(){
        ObservableList<Login> logins = FXCollections.observableArrayList();
        for(int i = 0; i < 10; i++){
            Login l = new Login();
            l.setHaslo(HashPassword.get_SHA_512_SecurePassword("Dora"+i));
            logins.add(l);
        }
        LoginRepository lr = Context.getInstance().getBean(LoginRepository.class);
        for (Login l :
                lr.findAll() ) {
            logins.add(l);
        }
        return logins;
    }
*/
}
