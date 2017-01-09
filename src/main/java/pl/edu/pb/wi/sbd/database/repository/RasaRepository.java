package pl.edu.pb.wi.sbd.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.edu.pb.wi.sbd.database.models.Rasa;

/**
 * Created by Radosław Naruszewicz on 2016-12-06.
 */
public interface RasaRepository extends JpaRepository<Rasa,Integer> {
     Rasa findByRasaAndMasc(String rasa, String masc);
}
