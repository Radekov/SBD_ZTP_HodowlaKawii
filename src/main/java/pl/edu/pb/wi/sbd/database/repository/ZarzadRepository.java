package pl.edu.pb.wi.sbd.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.edu.pb.wi.sbd.database.models.Zarzad;

/**
 * Created by Radosław Naruszewicz on 2016-12-06.
 */
//TODO sprawdzić czy za Login wstawić Integer
@Repository
public interface ZarzadRepository extends JpaRepository<Zarzad,Integer> {
}
