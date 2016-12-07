package pl.edu.pb.wi.sbd;

import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import javafx.scene.Scene;
import javafx.stage.Stage;
import pl.edu.pb.wi.sbd.database.models.Login;
import pl.edu.pb.wi.sbd.database.repository.LoginRepository;
import pl.edu.pb.wi.sbd.database.services.LoginServiceImpl;

@SpringBootApplication
@ComponentScan
public class SbdSwinieApplication extends AbstractJavaFxApplicationSupport{

	@Value("${app.ui.title:Example App}")//
	private String windowTitle;

//	@Autowired
//	ProjectsView projectsView;

	Button button;

	@Override
	public void start(Stage stage) throws Exception {

		stage.setTitle(windowTitle);

		button = new Button();
		button.setText("Login");

		StackPane layout = new StackPane();
		layout.getChildren().add(button);



//		stage.setScene(new Scene(projectsView.getView()));

		//Dostępny cały CRUD resztę specyficznych zapytań poszukać w poradnikach
		LoginRepository loginRepository = Context.getInstance().getBean(LoginRepository.class);
		//Nie zwraca null
		System.out.println(loginRepository);

		stage.setResizable(true);
		stage.centerOnScreen();
		stage.show();

	}



	public static void main(String[] args) {
		launchApp(SbdSwinieApplication.class, args);

	}
}
