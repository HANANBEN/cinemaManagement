package com.example.demo.Services;

import com.example.demo.Entities.*;


import java.time.Duration;
import java.time.LocalTime;
import java.util.List;
import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public interface FilmService {
    public List<Film> getAllFilms();
    Film saveFilm(String titre,LocalTime duree
    		,String realisateur, String description,MultipartFile file
    	    			,Date datesortie ,Categorie categorie);
    public Film getFilmById(Integer id);
    public Film  editFilm(Film film);
    public Long countFilm();
    public void deleteFilmById(Integer id);
    Film saveFilminDB (Film fil);
    Film findByTitle(String titre);
}
