package web.Services;


import java.util.List;

import web.Entities.Quartier;

public interface QuartierService {
    List<Quartier> getAllQuartiers();
    Quartier saveQuartier(Quartier quartier);
    Quartier editQuartier(Quartier quartier);

    Quartier getQuartierById(String nom);

    void deleteQuartier(Quartier quartier);
    Long countQuartier();
}
