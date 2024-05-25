package web.Controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import web.Entities.Gestionnaire;
import web.Entities.Salle;
import web.Services.SalleService;


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
@GetMapping("/salle/edit/{id}")
public String editsalle(@PathVariable Integer id,Model model) {
	 model.addAttribute("salle",ss.getSalleById(id));
	 return "editsalle";

}
@PostMapping("/salle/{id}")
public String updatesalle(@PathVariable Integer id,
		@ModelAttribute("x") Salle salle,Model model) {
	Salle existingsalle = ss.getSalleById(id);
	existingsalle.setIdsalle(id);
	existingsalle.setNom(salle.getNom());
    ss.editSalle(existingsalle);
	return "redirect:/salle";
	
	

}
}
