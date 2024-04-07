package Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class contollercinema {

     @GetMapping
     public String get(Model model){
         model.addAttribute("e", "hhh");
          return "Accueil.html";
     }
}