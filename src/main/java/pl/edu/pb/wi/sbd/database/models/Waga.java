/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.edu.pb.wi.sbd.database.models;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author R
 */
@Entity
@Table(name = "WAGA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Waga.findAll", query = "SELECT w FROM Waga w")
    , @NamedQuery(name = "Waga.findByIdKawia", query = "SELECT w FROM Waga w WHERE w.wagaPK.idKawia = :idKawia")
    , @NamedQuery(name = "Waga.findByDataWazenia", query = "SELECT w FROM Waga w WHERE w.wagaPK.dataWazenia = :dataWazenia")
    , @NamedQuery(name = "Waga.findByWaga", query = "SELECT w FROM Waga w WHERE w.waga = :waga")})
public class Waga implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected WagaPK wagaPK;

    @Column(name = "waga")
    private Double waga;

    @JoinColumn(name = "id_kawia", referencedColumnName = "id_kawia", insertable = false, updatable = false)
    @ManyToOne
    private Kawia kawia;

    public Waga() {
    }

    public Waga(WagaPK wagaPK) {
        this.wagaPK = wagaPK;
    }

    public Waga(Integer idKawia, Date dataWazenia) {
        this.wagaPK = new WagaPK(idKawia, dataWazenia);
    }

    public WagaPK getWagaPK() {
        return wagaPK;
    }

    public void setWagaPK(WagaPK wagaPK) {
        this.wagaPK = wagaPK;
    }

    public Double getWaga() {
        return waga;
    }

    public void setWaga(Double waga) {
        this.waga = waga;
    }

    public Kawia getKawia() {
        return kawia;
    }

    public void setKawia(Kawia kawia) {
        this.kawia = kawia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (wagaPK != null ? wagaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Waga)) {
            return false;
        }
        Waga other = (Waga) object;
        if ((this.wagaPK == null && other.wagaPK != null) || (this.wagaPK != null && !this.wagaPK.equals(other.wagaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Waga[ wagaPK=" + wagaPK + " ]";
    }
    
}
