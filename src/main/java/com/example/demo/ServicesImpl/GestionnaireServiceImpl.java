package com.example.demo.ServicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Gestionnaire;
import com.example.demo.repository.GestionnaireRepository;
import com.example.demo.services.GestionnaireService;

import java.util.List;

@Service
public class GestionnaireServiceImpl implements GestionnaireService {
    private final GestionnaireRepository gestionnairerep;

    
    public GestionnaireServiceImpl(GestionnaireRepository gestionnairerep) {
        this.gestionnairerep = gestionnairerep;
    }

    @Override
    public List<Gestionnaire> getAllGestionnaires() {
        return gestionnairerep.findAll();
    }

    @Override
    public Gestionnaire saveGestionnaire(Gestionnaire gestionnaire) {
        return gestionnairerep.save(gestionnaire);
    }

    @Override
    public Gestionnaire getGestionnaireById(Integer id) {
        return gestionnairerep.findById(id).get();
    }
    

    @Override
    public Gestionnaire editGestionnaire(Gestionnaire gestionnaire) {
        return gestionnairerep.save(gestionnaire);
    }

    @Override
    public Long countGestionnaire() {
        return gestionnairerep.count();
    }

    @Override
    public void deleteGestionnaireById(Integer id) {
        gestionnairerep.deleteById(id);
    }
   
}
