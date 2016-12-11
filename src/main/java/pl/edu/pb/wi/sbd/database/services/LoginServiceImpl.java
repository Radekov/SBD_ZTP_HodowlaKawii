package pl.edu.pb.wi.sbd.database.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.pb.wi.sbd.database.models.Login;
import pl.edu.pb.wi.sbd.database.repository.LoginRepository;
import pl.edu.pb.wi.sbd.database.services.interfaces.LoginService;

/**
 * Created by Radosław Naruszewicz on 2016-12-07.
 */
@Service
public class LoginServiceImpl implements LoginService {
    private LoginRepository loginRepository;

    @Autowired
    public LoginServiceImpl(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    public LoginRepository getLoginRepository() {
        return loginRepository;
    }

    //    @Autowired
//    public LoginServiceImpl(LoginRepository repository) {
//        this.loginRepository = repository;
//    }

    public Login save(Login l){
        return loginRepository.save(l);
    }
}
