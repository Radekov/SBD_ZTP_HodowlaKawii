/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.edu.pb.wi.sbd.database.models;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 *
 * @author R
 */
@Embeddable
public class KawiaTytulPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id_kawia")
    private int idKawia;
    @Basic(optional = false)
    @Column(name = "id_tytul")
    private int idTytul;

    public KawiaTytulPK() {
    }

    public KawiaTytulPK(int idKawia, int idTytul) {
        this.idKawia = idKawia;
        this.idTytul = idTytul;
    }

    public int getIdKawia() {
        return idKawia;
    }

    public void setIdKawia(int idKawia) {
        this.idKawia = idKawia;
    }

    public int getIdTytul() {
        return idTytul;
    }

    public void setIdTytul(int idTytul) {
        this.idTytul = idTytul;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idKawia;
        hash += (int) idTytul;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof KawiaTytulPK)) {
            return false;
        }
        KawiaTytulPK other = (KawiaTytulPK) object;
        if (this.idKawia != other.idKawia) {
            return false;
        }
        if (this.idTytul != other.idTytul) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.KawiaTytulPK[ idKawia=" + idKawia + ", idTytul=" + idTytul + " ]";
    }
    
}
