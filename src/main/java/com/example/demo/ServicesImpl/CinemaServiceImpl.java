package com.example.demo.ServicesImpl;

import com.example.demo.Entities.*;

import org.springframework.stereotype.Service;

import com.example.demo.Repositories.CinemaRepository;
import com.example.demo.Services.CinemaService;

import java.util.List;

@Service
public class CinemaServiceImpl implements CinemaService {
     private CinemaRepository cinemarep;
    @Override
    public List<Cinema> getAllCinemas() {
        return cinemarep.findAll();
    }

    @Override
    public Cinema saveCinema(Cinema cinema) {
        return cinemarep.save(cinema);
    }

    @Override
    public Cinema getCinemaById(Integer id) {
        return cinemarep.findById(id).get();
    }

    @Override
    public Cinema editCinema(Cinema cinema) {
        return cinemarep.save(cinema);
    }

    @Override
    public Long countCinema() {
        return cinemarep.count();
    }

    @Override
    public void deleteCinemaById(Integer id) {
        cinemarep.deleteById(id);

    }
}
