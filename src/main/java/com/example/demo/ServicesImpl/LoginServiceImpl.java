package com.example.demo.ServicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.*;
import com.example.demo.repository.LoginRepository;
import com.example.demo.services.LoginService;
import com.example.demo.userDTO.UserDTO;

import java.util.List;
@Service
public class LoginServiceImpl implements LoginService {
	

	@Autowired
	public LoginServiceImpl(LoginRepository loginrep) {
		super();
		this.loginrep = loginrep;
	}

	public LoginServiceImpl() {
	super();
}


private LoginRepository loginrep;
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
	    return loginrep.findById(ID).orElse(null);
    }

    @Override
    public void deleteLogin(Login login) {
        loginrep.delete(login);
    }

    @Override
    public Long countLogin() {
        return loginrep.count();
    }


    @Override
    public Login saveLogin(Login login) {
        return loginrep.save(login);
    }
    @Override
    public Login saveLogin(UserDTO login) {
    	String role="Client";
        return loginrep.save(new Login(login.getEmail(), login.getMdp(),role));
    }

}
