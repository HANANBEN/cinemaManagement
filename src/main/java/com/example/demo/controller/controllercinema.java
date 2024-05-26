package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entities.Cinema;
import com.example.demo.entities.Gestionnaire;
import com.example.demo.entities.Place;
import com.example.demo.entities.Salle;
import com.example.demo.entities.Ville;
import com.example.demo.services.CinemaService;
import com.example.demo.services.GestionnaireService;
import com.example.demo.services.PlaceService;
import com.example.demo.services.SalleService;

@Controller
public class controllercinema {

    private CinemaService cs;
    private GestionnaireService gs;
    private SalleService sc;
    private PlaceService pc;

    // Injectez le service CinemaService et GestionnaireService via le constructeur
    @Autowired
    public controllercinema(CinemaService cs, GestionnaireService gs, PlaceService pc) {
        this.cs = cs;
        this.gs = gs;
        this.pc = pc;
    }

    @GetMapping("/cinema")
    public String listcinemas(Model model) {
        List<Cinema> cinemas = cs.getAllCinemas();
        
        // Pour chaque cinéma, mettez à jour le nombre de salles
        for (Cinema cinema : cinemas) {
            Integer nbrSalles = cs.countSallesInCinema(cinema.getIdcinema());
            cinema.setNbrsalle(nbrSalles);
        }

        int choix=0;
        model.addAttribute("choix", choix);
        model.addAttribute("list",cinemas);
        return "cinema";
    }
    
    @GetMapping("/cinemaAffected")
    public String listcinemasaffec(Model model,@RequestParam String choix) {
    	
        List<Cinema> cinemas = cs.getAllCinemas();
        List<Cinema> filteredcinema = cinemas.stream()
                .filter(c-> c.getIsaffected())
                .collect(Collectors.toList());
        model.addAttribute("choix",choix);
        model.addAttribute("list",filteredcinema);
        return "cinema";
    }
    @GetMapping("/cinemanonAffected")
    public String listcinemanonsaffec(Model model,@RequestParam String choix) {
    	
        List<Cinema> cinemas = cs.getAllCinemas();
        List<Cinema> filteredcinema = cinemas.stream()
                .filter(c-> !c.getIsaffected())
                .collect(Collectors.toList());
        model.addAttribute("choix", choix);
        model.addAttribute("list",filteredcinema);
        return "cinema";
    }


    @GetMapping("/cinema/new")
    public String createCinemaForm1(Model model) {
        // Créer un objet Cinema
        Cinema cinema = new Cinema();
        model.addAttribute("cinema", cinema);
        return "create_cinema";
    }

    @PostMapping("/cinema")
    public String SaveCinema(@ModelAttribute("cinema") Cinema cinema) {
        cinema.setIsaffected(false);
        cs.saveCinema(cinema);
        return "redirect:/cinema";
    }

    @GetMapping("/cinema/{id}")
    public String DeleteCinema(@PathVariable Integer id) {
        // Récupérer le cinéma à supprimer
        Cinema cinemaToDelete = cs.getCinemaById(id);

        if (cinemaToDelete != null) {
            // Récupérer toutes les salles associées au cinéma à supprimer
            List<Salle> sallesToDelete = cinemaToDelete.getSalles();
            
            // Parcourir chaque salle et supprimer toutes les places associées
            for (Salle salle : sallesToDelete) {
                List<Place> placesToDelete = salle.getPlaces();
                for (Place place : placesToDelete) {
                    // Supprimer chaque place
                    pc.deletePlace(place);
                }
            }

            // Mettre à jour l'attribut isaffected du gestionnaire lié au cinéma à false
           
            
            // Supprimer le cinéma et ses salles
            cs.deleteCinemaAndItsRooms(id);
        }
        
        return "redirect:/cinema";
    }
    @GetMapping("/cinema1/{id}")
    public String DeleteCinema1(@PathVariable Integer id) {
        // Récupérer le cinéma à supprimer
        Cinema cinemaToDelete = cs.getCinemaById(id);

        if (cinemaToDelete != null) {
            // Récupérer toutes les salles associées au cinéma à supprimer
            List<Salle> sallesToDelete = cinemaToDelete.getSalles();
            
            // Parcourir chaque salle et supprimer toutes les places associées
            for (Salle salle : sallesToDelete) {
                List<Place> placesToDelete = salle.getPlaces();
                for (Place place : placesToDelete) {
                    // Supprimer chaque place
                    pc.deletePlace(place);
                }
            }

            // Mettre à jour l'attribut isaffected du gestionnaire lié au cinéma à false
            Gestionnaire gestionnaire = gs.findGestionnaireById(cinemaToDelete.getGestionnaire().getIdgestionnaire());
            if (gestionnaire != null) {
                gestionnaire.setIsaffected(false);
                // Enregistrer les modifications dans la base de données
                gs.saveGestionnaire(gestionnaire);
            }
            
            // Supprimer le cinéma et ses salles
            cs.deleteCinemaAndItsRooms(id);
        }
        
        return "redirect:/cinema";
    }

   

