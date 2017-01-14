package pl.edu.pb.wi.sbd.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.edu.pb.wi.sbd.database.models.Hodowla;
import pl.edu.pb.wi.sbd.database.models.Miot;

/**
 * Created by Radosław Naruszewicz on 2016-12-06.
 */@Repository
public interface MiotRepository extends JpaRepository<Miot,Integer> {

     @Query("select COUNT(m) from Miot m where m.idHodowla = :idHodowla")
     public Integer getCount(@Param("idHodowla")Hodowla idHodowla);
}
