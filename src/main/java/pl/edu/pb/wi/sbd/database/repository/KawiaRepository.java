package pl.edu.pb.wi.sbd.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.edu.pb.wi.sbd.database.models.Hodowla;
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

    @Query("SELECT k " +
            "FROM Kawia k, WlascicielKawia wk, Osoba o, Milosnik m "+
            "WHERE :idMilosnik = o.idOsoba " +
            "AND o.idOsoba = wk.wlascicielKawiaPK.idOsoba " +
            "AND wk.dataZwrotu IS NULL " +
            "AND wk.wlascicielKawiaPK.idKawia = k.idKawia ")
    public List<Kawia> findByAllCaviesBelongToLover(@Param("idMilosnik") Integer idMilosnik);


    @Query("select k from Kawia k where k.plec = :plec")
    public List<Kawia> findByPlec(@Param("plec")Boolean plec);

    @Modifying
    @Transactional
    @Query("UPDATE Kawia k SET k.idHodowla = :hodowla WHERE k.idKawia = :idKawia")
    int updateHodowla(@Param("idKawia") Integer idKawia, @Param("hodowla") Hodowla hodowla);
}