    @GetMapping("/cinema/edit/{id}")
    public String editgestionnaire(@PathVariable Integer id, Model model) {
        model.addAttribute("c", cs.getCinemaById(id));
        return "editcinema";
    }

    @PostMapping("/cinemas/{id}")
    public String updategestionnaire(@PathVariable Integer id,
            @ModelAttribute("x") Cinema cinema, Model model) {
        Cinema c = cs.getCinemaById(id);
        c.setIdcinema(id);
        c.setNom(cinema.getNom());
        c.setAltitude(cinema.getAltitude());
        c.setLatitude(cinema.getLatitude());
        c.setLongitude(cinema.getLongitude());
    
        cs.editCinema(c);
        return "redirect:/cinema";
    }

    @GetMapping("/gestionnaire/search")
    public String searchGestionnaire(@RequestParam String keyword, Model model,@RequestParam String idcinema) {
        List<Gestionnaire> gestionnaires;
        
        
        // Essayez de parser l'entrée comme un ID
        try {
            Integer id = Integer.parseInt(keyword);
            // Si la conversion est réussie, recherchez par ID
            Gestionnaire gestionnaire = gs.findGestionnaireById(id);
            // Si le gestionnaire est trouvé et n'est pas affecté, ajoutez-le à la liste
            if (gestionnaire != null && !gestionnaire.getIsaffected()) {
                gestionnaires = Collections.singletonList(gestionnaire);
            } else {
                gestionnaires = Collections.emptyList();
            }
        } catch (NumberFormatException e) {
            // Si la conversion échoue, recherchez par nom
            List<Gestionnaire> allGestionnaires = gs.searchGestionnaireByNom(keyword);
            // Filtrer les gestionnaires dont l'attribut isAffected est false
            gestionnaires = allGestionnaires.stream()
                                            .filter(gestionnaire -> !gestionnaire.getIsaffected())
                                            .collect(Collectors.toList());
        }
        model.addAttribute("c", cs.getCinemaById(Integer.parseInt(idcinema)));

        model.addAttribute("gestionnaires", gestionnaires);
        return "cinemaaffectation"; // Vue pour afficher la liste des gestionnaires
    }
    @GetMapping("/cinema/affectation/{id}")
    public String affecterCinema(@PathVariable Integer id,
             Model model) {
    	Cinema c = cs.getCinemaById(id);
        model.addAttribute("ca", c);
        model.addAttribute("c", c);
        
        // Récupérez la liste des gestionnaires et filtrez-les
        List<Gestionnaire> gestionnaires = gs.getAllGestionnaires();
        List<Gestionnaire> filteredGestionnaire = gestionnaires.stream()
                                             .filter(g -> !g.getIsaffected())
                                             .collect(Collectors.toList());
        model.addAttribute("gestionnaires", filteredGestionnaire);
        
        return "cinemaaffectation";
    }
    
    @PostMapping("/cinemaaffectation/{id}")
    public String affecterCinemaaction(@PathVariable Integer id,
            @ModelAttribute("v") Cinema cinema, Model model,@RequestParam String x) {
         Integer i =Integer.parseInt(x); 
        Cinema c = cs.getCinemaById(id);
    	Gestionnaire g= gs.findGestionnaireById(i);
   g.setIsaffected(true);

     
        c.setGestionnaire(g);
        c.setIsaffected(true);
        cs.editCinema(c);
        List<Gestionnaire> gestionnaires = gs.getAllGestionnaires();
        List<Gestionnaire> filteredGestionnaire = gestionnaires.stream()
                                             .filter(ges -> !ges.getIsaffected())
                                             .collect(Collectors.toList());
        model.addAttribute("gestionnaires", filteredGestionnaire);
        model.addAttribute("ca", c);
        model.addAttribute("c", c);
    
        
        return "redirect:/cinema";
    }
    @GetMapping("/Acceuil")
    public String affecterCinema(Model model) {
    	return "Accueil";
    }
    
 
    
}
