/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.edu.pb.wi.sbd.database.models;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author R
 */
@Entity
@Table(name = "MILOSNIK")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Milosnik.findAll", query = "SELECT m FROM Milosnik m")
    , @NamedQuery(name = "Milosnik.findByIdMilosnik", query = "SELECT m FROM Milosnik m WHERE m.idMilosnik = :idMilosnik")
    , @NamedQuery(name = "Milosnik.findByDataNadania", query = "SELECT m FROM Milosnik m WHERE m.dataNadania = :dataNadania")
    , @NamedQuery(name = "Milosnik.findByAktywnosc", query = "SELECT m FROM Milosnik m WHERE m.aktywnosc = :aktywnosc")})
public class Milosnik implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_milosnik")
    private Integer idMilosnik;

    @Type(type="date")
    @Column(name = "data_nadania")
    private Date dataNadania;
    @Column(name = "aktywnosc")
    private Integer aktywnosc;
    @JoinColumn(name = "id_osoba", referencedColumnName = "id_osoba")
    @ManyToOne
    private Osoba idOsoba;
    @JoinColumn(name = "id_milosnik", referencedColumnName = "id_login", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Login login;

    public Milosnik() {
    }

    public Milosnik(Integer idMilosnik) {
        this.idMilosnik = idMilosnik;
    }

    public Integer getIdMilosnik() {
        return idMilosnik;
    }

    public void setIdMilosnik(Integer idMilosnik) {
        this.idMilosnik = idMilosnik;
    }

    public Date getDataNadania() {
        return dataNadania;
    }

    public void setDataNadania(Date dataNadania) {
        this.dataNadania = dataNadania;
    }

    public Integer getAktywnosc() {
        return aktywnosc;
    }

    public void setAktywnosc(Integer aktywnosc) {
        this.aktywnosc = aktywnosc;
    }

    public Osoba getIdOsoba() {
        return idOsoba;
    }

    public void setIdOsoba(Osoba idOsoba) {
        this.idOsoba = idOsoba;
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMilosnik != null ? idMilosnik.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Milosnik)) {
            return false;
        }
        Milosnik other = (Milosnik) object;
        if ((this.idMilosnik == null && other.idMilosnik != null) || (this.idMilosnik != null && !this.idMilosnik.equals(other.idMilosnik))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Milosnik[ idMilosnik=" + idMilosnik + " ]";
    }
    
}
