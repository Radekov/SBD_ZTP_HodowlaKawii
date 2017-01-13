package pl.edu.pb.wi.sbd.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.context.ConfigurableApplicationContext;
import pl.edu.pb.wi.sbd.Context;

import java.io.IOException;

/**
 * Created by Radosław Naruszewicz on 2017-01-05.
 */
public abstract class AbstractController implements Initializable {
    @FXML
    protected BannerController bannerController;
    protected Context CONTEXT = Context.CONTEXT;

    protected void openScene(ActionEvent event, String path){
        try {
            Parent home_page_parent = FXMLLoader.load(getClass().getResource(path));
            Scene home_page_scene = new Scene(home_page_parent);
            Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            app_stage.hide(); //optional
            app_stage.setScene(home_page_scene);
            app_stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void openWindow(String path){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(path));
        Parent root1 = null;
        try {
            System.out.println(fxmlLoader);
            root1 = (Parent) fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage stage = new Stage();
//        stage.initModality(Modality.APPLICATION_MODAL);
//        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(new Scene(root1));
        stage.setResizable(true);
        stage.centerOnScreen();
        initData(fxmlLoader);

        stage.showAndWait();
    }
    abstract protected void initData(FXMLLoader fxmlLoader);
}
