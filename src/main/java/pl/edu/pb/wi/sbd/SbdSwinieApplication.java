package pl.edu.pb.wi.sbd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import javafx.scene.Scene;
import javafx.stage.Stage;
import pl.edu.pb.wi.sbd.database.models.Login;
import pl.edu.pb.wi.sbd.database.services.LoginServiceImpl;

@SpringBootApplication
@ComponentScan
public class SbdSwinieApplication extends AbstractJavaFxApplicationSupport{

	@Value("${app.ui.title:Example App}")//
	private String windowTitle;

//	@Autowired
//	ProjectsView projectsView;

	@Autowired
	LoginServiceImpl service;

	@Override
	public void start(Stage stage) throws Exception {

		stage.setTitle(windowTitle);
//		stage.setScene(new Scene(projectsView.getView()));

		stage.setResizable(true);
		stage.centerOnScreen();
		stage.show();

		Login l = new Login();
		l.setNazwa("po");
		l.setHaslo("po");
		System.out.println("--------------------------------");
		System.out.println(service.getLoginRepository());
		service.getLoginRepository().save(l);
	}

	public static void main(String[] args) {
		launchApp(SbdSwinieApplication.class, args);

	}
}
