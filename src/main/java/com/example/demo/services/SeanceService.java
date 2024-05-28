package com.example.demo.services;

import java.util.Date;
import java.util.List;

import com.example.demo.entities.*;

public interface SeanceService {
    public List<Seance> getAllSeances();
    public Seance saveSeance(Seance seance);
    public Seance getSeanceById(Integer id);
    public Seance  editSeance(Seance seance);
    public Long countSeance();
    public void deleteSeanceById(Integer id);
    List<Seance> findByProjectionfilmDateprojection(Date date);
    List<Seance> findByProjectionfilm(Projectionfilm projfilm);
}
