package com.example.demo.services;

import java.util.List;

import com.example.demo.entities.Film;
import com.example.demo.entities.SuperAdmin;

public interface FilmService {
    public List<Film> getAllFilms();
    public  Film saveFilm(Film film);
    public Film getFilmById(Integer id);
    public Film  editFilm(Film film);
    public Long countFilm();
    public void deleteFilmById(Integer id);
}
