package com.example.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class MainController {
	
	
	
  
	 @GetMapping("/home")
     public String get3(Model model){
          return "Accueil.html";
	 }
	 @GetMapping("/about")
     public String get4(Model model){
          return "about.html";
	 }
	 @GetMapping("/contact")
     public String get5(Model model){
          return "contact.html";
	 }
}
