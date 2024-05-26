package com.example.demo.services;

import com.example.demo.entities.*;
import com.example.demo.userDTO.UserDTO;

import java.util.List;

public interface LoginService {
	
 List<Login> getAllLogins();
 Login saveLogin(Login login);
 Login saveLogin(UserDTO login);
 Login editLogin(Login login);
Login getLoginByEmail(String ID);

 void deleteLogin(Login login);
 Long countLogin();


}
