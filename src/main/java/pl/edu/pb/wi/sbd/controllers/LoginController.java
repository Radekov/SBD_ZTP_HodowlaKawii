package pl.edu.pb.wi.sbd.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Controller;
import pl.edu.pb.wi.sbd.Context;
import pl.edu.pb.wi.sbd.SbdSwinieApplication;
import pl.edu.pb.wi.sbd.database.models.Hodowla;
import pl.edu.pb.wi.sbd.database.models.Login;
import pl.edu.pb.wi.sbd.database.models.Milosnik;
import pl.edu.pb.wi.sbd.database.models.Zarzad;
import pl.edu.pb.wi.sbd.database.repository.LoginRepository;
import pl.edu.pb.wi.sbd.dialogs.AlertBox;
import pl.edu.pb.wi.sbd.security.HashPassword;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Radosław Naruszewicz on 2016-12-07.
 */
//Dlaczego Controller
//http://stackoverflow.com/questions/6827752/whats-the-difference-between-component-repository-service-annotations-in
    //NIEUZYWANE
public class LoginController implements Initializable {

    @FXML
    Button button;
    @FXML
    TextField loginField;
    @FXML
    PasswordField passwordField;
    @FXML
    Label errorLabel;

    boolean continu = true;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

//        Alert alert = new Alert(Alert.AlertType.INFORMATION);
//        alert.setTitle("Błąd");
//        alert.setHeaderText("Brak wybranej osoby");
//        alert.showAndWait();
        loginField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!continu && newValue.length() > 0) {
                setColor(loginField, "white");
            }
        });
        passwordField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!continu && newValue.length() > 0) {
                setColor(passwordField, "white");
            }
        });
        setColor(errorLabel, "red");
        errorLabel.setVisible(false);
    }

    public void loginActionClick() {
        errorLabel.setVisible(false);
        String login = loginField.getText();
        String pass = passwordField.getText();
        continu = true;
        String message = "Uzupełnij brakujące pola";
        if (login.length() <= 0) {
            System.out.println("Brakuje nicku");
            setColor(loginField, "red");
            continu = false;
        }
        if (pass.length() <= 0) {
            System.out.println("Brakuje hasła");
            setColor(passwordField, "red");
            continu = false;
        }

        if (continu)
            loginToApp(login, pass);
        else {
            setErrotText(message);
        }
    }

    private void loginToApp(String nick, String pass) {
        LoginRepository loginRepository = Context.getInstance().getBean(LoginRepository.class);
        Login result = loginRepository.findByNazwa(nick);
        if (result == null) {
            System.out.println("Nick: " + nick + " nie istnieje.");
//            new AlertBox().display("Nie udane logowanie", "Nick: " + nick + " nie istnieje.");
            setColor(loginField, "red");
            setErrotText("Nie znaleziono loginu");
            return;
        }
        String hashPass = HashPassword.get_SHA_512_SecurePassword(pass);
        if (!hashPass.equals(result.getHaslo())) {
//            new AlertBox().display("Nie udane logowanie", "Nie prawidłowe hasło");
            setErrotText("Nie prawidłowe hasło");
            return;
        }
        System.out.println("Zalogowano");
//        Context.setLogged(result);

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/faxml/userController.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
//            Stage stage = SbdSwinieApplication.getWindow();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1,1280,900));
            stage.setResizable(true);
            stage.centerOnScreen();
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setColor(Control view, String color) {
        view.setStyle("-fx-background-color: " + color + ";");
    }

    private void setErrotText(String message) {
        errorLabel.setVisible(true);
        errorLabel.setText(message);
    }

}
