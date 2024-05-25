package web.ServicesImpl;

import web.Entities.Login;
import web.Repositories.LoginRepository;
import web.Services.LoginService;

import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LoginServiceImpl implements LoginService {

private LoginRepository loginrep;

    public LoginServiceImpl(LoginRepository loginrep) {

        this.loginrep = loginrep;
    }

    @Override
    public List<Login> getAllLogins() {
        return loginrep.findAll();
    }

    @Override
    public Login editLogin(Login login) {
        return loginrep.save(login);
    }

    @Override
        public Login getLoginByEmail(String ID) {
            return loginrep.findByEmail(ID);
    }

    @Override
    public void deleteLogin(Login login) {
        loginrep.delete(login);
    }
    @Override
    public void deleteLoginById(String email) {
        loginrep.deleteById(email);
    }

    @Override
    public Long countLogin() {
        return loginrep.count();
    }


    @Override
    public Login saveLogin(Login login) {
        return loginrep.save(login);
    }

}
