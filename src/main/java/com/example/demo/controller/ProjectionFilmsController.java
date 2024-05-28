package com.example.demo.controller;

import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entities.Categorie;
import com.example.demo.entities.Film;
import com.example.demo.entities.Projectionfilm;
import com.example.demo.entities.Salle;
import com.example.demo.entities.Seance;
import com.example.demo.services.FilmService;
import com.example.demo.services.LoginService;
import com.example.demo.services.ProjectionfilmService;
import com.example.demo.services.SalleService;
import com.example.demo.services.SeanceService;

import jakarta.servlet.http.HttpSession;

@Controller

public class ProjectionFilmsController {
	 @Autowired
	    private SalleService 	salleserv; 
	

	 @Autowired
	    private ProjectionfilmService projectionfilmserv; 
	 
	 @Autowired
	    private FilmService filmserv;
	 
	 @Autowired
	    private SeanceService seanceserv;; 
	 @GetMapping("/projections")
	    public String ShowinscriptionForm(Model model) {
	        List<Projectionfilm> projections = projectionfilmserv.getAllProjections();
	        model.addAttribute("projections", projections);
	        return "/projections.html";
	    }
	 @GetMapping("/addProjection")
	    public String showAddProjection(Model model) {
	        List<Film > films = filmserv.getAllFilms();
	        List<String> nomDesFilms = films.stream()
	                .map(Film::getTitre)
	                .collect(Collectors.toList());
	        model.addAttribute("nomDesFilms", nomDesFilms);
	        return "/addProjection.html";
	    }
	 
	 @PostMapping("/addProjection")
	    public String saveFilminDB(
	                             
	                              
	                               @RequestParam("prix") double prix,
	                              
	                               @RequestParam("dateprojection") @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateprojection,
	                               @RequestParam("film") String film) {
	        Film c = filmserv.findByTitle(film);
	        
	        Projectionfilm pr=new Projectionfilm(dateprojection,prix,c);
	        projectionfilmserv.saveProjectionfilm(pr);
	        return "redirect:/projections";
	    }


	 @GetMapping("/projection/projeter/{id}")
	    public String showProjectionForm(@PathVariable Integer id, Model model, @RequestParam(required = false) Integer i) {
	        Projectionfilm pr = projectionfilmserv.getProjectionfilmById(id);
	        model.addAttribute("projectionfilm", pr);
	        if (i != null) {
	            model.addAttribute("i", i);
	            model.addAttribute("message", "Aucune salle n'est disponible pour cette date et ces horaires de séance.");
	            

	        }
	        return "/projeterfilm.html";
	    }

