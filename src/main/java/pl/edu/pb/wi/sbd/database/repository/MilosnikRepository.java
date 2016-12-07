package pl.edu.pb.wi.sbd.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.edu.pb.wi.sbd.database.models.Milosnik;

/**
 * Created by Radosław Naruszewicz on 2016-12-06.
 */

//TODO sprawdzić czy za Integer wstawić Login
@Repository
public interface MilosnikRepository extends JpaRepository<Milosnik,Integer> {
}
