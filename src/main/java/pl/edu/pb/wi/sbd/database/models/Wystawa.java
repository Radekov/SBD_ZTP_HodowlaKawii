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
 *
 * @author R
 */
@Entity
@Table(name = "WYSTAWA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Wystawa.findAll", query = "SELECT w FROM Wystawa w")
    , @NamedQuery(name = "Wystawa.findByIdWystawa", query = "SELECT w FROM Wystawa w WHERE w.idWystawa = :idWystawa")
    , @NamedQuery(name = "Wystawa.findByDataWystawy", query = "SELECT w FROM Wystawa w WHERE w.dataWystawy = :dataWystawy")
    , @NamedQuery(name = "Wystawa.findByMiasto", query = "SELECT w FROM Wystawa w WHERE w.miasto = :miasto")
    , @NamedQuery(name = "Wystawa.findByUlica", query = "SELECT w FROM Wystawa w WHERE w.ulica = :ulica")
    , @NamedQuery(name = "Wystawa.findByKodPocztowy", query = "SELECT w FROM Wystawa w WHERE w.kodPocztowy = :kodPocztowy")
    , @NamedQuery(name = "Wystawa.findByTelefon", query = "SELECT w FROM Wystawa w WHERE w.telefon = :telefon")
    , @NamedQuery(name = "Wystawa.findByNrDomu", query = "SELECT w FROM Wystawa w WHERE w.nrDomu = :nrDomu")
    , @NamedQuery(name = "Wystawa.findByNrLokalu", query = "SELECT w FROM Wystawa w WHERE w.nrLokalu = :nrLokalu")})
public class Wystawa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_wystawa")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idWystawa;

    @Type(type="date")
    @Column(name = "data_wystawy")
    private Date dataWystawy;

    @Column(name = "miasto")
    private String miasto;

    @Column(name = "ulica")
    private String ulica;

    @Column(name = "kod_pocztowy")
    private String kodPocztowy;

    @Column(name = "telefon")
    private String telefon;

    @Column(name = "nr_domu")
    private Integer nrDomu;

    @Column(name = "nr_lokalu")
    private Integer nrLokalu;

    @OneToMany(mappedBy = "wystawa")
    private Collection<KawiaOsobaWystawa> kawiaOsobaWystawaCollection;

    @OneToMany(mappedBy = "idWystawa")
    private Collection<KawiaTytul> kawiaTytulCollection;

    public Wystawa() {
    }

    public Wystawa(Integer idWystawa) {
        this.idWystawa = idWystawa;
    }

    public Integer getIdWystawa() {
        return idWystawa;
    }

    public void setIdWystawa(Integer idWystawa) {
        this.idWystawa = idWystawa;
    }

    public Date getDataWystawy() {
        return dataWystawy;
    }

    public void setDataWystawy(Date dataWystawy) {
        this.dataWystawy = dataWystawy;
    }

    public String getMiasto() {
        return miasto;
    }

    public void setMiasto(String miasto) {
        this.miasto = miasto;
    }

    public String getUlica() {
        return ulica;
    }

    public void setUlica(String ulica) {
        this.ulica = ulica;
    }

    public String getKodPocztowy() {
        return kodPocztowy;
    }

    public void setKodPocztowy(String kodPocztowy) {
        this.kodPocztowy = kodPocztowy;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public Integer getNrDomu() {
        return nrDomu;
    }

    public void setNrDomu(Integer nrDomu) {
        this.nrDomu = nrDomu;
    }

    public Integer getNrLokalu() {
        return nrLokalu;
    }

    public void setNrLokalu(Integer nrLokalu) {
        this.nrLokalu = nrLokalu;
    }

    @XmlTransient
    public Collection<KawiaOsobaWystawa> getKawiaOsobaWystawaCollection() {
        return kawiaOsobaWystawaCollection;
    }

    public void setKawiaOsobaWystawaCollection(Collection<KawiaOsobaWystawa> kawiaOsobaWystawaCollection) {
        this.kawiaOsobaWystawaCollection = kawiaOsobaWystawaCollection;
    }

    @XmlTransient
    public Collection<KawiaTytul> getKawiaTytulCollection() {
        return kawiaTytulCollection;
    }

    public void setKawiaTytulCollection(Collection<KawiaTytul> kawiaTytulCollection) {
        this.kawiaTytulCollection = kawiaTytulCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idWystawa != null ? idWystawa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Wystawa)) {
            return false;
        }
        Wystawa other = (Wystawa) object;
        if ((this.idWystawa == null && other.idWystawa != null) || (this.idWystawa != null && !this.idWystawa.equals(other.idWystawa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Wystawa[ idWystawa=" + idWystawa + " ]";
    }
    
}
