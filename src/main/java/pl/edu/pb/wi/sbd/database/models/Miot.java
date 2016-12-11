/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.edu.pb.wi.sbd.database.models;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

/**
 * @author R
 */
@Entity
@Table(name = "MIOT")
@XmlRootElement
public class Miot implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_miot")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idMiot;

    @Column(name = "nr_miotu")
    private Integer nrMiotu;

    @Type(type = "date")
    @Column(name = "data_urodzenia")
    private Date dataUrodzenia;

//    @JoinColumns({
//            @JoinColumn(name = "id_tata", referencedColumnName = "id_kawia")
//            ,@JoinColumn(name = "id_mama", referencedColumnName = "id_kawia")})
//    @ManyToOne
//    private Kawia kawia;

    @JoinColumn(name = "id_mama", referencedColumnName = "id_kawia")
    @ManyToOne
    private Kawia kawia;

    @JoinColumn(name = "id_hodowla", referencedColumnName = "id_hodowla")
    @ManyToOne
    private Hodowla idHodowla;

    @OneToMany(mappedBy = "idMiot")
    private Collection<Kawia> kawiaCollection;

    public Miot() {
    }

    public Miot(Integer idMiot) {
        this.idMiot = idMiot;
    }

    public Integer getIdMiot() {
        return idMiot;
    }

    public void setIdMiot(Integer idMiot) {
        this.idMiot = idMiot;
    }

    public Integer getNrMiotu() {
        return nrMiotu;
    }

    public void setNrMiotu(Integer nrMiotu) {
        this.nrMiotu = nrMiotu;
    }

    public Date getDataUrodzenia() {
        return dataUrodzenia;
    }

    public void setDataUrodzenia(Date dataUrodzenia) {
        this.dataUrodzenia = dataUrodzenia;
    }

    public Kawia getKawia() {
        return kawia;
    }

    public void setKawia(Kawia kawia) {
        this.kawia = kawia;
    }

    public Hodowla getIdHodowla() {
        return idHodowla;
    }

    public void setIdHodowla(Hodowla idHodowla) {
        this.idHodowla = idHodowla;
    }

    @XmlTransient
    public Collection<Kawia> getKawiaCollection() {
        return kawiaCollection;
    }

    public void setKawiaCollection(Collection<Kawia> kawiaCollection) {
        this.kawiaCollection = kawiaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMiot != null ? idMiot.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Miot)) {
            return false;
        }
        Miot other = (Miot) object;
        if ((this.idMiot == null && other.idMiot != null) || (this.idMiot != null && !this.idMiot.equals(other.idMiot))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Miot[ idMiot=" + idMiot + " ]";
    }

}
