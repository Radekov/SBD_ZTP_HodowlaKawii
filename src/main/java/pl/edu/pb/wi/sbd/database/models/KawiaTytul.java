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
@Table(name = "KAWIA_TYTUL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "KawiaTytul.findAll", query = "SELECT k FROM KawiaTytul k")
    , @NamedQuery(name = "KawiaTytul.findByIdKawia", query = "SELECT k FROM KawiaTytul k WHERE k.kawiaTytulPK.idKawia = :idKawia")
    , @NamedQuery(name = "KawiaTytul.findByIdTytul", query = "SELECT k FROM KawiaTytul k WHERE k.kawiaTytulPK.idTytul = :idTytul")})
public class KawiaTytul implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected KawiaTytulPK kawiaTytulPK;
    @JoinColumn(name = "id_wystawa", referencedColumnName = "id_wystawa")
    @ManyToOne
    private Wystawa idWystawa;
    @JoinColumn(name = "id_tytul", referencedColumnName = "id_tytul", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Tytul tytul;
    @JoinColumn(name = "id_kawia", referencedColumnName = "id_kawia", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Kawia kawia;

    public KawiaTytul() {
    }

    public KawiaTytul(KawiaTytulPK kawiaTytulPK) {
        this.kawiaTytulPK = kawiaTytulPK;
    }

    public KawiaTytul(int idKawia, int idTytul) {
        this.kawiaTytulPK = new KawiaTytulPK(idKawia, idTytul);
    }

    public KawiaTytulPK getKawiaTytulPK() {
        return kawiaTytulPK;
    }

    public void setKawiaTytulPK(KawiaTytulPK kawiaTytulPK) {
        this.kawiaTytulPK = kawiaTytulPK;
    }

    public Wystawa getIdWystawa() {
        return idWystawa;
    }

    public void setIdWystawa(Wystawa idWystawa) {
        this.idWystawa = idWystawa;
    }

    public Tytul getTytul() {
        return tytul;
    }

    public void setTytul(Tytul tytul) {
        this.tytul = tytul;
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
        hash += (kawiaTytulPK != null ? kawiaTytulPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof KawiaTytul)) {
            return false;
        }
        KawiaTytul other = (KawiaTytul) object;
        if ((this.kawiaTytulPK == null && other.kawiaTytulPK != null) || (this.kawiaTytulPK != null && !this.kawiaTytulPK.equals(other.kawiaTytulPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.KawiaTytul[ kawiaTytulPK=" + kawiaTytulPK + " ]";
    }
    
}
