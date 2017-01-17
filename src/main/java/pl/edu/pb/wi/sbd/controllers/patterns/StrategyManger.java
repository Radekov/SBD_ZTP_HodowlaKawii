package pl.edu.pb.wi.sbd.controllers.patterns;

import pl.edu.pb.wi.sbd.database.models.Login;

/**
 * Created by Radosław Naruszewicz on 2017-01-17.
 */
public class StrategyManger implements Strategy {
    @Override
    public Double calculate(Login l) {
        return 70.0;
    }
}
