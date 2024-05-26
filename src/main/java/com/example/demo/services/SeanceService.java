package com.example.demo.services;

import java.util.List;

import com.example.demo.entities.Film;
import com.example.demo.entities.Seance;

public interface SeanceService {
    public List<Seance> getAllSeances();
    public Seance saveSeance(Seance seance);
    public Seance getSeanceById(Integer id);
    public Seance  editSeance(Seance seance);
    public Long countSeance();
    public void deleteSeanceById(Integer id);
}
