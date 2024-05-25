package web.Services;

import java.util.List;

import web.Entities.Login;

public interface LoginService {
 List<Login> getAllLogins();
 Login saveLogin(Login login);
 Login editLogin(Login login);

 Login getLoginByEmail(String ID);

 void deleteLogin(Login login);
 Long countLogin();
void deleteLoginById(String email);


}
