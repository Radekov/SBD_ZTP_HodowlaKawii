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
@Table(name = "KLUB")
@XmlRootElement
public class Klub implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_klub")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idKlub;
    @Basic(optional = false)
    @Column(name = "kraj")
    private String kraj;
    @Basic(optional = false)
    @Column(name = "nazwa")
    private String nazwa;
    @OneToMany(mappedBy = "idKlub")
    private Collection<Hodowla> hodowlaCollection;

    public Klub() {
    }

    public Klub(Integer idKlub) {
        this.idKlub = idKlub;
    }

    public Klub(Integer idKlub, String kraj, String nazwa) {
        this.idKlub = idKlub;
        this.kraj = kraj;
        this.nazwa = nazwa;
    }

    public Integer getIdKlub() {
        return idKlub;
    }

    public void setIdKlub(Integer idKlub) {
        this.idKlub = idKlub;
    }

    public String getKraj() {
        return kraj;
    }

    public void setKraj(String kraj) {
        this.kraj = kraj;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    @XmlTransient
    public Collection<Hodowla> getHodowlaCollection() {
        return hodowlaCollection;
    }

    public void setHodowlaCollection(Collection<Hodowla> hodowlaCollection) {
        this.hodowlaCollection = hodowlaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idKlub != null ? idKlub.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Klub)) {
            return false;
        }
        Klub other = (Klub) object;
        if ((this.idKlub == null && other.idKlub != null) || (this.idKlub != null && !this.idKlub.equals(other.idKlub))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Klub[ idKlub=" + idKlub + " ]";
    }
    
}
