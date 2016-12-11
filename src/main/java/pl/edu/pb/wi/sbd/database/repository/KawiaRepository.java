package pl.edu.pb.wi.sbd.database.repository;

import javafx.collections.ObservableList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.edu.pb.wi.sbd.database.models.Kawia;

import java.util.List;

/**
 * Created by Radosław Naruszewicz on 2016-12-06.
 */@Repository
public interface KawiaRepository extends JpaRepository<Kawia,Integer> {
     @Query("SELECT k " +
             "FROM KAWIA k, WLASCICIEL_KAWIA wk, OSOBA o, OSOBA_HODOWLA oh "+
             "WHERE k.idKawia = wk.id_kawia " +
             "AND wk.idOsoba = o.id_osoba AND wk.data_zwrotu IS NULL " +
             "AND o.idOsoba = oh.id_osoba " +
             "AND oh.idHodowla = ?1")
    public ObservableList<Kawia> findByWlasiciel(Integer idHodowla);
}
