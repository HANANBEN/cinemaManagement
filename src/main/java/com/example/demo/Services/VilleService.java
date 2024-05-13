package com.example.demo.Services;


import com.example.demo.Entities.*;

import java.util.List;

public interface VilleService {
    List<Ville> getAllVilles();
    Ville saveVille(Ville ville);
    Ville editVille(Ville ville);

    Ville getVilleById(String nom);

    void deleteVille(Ville ville);
    Long countVille();
}
