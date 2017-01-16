package pl.edu.pb.wi.sbd.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.edu.pb.wi.sbd.database.models.HodowlaStatus;

/**
 * Created by Radosław Naruszewicz on 2016-12-06.
 */
@Repository
public interface HodowlaStatusRepository extends JpaRepository<HodowlaStatus,Integer> {

    @Query("select s.status from HodowlaStatus s where s.hodowlaStatusPK.idHodowla = :id_hodowla " +
            "AND s.hodowlaStatusPK.date = (SELECT MAX(s2.hodowlaStatusPK.date) " +
            "FROM HodowlaStatus s2 WHERE s2.hodowlaStatusPK.idHodowla = :id_hodowla)")
    public String findByDate(@Param("id_hodowla") Integer idHodowla);
}
