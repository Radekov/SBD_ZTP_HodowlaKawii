package pl.edu.pb.wi.sbd.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.edu.pb.wi.sbd.database.models.OsobaHodowla;
import pl.edu.pb.wi.sbd.database.models.OsobaHodowlaPK;

/**
 * Created by Radosław Naruszewicz on 2016-12-06.
 */@Repository
public interface OsobaHodowlaRepository extends JpaRepository<OsobaHodowla,OsobaHodowlaPK> {
}
