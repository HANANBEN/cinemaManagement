package com.example.demo.services;

import java.util.List;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Cinema;
import com.example.demo.entities.SuperAdmin;


public interface CinemaService {
    public List<Cinema> getAllCinemas();
    public  Cinema saveCinema(Cinema cinema);
    public Cinema getCinemaById(Integer id);
    public Cinema editCinema(Cinema cinema);
    public Long countCinema();
    public void deleteCinemaById(Integer id);
    public void deleteCinemaAndItsRooms(int cinemaId);
	public Integer countSallesInCinema(Integer cinemaId);
}
