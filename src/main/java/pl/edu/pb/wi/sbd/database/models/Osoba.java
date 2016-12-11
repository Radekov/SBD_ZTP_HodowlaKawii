/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.edu.pb.wi.sbd.database.models;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.Collection;

/**
 *
 * @author R
 */
@Entity
@Table(name = "OSOBA")
@XmlRootElement
public class Osoba implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_osoba")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idOsoba;

    @Column(name = "imie")
    private String imie;

    @Column(name = "nazwisko")
    private String nazwisko;

    @Column(name = "miasto")
    private String miasto;

    @Column(name = "ulica")
    private String ulica;

    @Column(name = "kod_pocztowy")
    private String kodPocztowy;

    @Column(name = "telefon")
    private String telefon;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "osoba")
    private Collection<OsobaHodowla> osobaHodowlaCollection;

    @OneToMany(mappedBy = "idOsoba")
    private Collection<Milosnik> milosnikCollection;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "osoba")
    private Collection<WlascicielKawia> wlascicielKawiaCollection;

    @OneToMany(mappedBy = "osoba")
    private Collection<KawiaOsobaWystawa> kawiaOsobaWystawaCollection;

    @OneToMany(mappedBy = "idOsoba")
    private Collection<Zarzad> zarzadCollection;

    public Osoba() {
    }

    public Osoba(Integer idOsoba) {
        this.idOsoba = idOsoba;
    }

    public Integer getIdOsoba() {
        return idOsoba;
    }

    public void setIdOsoba(Integer idOsoba) {
        this.idOsoba = idOsoba;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
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

    @XmlTransient
    public Collection<OsobaHodowla> getOsobaHodowlaCollection() {
        return osobaHodowlaCollection;
    }

    public void setOsobaHodowlaCollection(Collection<OsobaHodowla> osobaHodowlaCollection) {
        this.osobaHodowlaCollection = osobaHodowlaCollection;
    }

    @XmlTransient
    public Collection<Milosnik> getMilosnikCollection() {
        return milosnikCollection;
    }

    public void setMilosnikCollection(Collection<Milosnik> milosnikCollection) {
        this.milosnikCollection = milosnikCollection;
    }

    @XmlTransient
    public Collection<WlascicielKawia> getWlascicielKawiaCollection() {
        return wlascicielKawiaCollection;
    }

    public void setWlascicielKawiaCollection(Collection<WlascicielKawia> wlascicielKawiaCollection) {
        this.wlascicielKawiaCollection = wlascicielKawiaCollection;
    }

    @XmlTransient
    public Collection<KawiaOsobaWystawa> getKawiaOsobaWystawaCollection() {
        return kawiaOsobaWystawaCollection;
    }

    public void setKawiaOsobaWystawaCollection(Collection<KawiaOsobaWystawa> kawiaOsobaWystawaCollection) {
        this.kawiaOsobaWystawaCollection = kawiaOsobaWystawaCollection;
    }

    @XmlTransient
    public Collection<Zarzad> getZarzadCollection() {
        return zarzadCollection;
    }

    public void setZarzadCollection(Collection<Zarzad> zarzadCollection) {
        this.zarzadCollection = zarzadCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOsoba != null ? idOsoba.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Osoba)) {
            return false;
        }
        Osoba other = (Osoba) object;
        if ((this.idOsoba == null && other.idOsoba != null) || (this.idOsoba != null && !this.idOsoba.equals(other.idOsoba))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Osoba[ idOsoba=" + idOsoba + " ]";
    }
    
}
