package com.example.demo.Services;

import com.example.demo.Entities.*;

import java.util.List;

public interface SalleService {
    public List<Salle> getAllSalles();
    public  Salle saveSalle(Salle salle);
    public Salle getSalleById(Integer id);
    public Salle editSalle(Salle salle);
    public Long countSalle();
    public void deleteSalleById(Integer id);
}
