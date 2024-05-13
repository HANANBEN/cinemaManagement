package com.example.demo.Services;

import com.example.demo.Entities.*;

import java.util.List;

public interface GestionnaireService {
    public List<Gestionnaire> getAllGestionnaires();
    public  Gestionnaire saveGestionnaire(Gestionnaire gestionnaire);
    public Gestionnaire getGestionnaireById(Integer  id);
    public Gestionnaire editSalle(Gestionnaire gestionnaire);
    public Long countGestionnaire();
    public void deleteGestionnaireById(Integer id);
}
