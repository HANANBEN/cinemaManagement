package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.Entities.Login;
import com.example.demo.Services.LoginService;
import com.example.demo.userDTO.UserDTO;

@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginService loginser; 
     
    @GetMapping
    public String get(Model model) {
        return "login";
    }
     
    @ModelAttribute("login")
    public Login Userlogin() {
        return new Login();
    }

    @PostMapping
    public String loginTopage(@ModelAttribute("login") Login login, Model model) {
        Login login1 = loginser.getLoginByEmail(login.getEmail());
        if (login1 == null || !login.getMdp().equals(login1.getMdp())) {
            
            model.addAttribute("loginFailed", true);
            return "login";
        } else {
            if ("Client".equals(login1.getProfile())) {
                return "map"; 
            }
            if ("admin".equals(login1.getProfile())) {
                return "contact"; 
            }
            if ("gestionnaire".equals(login1.getProfile())) {
                return "AcceuilGestionnaire"; 
            }
        }
        return "laylahaylah";
    }
}
