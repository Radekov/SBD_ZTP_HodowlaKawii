/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
@Table(name = "KAWIA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Kawia.findAll", query = "SELECT k FROM Kawia k")
    , @NamedQuery(name = "Kawia.findByIdKawia", query = "SELECT k FROM Kawia k WHERE k.idKawia = :idKawia")
    , @NamedQuery(name = "Kawia.findByNrIndywidualny", query = "SELECT k FROM Kawia k WHERE k.nrIndywidualny = :nrIndywidualny")
    , @NamedQuery(name = "Kawia.findByPlec", query = "SELECT k FROM Kawia k WHERE k.plec = :plec")})
public class Kawia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_kawia")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idKawia;

    @Column(name = "nr_indywidualny")
    private String nrIndywidualny;

    @Column(name = "plec")
    private Integer plec;

    @ManyToMany(mappedBy = "kawiaCollection")
    private Collection<Hodowla> hodowlaCollection;

    @OneToMany(mappedBy = "kawia")
    private Collection<Miot> miotCollection;

    @JoinColumn(name = "id_rasa", referencedColumnName = "id_rasa")
    @ManyToOne
    private Rasa idRasa;

    @JoinColumn(name = "id_miot", referencedColumnName = "id_miot")
    @ManyToOne
    private Miot idMiot;

    @OneToMany(mappedBy = "kawia")
    private Collection<Waga> wagaCollection;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "kawia")
    private Collection<WlascicielKawia> wlascicielKawiaCollection;

    @OneToMany(mappedBy = "kawia")
    private Collection<KawiaOsobaWystawa> kawiaOsobaWystawaCollection;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "kawia")
    private Collection<KawiaTytul> kawiaTytulCollection;

    public Kawia() {
    }

    public Kawia(Integer idKawia) {
        this.idKawia = idKawia;
    }

    public Integer getIdKawia() {
        return idKawia;
    }

    public void setIdKawia(Integer idKawia) {
        this.idKawia = idKawia;
    }

    public String getNrIndywidualny() {
        return nrIndywidualny;
    }

    public void setNrIndywidualny(String nrIndywidualny) {
        this.nrIndywidualny = nrIndywidualny;
    }

    public Integer getPlec() {
        return plec;
    }

    public void setPlec(Integer plec) {
        this.plec = plec;
    }

    @XmlTransient
    public Collection<Hodowla> getHodowlaCollection() {
        return hodowlaCollection;
    }

    public void setHodowlaCollection(Collection<Hodowla> hodowlaCollection) {
        this.hodowlaCollection = hodowlaCollection;
    }

    @XmlTransient
    public Collection<Miot> getMiotCollection() {
        return miotCollection;
    }

    public void setMiotCollection(Collection<Miot> miotCollection) {
        this.miotCollection = miotCollection;
    }

    public Rasa getIdRasa() {
        return idRasa;
    }

    public void setIdRasa(Rasa idRasa) {
        this.idRasa = idRasa;
    }

    public Miot getIdMiot() {
        return idMiot;
    }

    public void setIdMiot(Miot idMiot) {
        this.idMiot = idMiot;
    }

    @XmlTransient
    public Collection<Waga> getWagaCollection() {
        return wagaCollection;
    }

    public void setWagaCollection(Collection<Waga> wagaCollection) {
        this.wagaCollection = wagaCollection;
    }

    @XmlTransient
    public Collection<WlascicielKawia> getWlascicielKawiaCollection() {
        return wlascicielKawiaCollection;
    }

    public void setWlascicielKawiaCollection(Collection<WlascicielKawia> wlascicielKawiaCollection) {
        this.wlascicielKawiaCollection = wlascicielKawiaCollection;
    }

    @XmlTransient
    public Collection<KawiaOsobaWystawa> getKawiaOsobaWystawaCollection() {
        return kawiaOsobaWystawaCollection;
    }

    public void setKawiaOsobaWystawaCollection(Collection<KawiaOsobaWystawa> kawiaOsobaWystawaCollection) {
        this.kawiaOsobaWystawaCollection = kawiaOsobaWystawaCollection;
    }

    @XmlTransient
    public Collection<KawiaTytul> getKawiaTytulCollection() {
        return kawiaTytulCollection;
    }

    public void setKawiaTytulCollection(Collection<KawiaTytul> kawiaTytulCollection) {
        this.kawiaTytulCollection = kawiaTytulCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idKawia != null ? idKawia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Kawia)) {
            return false;
        }
        Kawia other = (Kawia) object;
        if ((this.idKawia == null && other.idKawia != null) || (this.idKawia != null && !this.idKawia.equals(other.idKawia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Kawia[ idKawia=" + idKawia + " ]";
    }
    
}
