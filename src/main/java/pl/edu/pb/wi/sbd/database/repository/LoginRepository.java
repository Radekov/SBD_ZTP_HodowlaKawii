package pl.edu.pb.wi.sbd.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.edu.pb.wi.sbd.database.models.Login;

/**
 * Created by Radosław Naruszewicz on 2016-12-06.
 */
public interface LoginRepository extends JpaRepository<Login, Integer> {
    Login findByNazwa(String nazwa);
}
