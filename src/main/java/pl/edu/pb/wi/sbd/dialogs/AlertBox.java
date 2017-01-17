package pl.edu.pb.wi.sbd.dialogs;

import javafx.scene.control.Button;
import pl.edu.pb.wi.sbd.Constans;

/**
 * Created by Radosław Naruszewicz on 2016-12-08.
 */
public class AlertBox extends AbstractBox {

    private Button closeButton;

    @Override
    public boolean display(String title, String message) {
        initialize(title, message);

        closeButton = new Button(Constans.CONFIRM_BUTTON);
        closeButton.setOnAction(e -> close());

//        VBox layout = new VBox(10);
        layout.getChildren().addAll(closeButton);
//        layout.setAlignment(Pos.CENTER);

//        Scene scene = new Scene(layout);
//        window.setScene(scene);
        window.showAndWait();
        return false;
    }
}
