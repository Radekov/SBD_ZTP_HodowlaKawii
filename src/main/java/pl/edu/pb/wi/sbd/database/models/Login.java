/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.edu.pb.wi.sbd.database.models;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * @author R
 */
@Entity
@Table(name = "LOGIN")
@XmlRootElement
public class Login implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_login")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idLogin;

    @Column(name = "nazwa", unique = true)
    private String nazwa;

    @Column(name = "haslo")
    private String haslo;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "login")
    private Hodowla hodowla;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "login")
    private Milosnik milosnik;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "login")
    private Zarzad zarzad;

    public Login() {
    }

    public Login(Integer idLogin) {
        this.idLogin = idLogin;
    }

    public Integer getIdLogin() {
        return idLogin;
    }

    public void setIdLogin(Integer idLogin) {
        this.idLogin = idLogin;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getHaslo() {
        return haslo;
    }

    public void setHaslo(String haslo) {
        this.haslo = haslo;
    }

    public Hodowla getHodowla() {
        return hodowla;
    }

    public void setHodowla(Hodowla hodowla) {
        this.hodowla = hodowla;
    }

    public Milosnik getMilosnik() {
        return milosnik;
    }

    public void setMilosnik(Milosnik milosnik) {
        this.milosnik = milosnik;
    }

    public Zarzad getZarzad() {
        return zarzad;
    }

    public void setZarzad(Zarzad zarzad) {
        this.zarzad = zarzad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLogin != null ? idLogin.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Login)) {
            return false;
        }
        Login other = (Login) object;
        if ((this.idLogin == null && other.idLogin != null) || (this.idLogin != null && !this.idLogin.equals(other.idLogin))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Login[ idLogin=" + idLogin + " ]";
    }

}
