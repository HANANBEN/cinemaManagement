package com.example.demo.Controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalTime;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.Entities.Categorie;
import com.example.demo.Entities.Film;
import com.example.demo.Services.CategorieService;
import com.example.demo.Services.FilmService;

@Controller
public class FilmController {

	
	
    

	public FilmController() {
		super();
	}

	public FilmController(CategorieService categorieServ) {
		super();
		this.categorieServ = categorieServ;
	}

	public FilmController(FilmService filmser) {
		super();
		this.filmser = filmser;
	}

	public FilmController(FilmService filmser, CategorieService categorieServ) {
		super();
		this.filmser = filmser;
		this.categorieServ = categorieServ;
	}

	@Autowired
    private FilmService filmser;

    @Autowired
    private CategorieService categorieServ;

    @GetMapping("/films")
    public String ShowinscriptionForm(Model model) {
        List<Film> films = filmser.getAllFilms();
        model.addAttribute("films", films);
        return "/films.html";
    }

    @GetMapping("/addFilm")
    public String showAddProduct(Model model) {
        List<Categorie> categories = categorieServ.getAllCategories();
        List<String> nomDesCategories = categories.stream()
                .map(Categorie::getNom)
                .collect(Collectors.toList());
        model.addAttribute("nomCategories", nomDesCategories);
        return "/addFilm.html";
    }

    @PostMapping("/addFilm")
    public String saveFilminDB(@RequestParam("file") MultipartFile file,
                               @RequestParam("titre") String titre,
                               @RequestParam("hours") int hours,
                               @RequestParam("minutes") int minutes,
                               @RequestParam("realisateur") String realisateur,
                               @RequestParam("description") String description,
                               @RequestParam("datesortie") @DateTimeFormat(pattern = "yyyy-MM-dd") Date datesortie,
                               @RequestParam("categorie") String categorie) {
        Categorie c = categorieServ.getCategorieById(categorie);
        
        // Construct LocalTime object from hours and minutes
        LocalTime dure = LocalTime.of(hours, minutes);
        
        filmser.saveFilm(titre, dure, realisateur, description, file, datesortie, c);
        return "redirect:/films";
    }

    @GetMapping("/film/delete/{id}")
    public String DeleteFilm(@PathVariable Integer id) {
        // Récupérer le cinéma à supprimer
      Film cinemaToDelete = filmser.getFilmById(id);

        if (cinemaToDelete != null) {
            // Récupérer toutes les salles associées au cinéma à supprimer
           
            // Mettre à jour l'attribut isaffected du gestionnaire lié au cinéma à false
        	cinemaToDelete.setCategorie(null);
            // Supprimer le cinéma et ses salles
            
        }
        
        filmser.deleteFilmById(id);
        
        return "redirect:/films";
    }
    

    @GetMapping("/film/edit/{id}")
    public String editFilm(@PathVariable Integer id , Model model) {
    	 model.addAttribute("film", filmser.getFilmById(id));
    	 List<Categorie> categories = categorieServ.getAllCategories();
      
         model.addAttribute("nomCategories",categories);
         return "editfilm";
    	   }
    @PostMapping("/film/edit/{id}")
    public String updatefilm(@PathVariable Integer id,
            @ModelAttribute("film") Film film, Model model ,@RequestParam MultipartFile file ,
            @RequestParam("datesortie") @DateTimeFormat(pattern = "yyyy-MM-dd") Date datesortie,
            @RequestParam("categorie") String categorie , @RequestParam("hours") int hours,
            @RequestParam("minutes") int minutes) {
        // Récupérer le film existant
    	
    	LocalTime dure = LocalTime.of(hours, minutes);
    	
    	
    	
        Film existingFilm = filmser.getFilmById(id);
        existingFilm.setIdfilm(id);
       
       Film fil= filmser.saveFilm(film.getTitre(), dure, film.getRealisateur(), film.getDescription(), file, datesortie, categorieServ.getCategorieById(categorie));
        // Mettre à jour les autres champs du film
        existingFilm.setTitre(film.getTitre());
        existingFilm.setRealisateur(film.getRealisateur());
        existingFilm.setDescription(film.getDescription());
        existingFilm.setDatesortie(fil.getDatesortie());
        existingFilm.setPhoto(fil.getPhoto());
        
        
        // Mettre à jour la catégorie du film
      
        existingFilm.setCategorie(fil.getCategorie());

        // Mettre à jour la durée du film
     
        existingFilm.setDuree(fil.getDuree());

        // Enregistrer les modifications du film dans la base de données
       
        filmser.deleteFilmById(fil.getIdfilm());
        

        return "redirect:/films";
    }

    }
    

