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
@NamedQueries({
    @NamedQuery(name = "HodowlaStatus.findAll", query = "SELECT h FROM HodowlaStatus h")
    , @NamedQuery(name = "HodowlaStatus.findByIdHodowla", query = "SELECT h FROM HodowlaStatus h WHERE h.idHodowla = :idHodowla")
    , @NamedQuery(name = "HodowlaStatus.findByStatus", query = "SELECT h FROM HodowlaStatus h WHERE h.status = :status")
    , @NamedQuery(name = "HodowlaStatus.findByData", query = "SELECT h FROM HodowlaStatus h WHERE h.data = :data")})
public class HodowlaStatus implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_hodowla")

    private Integer idHodowla;
    @Column(name = "status")
    private String status;
    @Column(name = "data")
    @Type(type="date")
    private Date data;
    @JoinColumn(name = "id_hodowla", referencedColumnName = "id_hodowla", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Hodowla hodowla;

    public HodowlaStatus() {
    }

    public HodowlaStatus(Integer idHodowla) {
        this.idHodowla = idHodowla;
    }

    public Integer getIdHodowla() {
        return idHodowla;
    }

    public void setIdHodowla(Integer idHodowla) {
        this.idHodowla = idHodowla;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
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
        hash += (idHodowla != null ? idHodowla.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HodowlaStatus)) {
            return false;
        }
        HodowlaStatus other = (HodowlaStatus) object;
        if ((this.idHodowla == null && other.idHodowla != null) || (this.idHodowla != null && !this.idHodowla.equals(other.idHodowla))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.HodowlaStatus[ idHodowla=" + idHodowla + " ]";
    }
    
}
