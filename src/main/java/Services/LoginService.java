package Services;

import Entities.Login;

import java.util.List;

public interface LoginService {
 List<Login> getAllLogins();
 Login saveLogin(Login login);
 Login editLogin(Login login);

 Login getLoginByEmail(String ID);

 void deleteLogin(Login login);
 Long countLogin();


}
