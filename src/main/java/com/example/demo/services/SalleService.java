package com.example.demo.services;

import java.util.List;

import com.example.demo.entities.Salle;
import com.example.demo.entities.SuperAdmin;

public interface SalleService {
    public List<Salle> getAllSalles();
    public  Salle saveSalle(Salle salle);
    public Salle getSalleById(Integer id);
    public Salle editSalle(Salle salle);
    public Long countSalle();
    public void deleteSalleById(Integer id);
}
