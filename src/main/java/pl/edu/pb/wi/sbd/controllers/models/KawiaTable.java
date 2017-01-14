package pl.edu.pb.wi.sbd.controllers.models;

import javafx.beans.property.SimpleStringProperty;
import pl.edu.pb.wi.sbd.database.models.Kawia;

/**
 * Created by Radosław Naruszewicz on 2016-12-11.
 */
public class KawiaTable{
    private SimpleStringProperty imie = new SimpleStringProperty();
    private SimpleStringProperty nrIndywidualny = new SimpleStringProperty();
    private SimpleStringProperty plec = new SimpleStringProperty();
    private SimpleStringProperty rasa = new SimpleStringProperty();
    private SimpleStringProperty przydomek = new SimpleStringProperty();

    public KawiaTable(Kawia k){
        setPrzydomek(k);
        setRasa(k);
        setImie(k);
        setNrIndywidualny(k);
        setPlec(k);
    }

    public String getRasa() {
        return rasa.get();
    }

    public SimpleStringProperty rasaProperty() {
        return rasa;
    }

    public void setRasa(Kawia k) {
        this.rasa.set(k.getIdRasa().getRasa());
    }

    public String getPrzydomek() {
        return przydomek.get();
    }

    public SimpleStringProperty przydomekProperty() {
        return przydomek;
    }

    public void setPrzydomek(Kawia k) {
        this.przydomek.set(k.getIdMiot().getIdHodowla().getNazwa());
    }

    public String getImie() {
        return imie.get();
    }

    public SimpleStringProperty imieProperty() {
        return imie;
    }

    public void setImie(Kawia k) {
        this.imie.set(k.getImie());
    }

    public String getNrIndywidualny() {
        return nrIndywidualny.get();
    }

    public SimpleStringProperty nrIndywidualnyProperty() {
        return nrIndywidualny;
    }

    public void setNrIndywidualny(Kawia k) {
        this.nrIndywidualny.set(k.getNrIndywidualny());
    }

    public String getPlec() {
        return plec.get();
    }

    public SimpleStringProperty plecProperty() {
        return plec;
    }

    public void setPlec(Kawia k) {
        String plec = k.getPlec()?"10":"01";
        this.plec.set(plec);
    }

    public void setPrzydomek(String przydomek) {
        this.przydomek.set(przydomek);
    }
}
