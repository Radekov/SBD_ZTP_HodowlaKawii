package pl.edu.pb.wi.sbd.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.hibernate.annotations.SourceType;
import org.springframework.stereotype.Controller;
import pl.edu.pb.wi.sbd.Context;
import pl.edu.pb.wi.sbd.database.models.Login;
import pl.edu.pb.wi.sbd.database.repository.LoginRepository;
import pl.edu.pb.wi.sbd.dialogs.AlertBox;
import pl.edu.pb.wi.sbd.security.HashPassword;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Radosław Naruszewicz on 2016-12-07.
 */
//Dlaczego Controller
//http://stackoverflow.com/questions/6827752/whats-the-difference-between-component-repository-service-annotations-in
@Controller
public class LoginController implements Initializable {

    @FXML
    Button button;
    @FXML
    TextField loginField;
    @FXML
    PasswordField passwordField;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void loginActionClick() {
        String login = loginField.getText();
        String pass = passwordField.getText();
        boolean continu = true;
        if(login.length() <= 0){
            System.out.println("Brakuje nicku");
            continu = false;
        }
        if(pass.length() <= 0){
            System.out.println("Brakuje hasła");
            continu = false;
        }

        if(continu)
            loginToApp(login,pass);
    }

    private void loginToApp(String nick, String pass) {
        LoginRepository loginRepository = Context.getInstance().getBean(LoginRepository.class);
        Login result = loginRepository.findByNazwa(nick);
        if (result == null) {
            System.out.println("Nick: " + nick + " nie istnieje.");
            new AlertBox().display("Nie udane logowanie", "Nick: " + nick + " nie istnieje.");
            return;
        }
        String hashPass = HashPassword.get_SHA_512_SecurePassword(pass);
        if(!hashPass.equals(result.getHaslo())){
            System.out.println("Nick: " + nick + " nie istnieje.");
            new AlertBox().display("Nie udane logowanie", "Nie prawidłowe hasło");
            return;
        }
        //TODO ustawić w Contexcie aplikacji, że człek zalogowany
        System.out.println("Zalogowano");
    }

}
