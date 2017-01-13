package pl.edu.pb.wi.sbd.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.edu.pb.wi.sbd.database.models.Waga;
import pl.edu.pb.wi.sbd.database.models.WagaPK;

import java.util.List;

/**
 * Created by Radosław Naruszewicz on 2016-12-06.
 */@Repository
public interface WagaRepository extends JpaRepository<Waga, WagaPK>{
    @Query("select w.waga from Waga w where w.wagaPK.idKawia = :id_kawia " +
            "AND w.wagaPK.dataWazenia = (SELECT MAX(w.wagaPK.dataWazenia) " +
            "FROM Waga w2 WHERE w2.wagaPK.idKawia = :id_kawia)")
    public Double findByLastWaga(@Param("id_kawia") Integer idKawia);
}
