package pl.edu.pb.wi.sbd.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import org.springframework.context.ConfigurableApplicationContext;
import pl.edu.pb.wi.sbd.Context;

/**
 * Created by Radosław Naruszewicz on 2017-01-05.
 */
public abstract class AbstractController implements Initializable {
    @FXML
    protected BannerController bannerController;
    protected Context CONTEXT = Context.CONTEXT;
}
