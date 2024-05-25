package web.Services;


import java.util.List;

import web.Entities.Ville;

public interface VilleService {
    List<Ville> getAllVilles();
    Ville saveVille(Ville ville);
    Ville editVille(Ville ville);

    Ville getVilleById(String nom);

    void deleteVille(Ville ville);
    Long countVille();
}
