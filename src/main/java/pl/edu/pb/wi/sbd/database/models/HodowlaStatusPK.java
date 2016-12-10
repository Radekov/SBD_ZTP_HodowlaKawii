package pl.edu.pb.wi.sbd.database.models;

import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Radosław Naruszewicz on 2016-12-09.
 */
@Embeddable
public class HodowlaStatusPK implements Serializable {

    @Column(name = "id_hodowla")
    private Integer idHodowla;
    @Column(name = "data")
    @Type(type="date")
    private Date date;

    public HodowlaStatusPK() {
    }

    public HodowlaStatusPK(Integer idHodowla, Date date) {
        this.idHodowla = idHodowla;
        this.date = date;
    }

    public Integer getIdHodowla() {
        return idHodowla;
    }

    public void setIdHodowla(Integer idHodowla) {
        this.idHodowla = idHodowla;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idHodowla != null ? idHodowla.hashCode() : 0);
        hash += (date != null ? date.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HodowlaStatusPK)) {
            return false;
        }
        HodowlaStatusPK other = (HodowlaStatusPK) object;
        if ((this.idHodowla == null && other.idHodowla != null) || (this.idHodowla != null && !this.idHodowla.equals(other.idHodowla))) {
            return false;
        }
        if ((this.date == null && other.date != null) || (this.date != null && !this.date.equals(other.date))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.HodowlaStatusPK[ idHodowla=" + idHodowla + ", data=" + date + " ]";
    }
}
