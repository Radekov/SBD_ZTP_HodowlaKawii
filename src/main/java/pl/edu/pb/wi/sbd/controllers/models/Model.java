package pl.edu.pb.wi.sbd.controllers.models;

import pl.edu.pb.wi.sbd.database.models.*;

/**
 * Created by Radosław Naruszewicz on 2017-01-16.
 */
public class Model {
    Integer id;
    String login;
    TypeUser kind;
    String status;
    String fname;
    String lname;
    String phone;
    String adress;
    String street;

    public Model(Login l) {
        id = l.getIdLogin();
        login = l.getNazwa();
        status = l.getStatus();
        kind = l.getType();

        Osoba o = l.getIdOsoba();
        if (o != null) {
            fname = o.getImie();
            lname = o.getNazwisko();
            phone = o.getTelefon();
            adress = o.getMiasto() + " " + o.getKodPocztowy();
            street = o.getUlica();
        }
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public TypeUser getKind() {
        return kind;
    }

    public void setKind(TypeUser kind) {
        this.kind = kind;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }
}

