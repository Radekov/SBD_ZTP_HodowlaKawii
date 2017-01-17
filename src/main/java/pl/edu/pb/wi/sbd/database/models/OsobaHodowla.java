/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.edu.pb.wi.sbd.database.models;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author R
 */
//@Entity
//@Table(name = "OSOBA_HODOWLA")
//@XmlRootElement
public class OsobaHodowla implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected OsobaHodowlaPK osobaHodowlaPK;

    @Column(name = "data_odebrania")
    private Date dataOdebrania;
    @JoinColumn(name = "id_osoba", referencedColumnName = "id_osoba", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Osoba osoba;
    @JoinColumn(name = "id_hodowla", referencedColumnName = "id_hodowla", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Hodowla hodowla;

    public OsobaHodowla() {
    }

    public OsobaHodowla(OsobaHodowlaPK osobaHodowlaPK) {
        this.osobaHodowlaPK = osobaHodowlaPK;
    }

    public OsobaHodowla(int idOsoba, int idHodowla, Date dataNadania) {
        this.osobaHodowlaPK = new OsobaHodowlaPK(idOsoba, idHodowla, dataNadania);
    }

    public OsobaHodowlaPK getOsobaHodowlaPK() {
        return osobaHodowlaPK;
    }

    public void setOsobaHodowlaPK(OsobaHodowlaPK osobaHodowlaPK) {
        this.osobaHodowlaPK = osobaHodowlaPK;
    }

    public Date getDataOdebrania() {
        return dataOdebrania;
    }

    public void setDataOdebrania(Date dataOdebrania) {
        this.dataOdebrania = dataOdebrania;
    }

    public Osoba getOsoba() {
        return osoba;
    }

    public void setOsoba(Osoba osoba) {
        this.osoba = osoba;
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
        hash += (osobaHodowlaPK != null ? osobaHodowlaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OsobaHodowla)) {
            return false;
        }
        OsobaHodowla other = (OsobaHodowla) object;
        if ((this.osobaHodowlaPK == null && other.osobaHodowlaPK != null) || (this.osobaHodowlaPK != null && !this.osobaHodowlaPK.equals(other.osobaHodowlaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.OsobaHodowla[ osobaHodowlaPK=" + osobaHodowlaPK + " ]";
    }
    
}
