package pl.edu.pb.wi.sbd;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import pl.edu.pb.wi.sbd.database.models.Login;

/**
 * Created by Radosław Naruszewicz on 2016-12-07.
 */
public class Context {
    private static ConfigurableApplicationContext context;
    public static Context CONTEXT = new Context();

    private Login logged = null;

    private Context() {
    }

    public static ConfigurableApplicationContext getInstance() {
        if (context == null) {
            context = SpringApplication.run(SbdSwinieApplication.class);
        }
        return context;
    }

    public Login getLogged() {
        return logged;
    }

    public void setLogged(Login logged) {
        logged = logged;
    }
}
