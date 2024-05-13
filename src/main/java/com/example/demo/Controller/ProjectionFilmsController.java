package com.example.demo.Controller;

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

import com.example.demo.Entities.Categorie;
import com.example.demo.Entities.Film;
import com.example.demo.Entities.Projectionfilm;
import com.example.demo.Entities.Salle;
import com.example.demo.Entities.Seance;
import com.example.demo.Services.FilmService;
import com.example.demo.Services.LoginService;
import com.example.demo.Services.ProjectionfilmService;
import com.example.demo.Services.SeanceService;

import jakarta.servlet.http.HttpSession;

@Controller

public class ProjectionFilmsController {

	
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

	        Duration dureeInput = Duration.between(starttime, endtime);

	        List<Seance> seances = seanceserv.findByProjectionfilmDateprojection(dateprojection);

	        for (Seance seance : seances) {
	            Duration dureeSeance = Duration.between(seance.getHeuredebut(), seance.getHeurefin());
	            if (dureeSeance.compareTo(dureeInput) != 0) {
	                autresSalles.add(seance.getSalle());
	                break; // Nous avons trouvé une séance avec la même durée, inutile de continuer la boucle
	            }
	        }

	        if (autresSalles.isEmpty()) {
	            return "redirect:/projection/projeter/{id}?i=1";
	        } else {
	            List<String> numDesSalles = autresSalles.stream()
	                    .map(Salle::getNom)
	                    .collect(Collectors.toList());
	            model.addAttribute("numDesSalles", numDesSalles);
	            model.addAttribute("projectionfilm", projectionfilm);
	            return "/nextprojeterfilm.html";
	        }
	    }
	 
	 
	 @PostMapping("/projeterlefilm")
	 public String projecterfilm(Model model)
	 {
		 return "hhh";
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

	
	
}
