package com.example.demo.Services;

import com.example.demo.Entities.*;
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
