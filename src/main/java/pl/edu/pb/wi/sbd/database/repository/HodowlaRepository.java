package pl.edu.pb.wi.sbd.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.edu.pb.wi.sbd.database.models.Hodowla;

/**
 * Created by Radosław Naruszewicz on 2016-12-06.
 */
//TODO sprawdzić czy za Integer wstawić Login
    @Repository
public interface HodowlaRepository extends JpaRepository<Hodowla, Integer > {
}
