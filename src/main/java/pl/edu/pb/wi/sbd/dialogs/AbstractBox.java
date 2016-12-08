package pl.edu.pb.wi.sbd.dialogs;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * Created by Radosław Naruszewicz on 2016-12-08.
 */
public abstract class AbstractBox implements Box {
    protected Stage window;
    protected Label label;
    protected VBox layout;
    protected Scene scene;

    protected void initialize(String title, String message){
        window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(300);
        label = new Label();
        label.setText(message);
        layout = new VBox(10);
        layout.getChildren().add(label);
        layout.setAlignment(Pos.CENTER);
        scene = new Scene(layout);
        window.setScene(scene);
    }

    protected void close(){
        window.close();
    }


}
