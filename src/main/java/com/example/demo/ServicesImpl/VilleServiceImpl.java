package com.example.demo.ServicesImpl;

import org.springframework.stereotype.Service;

import com.example.demo.entities.Ville;
import com.example.demo.repository.VilleRepository;
import com.example.demo.services.VilleService;

import java.util.List;
@Service
public class VilleServiceImpl implements VilleService {

    VilleRepository villerep;

    @Override
    public List<Ville> getAllVilles() {
        return villerep.findAll();
    }

    @Override
    public Ville saveVille(Ville ville) {
        return villerep.save(ville) ;
    }

    @Override
    public Ville editVille(Ville ville) {
        return villerep.save(ville);
    }

    @Override
    public Ville getVilleById(String  nom) {
        return villerep.findBynom(nom);
    }

    @Override
    public void deleteVille(Ville ville) {
        villerep.delete(ville);
    }

    @Override
    public Long countVille() {
        return villerep.count();
    }
}
