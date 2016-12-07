/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.edu.pb.wi.sbd.database.models;

import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author R
 */
@Embeddable
public class WagaPK implements Serializable {

    @Column(name = "id_kawia")
    private Integer idKawia;

    @Type(type="date")
    @Column(name = "data_wazenia")
    private Date dataWazenia;

    public WagaPK() {
    }

    public WagaPK(Integer idKawia, Date dataWazenia) {
        this.idKawia = idKawia;
        this.dataWazenia = dataWazenia;
    }

    public Integer getIdKawia() {
        return idKawia;
    }

    public void setIdKawia(Integer idKawia) {
        this.idKawia = idKawia;
    }

    public Date getDataWazenia() {
        return dataWazenia;
    }

    public void setDataWazenia(Date dataWazenia) {
        this.dataWazenia = dataWazenia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idKawia != null ? idKawia.hashCode() : 0);
        hash += (dataWazenia != null ? dataWazenia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof WagaPK)) {
            return false;
        }
        WagaPK other = (WagaPK) object;
        if ((this.idKawia == null && other.idKawia != null) || (this.idKawia != null && !this.idKawia.equals(other.idKawia))) {
            return false;
        }
        if ((this.dataWazenia == null && other.dataWazenia != null) || (this.dataWazenia != null && !this.dataWazenia.equals(other.dataWazenia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.WagaPK[ idKawia=" + idKawia + ", dataWazenia=" + dataWazenia + " ]";
    }
    
}
