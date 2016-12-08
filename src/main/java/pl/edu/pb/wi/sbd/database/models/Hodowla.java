package pl.edu.pb.wi.sbd.database.models;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.Collection;

/**
 *
 * @author R
 */
@Entity
@Table(name = "HODOWLA")
@XmlRootElement
public class Hodowla implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_hodowla")
    private Integer idHodowla;

    @JoinTable(name = "HODOWLA_KAWIA", joinColumns = {
        @JoinColumn(name = "id_hodowla", referencedColumnName = "id_hodowla")}, inverseJoinColumns = {
        @JoinColumn(name = "id_kawia", referencedColumnName = "id_kawia")})
    @ManyToMany
    private Collection<Kawia> kawiaCollection;

    @JoinTable(name = "HODOWLA_RASA", joinColumns = {
        @JoinColumn(name = "id_hodowla", referencedColumnName = "id_hodowla")}, inverseJoinColumns = {
        @JoinColumn(name = "id_rasa", referencedColumnName = "id_rasa")})
    @ManyToMany
    private Collection<Rasa> rasaCollection;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "hodowla")
    private HodowlaStatus hodowlaStatus;

    @OneToMany(mappedBy = "idHodowla")
    private Collection<Miot> miotCollection;

    @JoinColumn(name = "id_klub", referencedColumnName = "id_klub")
    @ManyToOne
    private Klub idKlub;

    @JoinColumn(name = "id_hodowla", referencedColumnName = "id_login", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Login login;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "hodowla")
    private Collection<OsobaHodowla> osobaHodowlaCollection;

    public Hodowla() {
    }

    public Hodowla(Integer idHodowla) {
        this.idHodowla = idHodowla;
    }

    public Integer getIdHodowla() {
        return idHodowla;
    }

    public void setIdHodowla(Integer idHodowla) {
        this.idHodowla = idHodowla;
    }

    @XmlTransient
    public Collection<Kawia> getKawiaCollection() {
        return kawiaCollection;
    }

    public void setKawiaCollection(Collection<Kawia> kawiaCollection) {
        this.kawiaCollection = kawiaCollection;
    }

    @XmlTransient
    public Collection<Rasa> getRasaCollection() {
        return rasaCollection;
    }

    public void setRasaCollection(Collection<Rasa> rasaCollection) {
        this.rasaCollection = rasaCollection;
    }

    public HodowlaStatus getHodowlaStatus() {
        return hodowlaStatus;
    }

    public void setHodowlaStatus(HodowlaStatus hodowlaStatus) {
        this.hodowlaStatus = hodowlaStatus;
    }

    @XmlTransient
    public Collection<Miot> getMiotCollection() {
        return miotCollection;
    }

    public void setMiotCollection(Collection<Miot> miotCollection) {
        this.miotCollection = miotCollection;
    }

    public Klub getIdKlub() {
        return idKlub;
    }

    public void setIdKlub(Klub idKlub) {
        this.idKlub = idKlub;
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }

    @XmlTransient
    public Collection<OsobaHodowla> getOsobaHodowlaCollection() {
        return osobaHodowlaCollection;
    }

    public void setOsobaHodowlaCollection(Collection<OsobaHodowla> osobaHodowlaCollection) {
        this.osobaHodowlaCollection = osobaHodowlaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idHodowla != null ? idHodowla.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Hodowla)) {
            return false;
        }
        Hodowla other = (Hodowla) object;
        if ((this.idHodowla == null && other.idHodowla != null) || (this.idHodowla != null && !this.idHodowla.equals(other.idHodowla))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Hodowla[ idHodowla=" + idHodowla + " ]";
    }
    
}