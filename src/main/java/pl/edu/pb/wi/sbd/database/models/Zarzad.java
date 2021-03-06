/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.edu.pb.wi.sbd.database.models;

import org.hibernate.annotations.Type;
import pl.edu.pb.wi.sbd.Context;
import pl.edu.pb.wi.sbd.database.repository.KawiaRepository;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 *
 * @author R
 */
@Entity
@Table(name = "ZARZAD")
@XmlRootElement
@PrimaryKeyJoinColumn(name = "id_zarzad", referencedColumnName = "id_login")
public class Zarzad extends Login implements Serializable {

    private static final long serialVersionUID = 1L;
//    @Id
//    @Basic(optional = false)
//    @Column(name = "id_zarzad")
//    private Integer idZarzad;

    @Type(type="date")
    @Column(name = "data_nadania")
    private Date dataNadania;

    @Column(name = "status")
    private String status;

//    @JoinColumn(name = "id_osoba", referencedColumnName = "id_osoba")
//    @ManyToOne
//    private Osoba idOsoba;

//    @JoinColumn(name = "id_zarzad", referencedColumnName = "id_login", insertable = false, updatable = false)
//    @OneToOne(optional = false)
//    private Login login;

    public Zarzad() {
    }

    public Zarzad(Integer idZarzad) {
        super(idZarzad);
    }

    public Integer getIdZarzad() {
        return getIdLogin();
    }

    public void setIdZarzad(Integer idZarzad) {
        setIdLogin(idZarzad);
    }

    public Date getDataNadania() {
        return dataNadania;
    }

    public void setDataNadania(Date dataNadania) {
        this.dataNadania = dataNadania;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

//    public Osoba getIdOsoba() {
//        return idOsoba;
//    }
//
//    public void setIdOsoba(Osoba idOsoba) {
//        this.idOsoba = idOsoba;
//    }

//    public Login getLogin() {
//        return login;
//    }
//
//    public void setLogin(Login login) {
//        this.login = login;
//    }

    @Override
    public int hashCode() {
//        int hash = 0;
//        hash += (idZarzad != null ? idZarzad.hashCode() : 0);
//        return hash;
        return super.hashCode();
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Zarzad)) {
            return false;
        }
        Zarzad other = (Zarzad) object;
        if ((this.getIdLogin() == null && other.getIdLogin() != null) || (this.getIdLogin() != null && !this.getIdLogin().equals(other.getIdLogin()))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Zarzad[ idZarzad=" + getIdLogin() + " ]";
    }

    @Override
    public List<Kawia> getAllCavies() {
        KawiaRepository kawiaRepository = Context.getInstance().getBean(KawiaRepository.class);
        return kawiaRepository.findAll();
    }
}
