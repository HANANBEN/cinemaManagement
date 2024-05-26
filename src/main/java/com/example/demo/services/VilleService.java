package com.example.demo.services;


import java.util.List;

import com.example.demo.entities.*;

public interface VilleService {
    List<Ville> getAllVilles();
    Ville saveVille(Ville ville);
    Ville editVille(Ville ville);

    Ville getVilleById(String nom);

    void deleteVille(Ville ville);
    Long countVille();
}
