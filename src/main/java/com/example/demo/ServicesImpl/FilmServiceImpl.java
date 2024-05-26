package com.example.demo.ServicesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.Duration;
import java.time.LocalTime;

import com.example.demo.entities.*;
import com.example.demo.repository.FilmRepository;
import com.example.demo.services.FilmService;

import java.util.Base64;
import java.util.Date;
import java.util.List;

@Service
public class FilmServiceImpl implements FilmService {
    private FilmRepository filmrep;
    
    
    @Autowired
	public FilmServiceImpl(FilmRepository filmrep) {
		super();
		this.filmrep = filmrep;
	}

public FilmServiceImpl() {
	super();
}


    @Override
    public List<Film> getAllFilms() {
        return  filmrep.findAll();
    }

    @Override
    public Film saveFilm(String titre,LocalTime duree
    		,String realisateur, String description,MultipartFile file
    	    			,Date datesortie ,Categorie categorie) { 
    	
    		Film film = new Film();
    		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
    		if(fileName.contains(".."))
    		{
    			System.out.println("not a a valid file");
    		}
    		try {
    			film.setPhoto(Base64.getEncoder().encodeToString(file.getBytes()));
    		} catch (IOException e) {
    			e.printStackTrace();
    		}
    		film.setTitre(titre);
    	film.setDescription(description);
    	film.setRealisateur(realisateur);
    	film.setDuree(duree);
    	film.setCategorie(categorie);
    	film.setDatesortie(datesortie);
    
       Film f=filmrep.save(film);
    	
        return f;
    }
    public Film findByTitle(String titre) {
        return filmrep.findByTitre(titre);
    }

   @Override
    public Film getFilmById(Integer id) {
        return filmrep.findById(id).get();
    }

    @Override
    public Film editFilm(Film film) {
        return filmrep.save(film);
    }

    @Override
    public Long countFilm() {
        return filmrep.count();
    }

    @Override
    public void deleteFilmById(Integer id) {
              filmrep.deleteById(id);
    }

	@Override
	public Film saveFilminDB(Film fil) {
		// TODO Auto-generated method stub
		return filmrep.save(fil);
	}

    
    
}
