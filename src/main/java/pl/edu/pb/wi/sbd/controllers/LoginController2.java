package pl.edu.pb.wi.sbd.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.springframework.stereotype.Controller;
import pl.edu.pb.wi.sbd.database.models.Login;
import pl.edu.pb.wi.sbd.database.repository.LoginRepository;
import pl.edu.pb.wi.sbd.security.HashPassword;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Radosław Naruszewicz on 2017-01-05.
 */
@Controller
public class LoginController2 extends AbstractController {
    @FXML // fx:id="statement_login"
    private Label statement_login;

    @FXML // fx:id="statement_password"
    private Label statement_password;

    @FXML // fx:id="field_login"
    private TextField field_login;

    @FXML // fx:id="field_password"
    private PasswordField field_password;

    @FXML // fx:id="button_login"
    private Button button_login;

    private Login result;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println(this.getClass().getSimpleName() + " initialize");
        hideStatements();
        bannerController.setVisibleLogoImageHodowla(false);
    }

    @FXML
    void loginActionClick(ActionEvent event) {
        System.out.println(this.getClass().getSimpleName() + " loginActionClick");
        String login = field_login.getText();
        String password = field_password.getText();
        boolean isEmpty = false;
        if (login == null || login.equals("")) {
            System.out.println("Login is null");
            statement_login.setVisible(true);
            isEmpty = true;
        }
        if (password == null || password.equals("")) {
            System.out.println("Password is null");
            statement_password.setVisible(true);
            isEmpty = true;
        }
        if (isEmpty) return;
        hideStatements();
        switch (validateUser(login, HashPassword.get_SHA_512_SecurePassword(password))) {
            case BAD_LOGIN:
                statement_login.setVisible(true);
                break;
            case BAD_PASSWORD:
                statement_password.setVisible(true);
                break;
            case GOOD_LOGIN:

                openScene(event,"/fxml/main.fxml");
        }
    }

    private void hideStatements() {
        statement_login.setVisible(false);
        statement_password.setVisible(false);
    }

    @Override
    protected void initData(FXMLLoader fxmlLoader) {

    }

    private enum Validate {
        GOOD_LOGIN, BAD_LOGIN, BAD_PASSWORD
    }

    private Validate validateUser(String login, String password) {
        Validate validate = Validate.GOOD_LOGIN;
        LoginRepository loginRepository = CONTEXT.getInstance().getBean(LoginRepository.class);
        result = loginRepository.findByNazwa(login);
        if (result == null) {
            System.out.println("Nick: " + login + " not exists.");
            validate = Validate.BAD_LOGIN;
            return validate;
        }
        if (!password.equals(result.getHaslo())) {
            System.out.println("Bad password for " + login);
            validate = Validate.BAD_PASSWORD;
            return validate;
        }
        System.out.println("Logged " + login);
        CONTEXT.setLogged(result);
        return validate;
    }
    @Override
    protected void addControls() {

    }

}
