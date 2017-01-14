package pl.edu.pb.wi.sbd;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import pl.edu.pb.wi.sbd.database.models.Hodowla;
import pl.edu.pb.wi.sbd.database.models.HodowlaStatus;
import pl.edu.pb.wi.sbd.database.models.HodowlaStatusPK;
import pl.edu.pb.wi.sbd.database.models.Klub;
import pl.edu.pb.wi.sbd.database.repository.HodowlaRepository;
import pl.edu.pb.wi.sbd.database.repository.HodowlaStatusRepository;
import pl.edu.pb.wi.sbd.database.repository.KawiaRepository;
import pl.edu.pb.wi.sbd.database.repository.KlubRepository;
import pl.edu.pb.wi.sbd.security.HashPassword;

import java.util.Date;

@SpringBootApplication
@ComponentScan
public class SbdSwinieApplication extends AbstractJavaFxApplicationSupport {

    @Value("${app.ui.title:Example App}")//
    private String windowTitle;

    private static Stage window;

    @Override
    public void start(Stage stage) throws Exception {
//        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/login.fxml"));
        Scene scene = new Scene(root);
        stage.setResizable(true);
        stage.centerOnScreen();
        stage.setScene(scene);
        stage.show();
        window = stage;
//        setFirstValues();

        KawiaRepository kawiaRepository = Context.getInstance().getBean(KawiaRepository.class);
        kawiaRepository.findByPlec(true);
    }

    public static void main(String[] args) {
        launchApp(SbdSwinieApplication.class, args);
    }

    private void setFirstValues(){
        KlubRepository klubRepository = Context.getInstance().getBean(KlubRepository.class);
        Klub k = new Klub();
        k.setKraj("Polska");
        k.setNazwa("Cavies Club of Poland");
        k = klubRepository.save(k);

        HodowlaRepository hodowlaRepository = Context.getInstance().getBean(HodowlaRepository.class);
        Hodowla h = new Hodowla();
        h.setNazwaHodowla("Świńskie Kresy");
        h.setIdKlub(k);
        h.setHaslo(HashPassword.get_SHA_512_SecurePassword("q"));
        h.setNazwa("q");
        System.out.println("--------------------------------"+ h);
        h = hodowlaRepository.save(h);

        HodowlaStatusRepository hodowlaStatusRepository = Context.getInstance().getBean(HodowlaStatusRepository.class);
        HodowlaStatus hs = new HodowlaStatus();
        hs.setHodowlaStatusPK(new HodowlaStatusPK(h.getIdHodowla(),new Date()));
        hs.setStatus("AKTYWNY");
        hs.setHodowla(h);
        hs = hodowlaStatusRepository.save(hs);
    }
}
//Albinos Białe Czarne Czerwone Czekoladowe Sepia Beżowe Szafran Kremowe Buff Lila Złote Slate blue Tricolor (tri) Roan Brindle Dalmatian Himalaya Agouti Solid
//Argente Tortoiseshell Tortoiseshell z białym Tan Fox Lux Dutch Satin Siml

//American Abyssinian Crested
//White Crested
/*Teddy
Rex
Ridgeback
Crested Ridgeback
Curly
KHP
Skinny
Baldwin
Peruwianka
Boucle
Sheltie
Texel
Coronet
Merino
Angora
Moher
Lunkarya
* */
