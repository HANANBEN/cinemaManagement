package com.example.demo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entities.Gestionnaire;
import com.example.demo.entities.Salle;

@Service
public interface GestionnaireService {
    public List<Gestionnaire> getAllGestionnaires();
    public  Gestionnaire saveGestionnaire(Gestionnaire gestionnaire);
    public Gestionnaire getGestionnaireById(Integer  id);
    public Long countGestionnaire();
    public void deleteGestionnaireById(Integer id);
	Gestionnaire editGestionnaire(Gestionnaire gestionnaire);
}
