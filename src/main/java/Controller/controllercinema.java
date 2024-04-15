package Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import Services.CinemaService;


@Controller
public class controllercinema {
	
     private CinemaService cinema;
	@GetMapping("/hh")
     public String get(Model model){
         model.addAttribute("e", "hhh");
          return "gestiondescinemas.html";
     }
}