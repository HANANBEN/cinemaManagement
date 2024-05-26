package com.example.demo.ServicesImpl;

import org.springframework.stereotype.Service;

import com.example.demo.entities.*;
import com.example.demo.repository.QuartierRepository;
import com.example.demo.services.QuartierService;

import java.util.List;
@Service
public class QuartierServiceImpl implements QuartierService {
    QuartierRepository quartierrep;
    @Override
    public List<Quartier> getAllQuartiers() {
        return quartierrep.findAll();
    }

    @Override
    public Quartier saveQuartier(Quartier quartier) {
        return quartierrep.save(quartier);
    }

    @Override
    public Quartier editQuartier(Quartier quartier) {
        return quartierrep.save(quartier);
    }

    @Override
    public Quartier getQuartierById(String nom) {
        return quartierrep.findBynom(nom);
    }

    @Override
    public void deleteQuartier(Quartier quartier) {
        quartierrep.delete(quartier);
    }

    @Override
    public Long countQuartier() {
        return quartierrep.count();
    }
}
