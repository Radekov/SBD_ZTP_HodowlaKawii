package pl.edu.pb.wi.sbd.database.repository;

import javafx.collections.ObservableList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.edu.pb.wi.sbd.database.models.Kawia;

import java.util.List;

/**
 * Created by Radosław Naruszewicz on 2016-12-06.
 */@Repository
public interface KawiaRepository extends JpaRepository<Kawia,Integer> {
     @Query("SELECT k " +
             "FROM Kawia k, WlascicielKawia wk, Osoba o, OsobaHodowla oh "+
             "WHERE k.idKawia = wk.wlascicielKawiaPK.idKawia " +
             "AND wk.wlascicielKawiaPK.idOsoba = o.idOsoba AND wk.dataZwrotu IS NULL " +
             "AND o.idOsoba = oh.osobaHodowlaPK.idOsoba " +
             "AND oh.osobaHodowlaPK.idHodowla = :idHodowla")
    public List<Kawia> findByWlasiciel(@Param("idHodowla") Integer idHodowla);
}
