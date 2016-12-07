/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.edu.pb.wi.sbd.database.models;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 *
 * @author R
 */
@Entity
@Table(name = "KAWIA_OSOBA_WYSTAWA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "KawiaOsobaWystawa.findAll", query = "SELECT k FROM KawiaOsobaWystawa k")
    , @NamedQuery(name = "KawiaOsobaWystawa.findByIdKawia", query = "SELECT k FROM KawiaOsobaWystawa k WHERE k.kawiaOsobaWystawaPK.idKawia = :idKawia")
    , @NamedQuery(name = "KawiaOsobaWystawa.findByIdOsoba", query = "SELECT k FROM KawiaOsobaWystawa k WHERE k.kawiaOsobaWystawaPK.idOsoba = :idOsoba")
    , @NamedQuery(name = "KawiaOsobaWystawa.findByIdWystawa", query = "SELECT k FROM KawiaOsobaWystawa k WHERE k.kawiaOsobaWystawaPK.idWystawa = :idWystawa")})
public class KawiaOsobaWystawa implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected KawiaOsobaWystawaPK kawiaOsobaWystawaPK;
    @JoinColumn(name = "id_wystawa", referencedColumnName = "id_wystawa", insertable = false, updatable = false)
    @ManyToOne
    private Wystawa wystawa;
    @JoinColumn(name = "id_osoba", referencedColumnName = "id_osoba", insertable = false, updatable = false)
    @ManyToOne
    private Osoba osoba;
    @JoinColumn(name = "id_kawia", referencedColumnName = "id_kawia", insertable = false, updatable = false)
    @ManyToOne
    private Kawia kawia;

    public KawiaOsobaWystawa() {
    }

    public KawiaOsobaWystawa(KawiaOsobaWystawaPK kawiaOsobaWystawaPK) {
        this.kawiaOsobaWystawaPK = kawiaOsobaWystawaPK;
    }

    public KawiaOsobaWystawa(Integer idKawia, Integer idOsoba, Integer idWystawa) {
        this.kawiaOsobaWystawaPK = new KawiaOsobaWystawaPK(idKawia, idOsoba, idWystawa);
    }

    public KawiaOsobaWystawaPK getKawiaOsobaWystawaPK() {
        return kawiaOsobaWystawaPK;
    }

    public void setKawiaOsobaWystawaPK(KawiaOsobaWystawaPK kawiaOsobaWystawaPK) {
        this.kawiaOsobaWystawaPK = kawiaOsobaWystawaPK;
    }

    public Wystawa getWystawa() {
        return wystawa;
    }

    public void setWystawa(Wystawa wystawa) {
        this.wystawa = wystawa;
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
        hash += (kawiaOsobaWystawaPK != null ? kawiaOsobaWystawaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof KawiaOsobaWystawa)) {
            return false;
        }
        KawiaOsobaWystawa other = (KawiaOsobaWystawa) object;
        if ((this.kawiaOsobaWystawaPK == null && other.kawiaOsobaWystawaPK != null) || (this.kawiaOsobaWystawaPK != null && !this.kawiaOsobaWystawaPK.equals(other.kawiaOsobaWystawaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.KawiaOsobaWystawa[ kawiaOsobaWystawaPK=" + kawiaOsobaWystawaPK + " ]";
    }
    
}
