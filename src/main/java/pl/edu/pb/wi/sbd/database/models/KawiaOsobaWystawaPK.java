/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.edu.pb.wi.sbd.database.models;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 *
 * @author R
 */
@Embeddable
public class KawiaOsobaWystawaPK implements Serializable {

    @Column(name = "id_kawia")
    private Integer idKawia;
    @Column(name = "id_osoba")
    private Integer idOsoba;
    @Column(name = "id_wystawa")
    private Integer idWystawa;

    public KawiaOsobaWystawaPK() {
    }

    public KawiaOsobaWystawaPK(Integer idKawia, Integer idOsoba, Integer idWystawa) {
        this.idKawia = idKawia;
        this.idOsoba = idOsoba;
        this.idWystawa = idWystawa;
    }

    public Integer getIdKawia() {
        return idKawia;
    }

    public void setIdKawia(Integer idKawia) {
        this.idKawia = idKawia;
    }

    public Integer getIdOsoba() {
        return idOsoba;
    }

    public void setIdOsoba(Integer idOsoba) {
        this.idOsoba = idOsoba;
    }

    public Integer getIdWystawa() {
        return idWystawa;
    }

    public void setIdWystawa(Integer idWystawa) {
        this.idWystawa = idWystawa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idKawia != null ? idKawia.hashCode() : 0);
        hash += (idOsoba != null ? idOsoba.hashCode() : 0);
        hash += (idWystawa != null ? idWystawa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof KawiaOsobaWystawaPK)) {
            return false;
        }
        KawiaOsobaWystawaPK other = (KawiaOsobaWystawaPK) object;
        if ((this.idKawia == null && other.idKawia != null) || (this.idKawia != null && !this.idKawia.equals(other.idKawia))) {
            return false;
        }
        if ((this.idOsoba == null && other.idOsoba != null) || (this.idOsoba != null && !this.idOsoba.equals(other.idOsoba))) {
            return false;
        }
        if ((this.idWystawa == null && other.idWystawa != null) || (this.idWystawa != null && !this.idWystawa.equals(other.idWystawa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.KawiaOsobaWystawaPK[ idKawia=" + idKawia + ", idOsoba=" + idOsoba + ", idWystawa=" + idWystawa + " ]";
    }
    
}
