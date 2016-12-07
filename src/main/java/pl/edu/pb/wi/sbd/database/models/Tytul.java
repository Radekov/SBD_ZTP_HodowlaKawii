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
@Table(name = "TYTUL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tytul.findAll", query = "SELECT t FROM Tytul t")
    , @NamedQuery(name = "Tytul.findByIdTytul", query = "SELECT t FROM Tytul t WHERE t.idTytul = :idTytul")
    , @NamedQuery(name = "Tytul.findByNazwa", query = "SELECT t FROM Tytul t WHERE t.nazwa = :nazwa")})
public class Tytul implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_tytul")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idTytul;

    @Column(name = "nazwa")
    private String nazwa;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tytul")
    private Collection<KawiaTytul> kawiaTytulCollection;

    public Tytul() {
    }

    public Tytul(Integer idTytul) {
        this.idTytul = idTytul;
    }

    public Integer getIdTytul() {
        return idTytul;
    }

    public void setIdTytul(Integer idTytul) {
        this.idTytul = idTytul;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
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
        hash += (idTytul != null ? idTytul.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tytul)) {
            return false;
        }
        Tytul other = (Tytul) object;
        if ((this.idTytul == null && other.idTytul != null) || (this.idTytul != null && !this.idTytul.equals(other.idTytul))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Tytul[ idTytul=" + idTytul + " ]";
    }
    
}
