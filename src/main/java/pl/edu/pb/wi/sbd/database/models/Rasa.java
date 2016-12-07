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
@Table(name = "RASA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Rasa.findAll", query = "SELECT r FROM Rasa r")
    , @NamedQuery(name = "Rasa.findByIdRasa", query = "SELECT r FROM Rasa r WHERE r.idRasa = :idRasa")
    , @NamedQuery(name = "Rasa.findByRasa", query = "SELECT r FROM Rasa r WHERE r.rasa = :rasa")
    , @NamedQuery(name = "Rasa.findByMasc", query = "SELECT r FROM Rasa r WHERE r.masc = :masc")})
public class Rasa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_rasa")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idRasa;

    @Column(name = "rasa")
    private String rasa;

    @Column(name = "masc")
    private String masc;

    @ManyToMany(mappedBy = "rasaCollection")
    private Collection<Hodowla> hodowlaCollection;

    @OneToMany(mappedBy = "idRasa")
    private Collection<Kawia> kawiaCollection;

    public Rasa() {
    }

    public Rasa(Integer idRasa) {
        this.idRasa = idRasa;
    }

    public Integer getIdRasa() {
        return idRasa;
    }

    public void setIdRasa(Integer idRasa) {
        this.idRasa = idRasa;
    }

    public String getRasa() {
        return rasa;
    }

    public void setRasa(String rasa) {
        this.rasa = rasa;
    }

    public String getMasc() {
        return masc;
    }

    public void setMasc(String masc) {
        this.masc = masc;
    }

    @XmlTransient
    public Collection<Hodowla> getHodowlaCollection() {
        return hodowlaCollection;
    }

    public void setHodowlaCollection(Collection<Hodowla> hodowlaCollection) {
        this.hodowlaCollection = hodowlaCollection;
    }

    @XmlTransient
    public Collection<Kawia> getKawiaCollection() {
        return kawiaCollection;
    }

    public void setKawiaCollection(Collection<Kawia> kawiaCollection) {
        this.kawiaCollection = kawiaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRasa != null ? idRasa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rasa)) {
            return false;
        }
        Rasa other = (Rasa) object;
        if ((this.idRasa == null && other.idRasa != null) || (this.idRasa != null && !this.idRasa.equals(other.idRasa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Rasa[ idRasa=" + idRasa + " ]";
    }
    
}
