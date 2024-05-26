package com.example.demo.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entities.Cinema;
import com.example.demo.entities.Place;
import com.example.demo.entities.Salle;
import com.example.demo.services.SalleService;



@Controller
public class SalleController {
 private SalleService ss;

public SalleController(SalleService ss) {
	super();
	this.ss = ss;
}
@GetMapping("/salle")
public String listsalle(Model model) {
    List<Salle> salles = ss.getAllSalles();
    model.addAttribute("list",salles);
    return "gestiondessalles";
}
@GetMapping("/salle/new")
public String createGestionForm1(Model model) {
	
	Salle salle =new Salle();
	model.addAttribute("salle", salle);
	return "create_salle";

}
@PostMapping("/salle")
public String SaveSalle(@ModelAttribute("c") Salle salle) {
	salle.setIsconfig(false);
	salle.setIsdispo(true);
	ss.saveSalle(salle);
	return "redirect:/salle";
	}
@GetMapping("/salledispo")
public String listsalledispo(Model model, @RequestParam(required = false) String choix) {
    List<Salle> salles = ss.getAllSalles();
    List<Salle> filteredsalle = salles.stream()
            .filter(Salle::isIsdispo)
            .collect(Collectors.toList());
    model.addAttribute("choix", choix);
    model.addAttribute("list", filteredsalle);
    return "gestiondessalles";
}

@GetMapping("/salle/supprimer/{id}")
public String deleteSalle(@PathVariable Integer id, @RequestParam(required = false) String choix, Model model) {
    // Récupérer la salle à supprimer
    Salle salleToDelete = ss.getSalleById(id);

    if (salleToDelete != null) {
        model.addAttribute("choix", choix);
        ss.deleteSalleById(id);
    }

    return "redirect:/salledispo?choix=" + choix;
}

}

