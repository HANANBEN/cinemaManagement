package com.example.demo.services;

import java.util.List;

import com.example.demo.entities.*;

public interface CinemaService {
    public List<Cinema> getAllCinemas();
    public  Cinema saveCinema(Cinema cinema);
    public Cinema getCinemaById(Integer id);
    public Cinema editCinema(Cinema cinema);
    public Long countCinema();
    public void deleteCinemaById(Integer id);
}
