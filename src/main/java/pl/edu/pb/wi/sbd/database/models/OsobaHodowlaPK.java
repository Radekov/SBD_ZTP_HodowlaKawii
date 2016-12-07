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
public class OsobaHodowlaPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id_osoba")
    private int idOsoba;

    @Basic(optional = false)
    @Column(name = "id_hodowla")
    private int idHodowla;

    @Basic(optional = false)
    @Column(name = "data_nadania")
    @Type(type="date")
    private Date dataNadania;

    public OsobaHodowlaPK() {
    }

    public OsobaHodowlaPK(int idOsoba, int idHodowla, Date dataNadania) {
        this.idOsoba = idOsoba;
        this.idHodowla = idHodowla;
        this.dataNadania = dataNadania;
    }

    public int getIdOsoba() {
        return idOsoba;
    }

    public void setIdOsoba(int idOsoba) {
        this.idOsoba = idOsoba;
    }

    public int getIdHodowla() {
        return idHodowla;
    }

    public void setIdHodowla(int idHodowla) {
        this.idHodowla = idHodowla;
    }

    public Date getDataNadania() {
        return dataNadania;
    }

    public void setDataNadania(Date dataNadania) {
        this.dataNadania = dataNadania;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idOsoba;
        hash += (int) idHodowla;
        hash += (dataNadania != null ? dataNadania.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OsobaHodowlaPK)) {
            return false;
        }
        OsobaHodowlaPK other = (OsobaHodowlaPK) object;
        if (this.idOsoba != other.idOsoba) {
            return false;
        }
        if (this.idHodowla != other.idHodowla) {
            return false;
        }
        if ((this.dataNadania == null && other.dataNadania != null) || (this.dataNadania != null && !this.dataNadania.equals(other.dataNadania))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.OsobaHodowlaPK[ idOsoba=" + idOsoba + ", idHodowla=" + idHodowla + ", dataNadania=" + dataNadania + " ]";
    }
    
}
