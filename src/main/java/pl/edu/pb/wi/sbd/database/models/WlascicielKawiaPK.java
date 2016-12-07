/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.edu.pb.wi.sbd.database.models;

import org.hibernate.annotations.Type;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author R
 */
@Embeddable
public class WlascicielKawiaPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id_kawia")
    private int idKawia;

    @Basic(optional = false)
    @Column(name = "id_osoba")
    private int idOsoba;

    @Basic(optional = false)
    @Column(name = "data_zakupu")
    @Type(type="date")
    private Date dataZakupu;

    public WlascicielKawiaPK() {
    }

    public WlascicielKawiaPK(int idKawia, int idOsoba, Date dataZakupu) {
        this.idKawia = idKawia;
        this.idOsoba = idOsoba;
        this.dataZakupu = dataZakupu;
    }

    public int getIdKawia() {
        return idKawia;
    }

    public void setIdKawia(int idKawia) {
        this.idKawia = idKawia;
    }

    public int getIdOsoba() {
        return idOsoba;
    }

    public void setIdOsoba(int idOsoba) {
        this.idOsoba = idOsoba;
    }

    public Date getDataZakupu() {
        return dataZakupu;
    }

    public void setDataZakupu(Date dataZakupu) {
        this.dataZakupu = dataZakupu;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idKawia;
        hash += (int) idOsoba;
        hash += (dataZakupu != null ? dataZakupu.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof WlascicielKawiaPK)) {
            return false;
        }
        WlascicielKawiaPK other = (WlascicielKawiaPK) object;
        if (this.idKawia != other.idKawia) {
            return false;
        }
        if (this.idOsoba != other.idOsoba) {
            return false;
        }
        if ((this.dataZakupu == null && other.dataZakupu != null) || (this.dataZakupu != null && !this.dataZakupu.equals(other.dataZakupu))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.WlascicielKawiaPK[ idKawia=" + idKawia + ", idOsoba=" + idOsoba + ", dataZakupu=" + dataZakupu + " ]";
    }
    
}