	    @PostMapping("/projection/projeter/{id}")
	    public String showProjectionForm2(@PathVariable Integer id, Model model,
	                                       @RequestParam("start_time") String start_time,
	                                       @RequestParam("end_time") String end_time,
	                                       @RequestParam("dateprojection") @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateprojection) {
	        Projectionfilm projectionfilm = projectionfilmserv.getProjectionfilmById(id);
	        LocalTime starttime = LocalTime.parse(start_time, DateTimeFormatter.ofPattern("HH:mm"));
	        LocalTime endtime = LocalTime.parse(end_time, DateTimeFormatter.ofPattern("HH:mm"));
	        List<Salle> autresSalles = new ArrayList<>();
	        List<Salle> sallesDeLaSeance = new ArrayList<>();
	        Duration dureeInput = Duration.between(starttime, endtime);

	        List<Seance> seances = seanceserv.findByProjectionfilmDateprojection(dateprojection);
	        List<Salle> toutesSalles = salleserv.getAllSalles();
	        for (Seance seance : seances) {
	           
	        	sallesDeLaSeance.add(seance.getSalle());
	        }
	        boolean hasOverlap = false; // Track if there's any overlap

	        for (Seance seance : seances) {
	            LocalTime seanceStart = seance.getHeuredebut();
	            LocalTime seanceEnd = seance.getHeurefin();

	            // Check if there's any overlap with the existing slot
	            if ((starttime.isAfter(seanceStart) || starttime.equals(seanceStart)) && starttime.isBefore(seanceEnd)) {
	                hasOverlap = true;
	                break;
	            }

	            if ((endtime.isAfter(seanceStart)) && endtime.isBefore(seanceEnd)) {
	                hasOverlap = true;
	                break;
	            }

	            if (seanceStart.isAfter(starttime) && seanceEnd.isBefore(endtime)) {
	                hasOverlap = true;
	                break;
	            }
	            if (!hasOverlap && !autresSalles.contains(seance.getSalle())) {
	            	
		            autresSalles.add(seance.getSalle());
		        }

	        }

	        // Add the salle only if there's no overlap
	       
	        List<Salle> sallesDisponibles = toutesSalles.stream()
	                .filter(salle -> !sallesDeLaSeance.contains(salle))
	                .collect(Collectors.toList());
	     
	        autresSalles.addAll(sallesDisponibles);
	        
	        if (autresSalles.isEmpty()) {
	            return "redirect:/projection/projeter/{id}?i=1";
	        } else {
	            List<String> numDesSalles = autresSalles.stream()
	                    .map(Salle::getNom)
	                    .collect(Collectors.toList());
	            model.addAttribute("numDesSalles", numDesSalles);
	            model.addAttribute("projectionfilm", projectionfilm);
	            model.addAttribute("starttime", starttime);
	            model.addAttribute("endtime", endtime);
	            return "/nextprojeterfilm.html";
	        }
	    }
	 
	 
	 @PostMapping("/projeterlefilm")
	 public String projecterfilm( @RequestParam String salle, @RequestParam String starttime, @RequestParam String endtime, @RequestParam int filmId, Model model)
	 {
		 
		 Projectionfilm projectionfilm=projectionfilmserv.getProjectionfilmById(filmId);
		 
		 LocalTime start_time = LocalTime.parse(starttime, DateTimeFormatter.ofPattern("HH:mm"));
	        LocalTime end_time = LocalTime.parse(endtime, DateTimeFormatter.ofPattern("HH:mm"));
		     // Add attributes to model if needed for further processing
		 
		Salle salle2=salleserv.findSallebyNom(salle);
		salle2.setIsconfig(true);
		salle2.setIsdispo(false);
		
	seanceserv.saveSeance(new Seance(start_time, end_time , projectionfilm , salle2));
		     // Redirect or return a view
		     return "redirect:/Acceuil";
		 }
	
	 
	public ProjectionFilmsController(ProjectionfilmService projectionfilmserv, FilmService filmserv) {
		super();
		this.projectionfilmserv = projectionfilmserv;
		this.filmserv = filmserv;
	}
	public ProjectionFilmsController(FilmService filmserv) {
		super();
		this.filmserv = filmserv;
	}
	public ProjectionFilmsController(ProjectionfilmService projectionfilmserv) {
		super();
		this.projectionfilmserv = projectionfilmserv;
	}
	public ProjectionFilmsController() {
		super();
	}
	
	@GetMapping("/projection/edit/{id}")
    public String showEditProjectionForm(@PathVariable Integer id, Model model) {
        Projectionfilm projection = projectionfilmserv.getProjectionfilmById(id);
            model.addAttribute("projection", projection);
            return "editProjection.html"; // Nom du template Thymeleaf pour le formulaire d'édition
      
    }
	@PostMapping("/projection/edit/{id}")
    public String updateProjection(@PathVariable Integer id,
                                   @RequestParam("dateprojection") @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateprojection,
                                   @RequestParam("prix") double prix,
                                   @RequestParam("film") String filmTitle) {
        Projectionfilm projection = projectionfilmserv.getProjectionfilmById(id);
       
            Film film = filmserv.findByTitle(filmTitle);
            projection.setDateprojection(dateprojection);
            projection.setPrix(prix);
            projection.setFilm(film);
            projectionfilmserv.saveProjectionfilm(projection);
            return "redirect:/projections";
      
    }
	  @GetMapping("/projection/delete/{id}")
	    public String deleteProjection(@PathVariable Integer id ) {
		Projectionfilm profilm=  projectionfilmserv.getProjectionfilmById(id);
		List<Seance> listSeance= seanceserv.findByProjectionfilm(profilm);
		for (Seance seance : listSeance) {
	        // Set salle's availability to true
	        Salle salle = seance.getSalle();
	        salle.setIsdispo(true);
	        salleserv.saveSalle(salle);

	        // Delete the Seance
	        seanceserv.deleteSeanceById(seance.getIdseance());
	    }
	        projectionfilmserv.deleteProjectionfilmById(id);
	        
	        return "redirect:/projections";
	    } 
	 @PostMapping("/filmProjevction/search")
	    public String searchProjections(@RequestParam(required = false) String query,
	                                    @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateprojection,
	                                    Model model) {
	        List<Projectionfilm> projections;
	        if (query != null && !query.isEmpty() && dateprojection != null) {
	            projections = projectionfilmserv.findByFilmTitreAndDateprojection(query, dateprojection);
	        } else if (query != null && !query.isEmpty()) {
	            projections = projectionfilmserv.findByFilmTitre(query);
	        } else if (dateprojection != null) {
	            projections = projectionfilmserv.findByDateprojection(dateprojection);
	        } else {
	            projections = projectionfilmserv.getAllProjections();
	        }
	        model.addAttribute("projections", projections);
	        return "/projections.html";
	    }
	
	
}
