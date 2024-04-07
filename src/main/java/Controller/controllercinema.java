package Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class controllercinema {

	@GetMapping("/hh")
     public String get(Model model){
         model.addAttribute("e", "hhh");
          return "gestiondescinemas.html";
     }
}