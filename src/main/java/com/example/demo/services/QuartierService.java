package com.example.demo.services;


import java.util.List;

import com.example.demo.entities.Quartier;

public interface QuartierService {
    List<Quartier> getAllQuartiers();
    Quartier saveQuartier(Quartier quartier);
    Quartier editQuartier(Quartier quartier);

    Quartier getQuartierById(String nom);

    void deleteQuartier(Quartier quartier);
    Long countQuartier();
}
