package pl.edu.pb.wi.sbd;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * Created by Radosław Naruszewicz on 2016-12-07.
 */
public class Context {
    private static ConfigurableApplicationContext context;

    private Context() {
    }

    public static ConfigurableApplicationContext getInstance() {
        if (context == null) {
            context = SpringApplication.run(SbdSwinieApplication.class);
        }
        return context;
    }
}
