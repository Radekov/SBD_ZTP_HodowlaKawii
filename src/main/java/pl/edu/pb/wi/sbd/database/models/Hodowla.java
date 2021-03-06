package pl.edu.pb.wi.sbd.database.models;

import pl.edu.pb.wi.sbd.Context;
import pl.edu.pb.wi.sbd.database.repository.HodowlaStatusRepository;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author R
 */
@Entity
@Table(name = "HODOWLA")
@XmlRootElement
@PrimaryKeyJoinColumn(name = "id_hodowla", referencedColumnName = "id_login")
public class Hodowla extends Login implements Serializable{

    private static final long serialVersionUID = 1L;

//    @GenericGenerator(name="gen", strategy="foreign", parameters={@org.hibernate.annotations.Parameter(name="property", value="login")})
//    @Id
//    @GeneratedValue(generator = "gen")
//    @Column(name = "id_hodowla", unique = true, nullable = false)
//    private Integer idHodowla;

    @Column(name = "nazwa_hodowla")
    private String nazwaHodowla;

//    @JoinTable(name = "HODOWLA_KAWIA", joinColumns = {
//            @JoinColumn(name = "id_hodowla", referencedColumnName = "id_hodowla")}, inverseJoinColumns = {
//            @JoinColumn(name = "id_kawia", referencedColumnName = "id_kawia")})
    @OneToMany(mappedBy = "idHodowla", fetch = FetchType.EAGER)
    private Collection<Kawia> kawiaCollection;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "hodowla", fetch = FetchType.LAZY)
    private Collection<HodowlaStatus> hodowlaStatusCollection;

    @OneToMany(mappedBy = "idHodowla")
    private Collection<Miot> miotCollection;

    @JoinColumn(name = "id_klub", referencedColumnName = "id_klub")
    @ManyToOne
    private Klub idKlub;

//    @JoinColumn(name = "id_hodowla", referencedColumnName = "id_login", insertable = false, updatable = false)
//    @OneToOne(fetch = FetchType.EAGER, optional = false)
//    private Login login;

//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "hodowla")
//    private Collection<OsobaHodowla> osobaHodowlaCollection;

    public Hodowla() {
    }

    public Hodowla(Integer idHodowla) {
        super(idHodowla);
    }

//    public Hodowla(Login login) {
//        this.login = login;
//    }

    public Integer getIdHodowla() {
        return getIdLogin();
    }

    public void setIdHodowla(Integer idHodowla) {
        setIdLogin(idHodowla);
    }

    public String getNazwaHodowla() {
        return nazwaHodowla;
    }

    public void setNazwaHodowla(String nazwaHodowla) {
        this.nazwaHodowla = nazwaHodowla;
    }

    @XmlTransient
    public Collection<Kawia> getKawiaCollection() {
        return kawiaCollection;
    }

    public void setKawiaCollection(Collection<Kawia> kawiaCollection) {
        this.kawiaCollection = kawiaCollection;
    }

    public Collection<HodowlaStatus> getHodowlaStatusCollection() {
        return hodowlaStatusCollection;
    }

    public void setHodowlaStatusCollection(Collection<HodowlaStatus> hodowlaStatusCollection) {
        this.hodowlaStatusCollection = hodowlaStatusCollection;
    }

    @XmlTransient
    public Collection<Miot> getMiotCollection() {
        return miotCollection;
    }

    public void setMiotCollection(Collection<Miot> miotCollection) {
        this.miotCollection = miotCollection;
    }

    public Klub getIdKlub() {
        return idKlub;
    }

    public void setIdKlub(Klub idKlub) {
        this.idKlub = idKlub;
    }

//    public Login getLogin() {
//        return login;
//    }
//
//    public void setLogin(Login login) {
//        this.login = login;
//    }

//    @XmlTransient
//    public Collection<OsobaHodowla> getOsobaHodowlaCollection() {
//        return osobaHodowlaCollection;
//    }
//
//    public void setOsobaHodowlaCollection(Collection<OsobaHodowla> osobaHodowlaCollection) {
//        this.osobaHodowlaCollection = osobaHodowlaCollection;
//    }

    @Override
    public int hashCode() {
//        int hash = 0;
//        hash += (idHodowla != null ? idHodowla.hashCode() : 0);
//        return hash;
        return super.
                hashCode();
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Hodowla)) {
            return false;
        }
        Hodowla other = (Hodowla) object;
        if ((this.getIdLogin() == null && other.getIdLogin() != null) || (this.getIdLogin() != null && !this.getIdLogin().equals(other.getIdLogin()))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Hodowla[ idHodowla=" + getIdLogin() + " ]";
    }

    @Override
    public List<Kawia> getAllCavies() {
        return new ArrayList<Kawia>(getKawiaCollection());
    }

    @Override
    public String getStatus() {
        HodowlaStatusRepository hodowlaStatusRepository = Context.getInstance().getBean(HodowlaStatusRepository.class);
        if(getIdLogin() == null) return null;
        String result = hodowlaStatusRepository.findByDate(getIdLogin());
        if(result == null) result = "";
        return result;
    }

    //    @Override
//    public String write() {
//        //Leniwe podejście FIXME
//        HodowlaStatus status = null;
//        Iterator itr = hodowlaStatusCollection.iterator();
//        if(itr.hasNext())
//            status = (HodowlaStatus) itr.next();
//        if (status == null) {
//            return ("Hodowla: " + nazwaHodowla + " Status: " + "nieznay");
//        }
//        while (itr.hasNext()) {
//            HodowlaStatus s = (HodowlaStatus) itr.next();
//            if (status.getHodowlaStatusPK().getDate().compareTo(s.getHodowlaStatusPK().getDate()) > 0)
//                status = s;
//        }
//        return ("Hodowla: " + nazwaHodowla + " Status: " + status.getStatus());
//    }

}
