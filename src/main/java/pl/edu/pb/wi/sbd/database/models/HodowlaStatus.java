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
@Table(name = "HODOWLA_STATUS")
@XmlRootElement
//TODO zmienieć mapowanie, dwa Klucze Obce: id_Hodowla, Data - dodać HodowlaStatusPK
public class HodowlaStatus implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected HodowlaStatusPK hodowlaStatusPK;
    @Column(name = "status")
    private String status;

    @JoinColumn(name = "id_hodowla", referencedColumnName = "id_hodowla", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Hodowla hodowla;

    public HodowlaStatus() {
    }

    public HodowlaStatus(HodowlaStatusPK hodowlaStatusPK) {
        this.hodowlaStatusPK = hodowlaStatusPK;
    }

    public HodowlaStatus (Integer idHodowla, Date date){
        hodowlaStatusPK = new HodowlaStatusPK(idHodowla,date);
    }

    public HodowlaStatusPK getHodowlaStatusPK() {
        return hodowlaStatusPK;
    }

    public void setHodowlaStatusPK(HodowlaStatusPK hodowlaStatusPK) {
        this.hodowlaStatusPK = hodowlaStatusPK;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    public Hodowla getHodowla() {
        return hodowla;
    }

    public void setHodowla(Hodowla hodowla) {
        this.hodowla = hodowla;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (hodowlaStatusPK != null ? hodowlaStatusPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HodowlaStatus)) {
            return false;
        }
        HodowlaStatus other = (HodowlaStatus) object;
        if ((this.hodowlaStatusPK == null && other.hodowlaStatusPK != null) || (this.hodowlaStatusPK != null && !this.hodowlaStatusPK.equals(other.hodowlaStatusPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.HodowlaStatus[ idHodowla=" + hodowlaStatusPK + " ]";
    }
    
}
