package com.example.demo.services;

import java.util.List;

import com.example.demo.entities.*;

public interface GestionnaireService {
    public List<Gestionnaire> getAllGestionnaires();
    public  Gestionnaire saveGestionnaire(Gestionnaire gestionnaire);
    public Gestionnaire getGestionnaireById(Integer  id);
    public Gestionnaire editSalle(Gestionnaire gestionnaire);
    public Long countGestionnaire();
    public void deleteGestionnaireById(Integer id);
}
