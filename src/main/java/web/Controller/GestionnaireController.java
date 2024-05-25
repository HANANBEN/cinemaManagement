package web.Controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import web.Entities.Cinema;
import web.Entities.Gestionnaire;
import web.Entities.Login;
import web.Services.CinemaService;
import web.Services.GestionnaireService;
import web.Services.LoginService;



@Controller
public class GestionnaireController {
    private GestionnaireService gs;
    private LoginService ls;
    private CinemaService cs;

 




	public GestionnaireController(GestionnaireService gs, LoginService ls, CinemaService cs) {
		super();
		this.gs = gs;
		this.ls = ls;
		this.cs = cs;
	}
	
	@GetMapping("/gestionnaire")
    public String listgestionnaire(Model model) {
        List<Gestionnaire> gestionnaires = gs.getAllGestionnaires();
        System.out.println("Nombre de gestionnaires récupérés : " + gestionnaires.size());
        model.addAttribute("list",gestionnaires);
        return "gestiondesgestionnaires";
    }
	@GetMapping("/gestionnaire/edit/{id}")
    public String editgestionnaire(@PathVariable Integer id,Model model) {
		 model.addAttribute("gestionnaire",gs.getGestionnaireById(id));
		 return "editgestionnaire";

}
	@PostMapping("/gestionnaires/{id}")
    public String updategestionnaire(@PathVariable Integer id,
    		@ModelAttribute("gestionnaire") Gestionnaire gestionnaire,Model model) {
		Gestionnaire existingestionnaire = gs.getGestionnaireById(id);
		existingestionnaire.setIdgestionnaire(id);
		existingestionnaire.setNom(gestionnaire.getNom());
		existingestionnaire.setPrenom(gestionnaire.getPrenom());
		existingestionnaire.setEmail(gestionnaire.getEmail());
		existingestionnaire.setTele(gestionnaire.getTele());
		gs.editGestionnaire(existingestionnaire);
		return "redirect:/gestionnaire";
		
		

}
	@GetMapping("/gestionnaire/new")
    public String createGestionForm1(Model model) {
    	
    	Gestionnaire gestionnaire =new Gestionnaire();
    	model.addAttribute("gestionnaire", gestionnaire);
    	return "create_gestionnaire";
    
    }
    @PostMapping("/gestionnaire")
    public String SaveCinema(@ModelAttribute("gestionnaire") Gestionnaire gestionnaire) {
    	gestionnaire.setIsaffected(false);
    	gs.saveGestionnaire(gestionnaire);
    	return "redirect:/gestionnaire";
    	}
    @GetMapping("/gestionnaire/delete/{id}")
    public String deleteGestionForm1(@PathVariable Integer id) {
        Gestionnaire gestionnaire = gs.getGestionnaireById(id);
        if (gestionnaire != null) {
            Cinema cinema = cs.getCinemaByGestionnaireId(id);
            System.out.print(cinema.getIdcinema());
           
            if (cinema != null) {
            	
                cinema.setGestionnaire(null); 
                cinema.setIsaffected(false);
                cs.saveCinema(cinema); 
            }
            String email = gestionnaire.getEmailgestionnaire().getEmail();
           
            gs.deleteGestionnaireById(id);
            ls.deleteLoginById(email);
           
        }
        return "redirect:/gestionnaire"; 
    }




    }
    


    
    
    

  
    
	
	
