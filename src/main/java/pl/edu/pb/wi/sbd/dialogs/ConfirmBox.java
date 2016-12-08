package pl.edu.pb.wi.sbd.dialogs;

import javafx.scene.control.Button;
import pl.edu.pb.wi.sbd.Constans;

/**
 * Created by Radosław Naruszewicz on 2016-12-08.
 */
public class ConfirmBox extends AbstractBox {

    private Button confirmButton;
    private Button cancelButton;

    static boolean answer;

    @Override
    public boolean display(String title, String message) {
        initialize(title,message);

        confirmButton = new Button();
        confirmButton.setText("Akceptuj");
        confirmButton.setOnAction(event -> {
            answer = true;
            System.out.println(Constans.CONFIRM_BUTTON);
            close();
        });

        cancelButton = new Button();
        cancelButton.setText("Cancel");
        cancelButton.setOnAction(event -> {
            answer = false;
            System.out.println(Constans.CANCEL_BUTTON);
            close();
        });

        layout.getChildren().addAll(confirmButton,cancelButton);

        window.showAndWait();
        return answer;
    }
}
