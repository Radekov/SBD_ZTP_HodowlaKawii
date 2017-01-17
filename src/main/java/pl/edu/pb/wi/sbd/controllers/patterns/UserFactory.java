package pl.edu.pb.wi.sbd.controllers.patterns;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import pl.edu.pb.wi.sbd.Context;
import pl.edu.pb.wi.sbd.controllers.AbstractWindowController;
import pl.edu.pb.wi.sbd.controllers.BannerController;
import pl.edu.pb.wi.sbd.database.models.Login;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Radosław Naruszewicz on 2017-01-17.
 */
public abstract class UserFactory {
    protected HBox header;
    protected HBox panel;
    protected Label kind, name, status;
    protected BannerController toolbar;
    protected List<Labeled> labeleds = new ArrayList<>();
    protected Login l;
    protected AbstractWindowController awc;

    protected UserFactory(AbstractWindowController awc, BannerController toolbarController){
        panel = new HBox();
        header = new HBox();
        kind = new Label();
        name = new Label();
        status = new Label();
        this.toolbar = toolbarController;
        l = Context.CONTEXT.getLogged();
        this.awc=awc;
    }

    public abstract void createButtons();
    public abstract void createCash();

    public void createHeader(){
        addButtonToLabel();
    }
    protected void addButtonToLabel(){
        Button b = new Button("Wyloguj");
        b.setOnAction(e->{
            awc.unregister();
            Context.CONTEXT.setLogged(null);
            openScene(e,"/fxml/login.fxml");
        });
        labeleds.add(b);
        addToHBoxAndSet(header,b);
    }
    //FIXME
    public void createToolbar(){
        toolbar.setVisibleLogoImageHodowla(true);
    }

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

        stage.showAndWait();
    }

    protected void addToHBoxAndSet(HBox hBox, Labeled... labeleds){
        for (Labeled l:labeleds
             ) {
            this.labeleds.add(l);
            hBox.getChildren().addAll(l);
            System.out.println(l);
        }
    }

    public HBox getHeader() {
        return header;
    }

    public HBox getPanel() {
        return panel;
    }
}
