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
import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author R
 */
@Entity
@Table(name = "WLASCICIEL_KAWIA")
@XmlRootElement
public class WlascicielKawia implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected WlascicielKawiaPK wlascicielKawiaPK;

    @Type(type="date")
    @Column(name = "data_zwrotu")
    private Date dataZwrotu;

    @Column(name = "kwota")
    private BigDecimal kwota;

    @JoinColumn(name = "id_osoba", referencedColumnName = "id_osoba", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Osoba osoba;

    @JoinColumn(name = "id_kawia", referencedColumnName = "id_kawia", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Kawia kawia;

    public WlascicielKawia() {
    }

    public WlascicielKawia(WlascicielKawiaPK wlascicielKawiaPK) {
        this.wlascicielKawiaPK = wlascicielKawiaPK;
    }

    public WlascicielKawia(int idKawia, int idOsoba, Date dataZakupu) {
        this.wlascicielKawiaPK = new WlascicielKawiaPK(idKawia, idOsoba, dataZakupu);
    }

    public WlascicielKawiaPK getWlascicielKawiaPK() {
        return wlascicielKawiaPK;
    }

    public void setWlascicielKawiaPK(WlascicielKawiaPK wlascicielKawiaPK) {
        this.wlascicielKawiaPK = wlascicielKawiaPK;
    }

    public Date getDataZwrotu() {
        return dataZwrotu;
    }

    public void setDataZwrotu(Date dataZwrotu) {
        this.dataZwrotu = dataZwrotu;
    }

    public BigDecimal getKwota() {
        return kwota;
    }

    public void setKwota(BigDecimal kwota) {
        this.kwota = kwota;
    }

    public Osoba getOsoba() {
        return osoba;
    }

    public void setOsoba(Osoba osoba) {
        this.osoba = osoba;
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
        hash += (wlascicielKawiaPK != null ? wlascicielKawiaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof WlascicielKawia)) {
            return false;
        }
        WlascicielKawia other = (WlascicielKawia) object;
        if ((this.wlascicielKawiaPK == null && other.wlascicielKawiaPK != null) || (this.wlascicielKawiaPK != null && !this.wlascicielKawiaPK.equals(other.wlascicielKawiaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.WlascicielKawia[ wlascicielKawiaPK=" + wlascicielKawiaPK + " ]";
    }
    
}
