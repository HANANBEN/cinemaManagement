package com.example.demo.services;

import java.util.List;

import com.example.demo.entities.Login;

public interface LoginService {
 List<Login> getAllLogins();
 Login saveLogin(Login login);
 Login editLogin(Login login);

 Login getLoginByEmail(String ID);

 void deleteLogin(Login login);
 Long countLogin();


}
