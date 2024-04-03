package Services;


import Entities.Quartier;

import java.util.List;

public interface QuartierService {
    List<Quartier> getAllQuartiers();
    Quartier saveQuartier(Quartier quartier);
    Quartier editQuartier(Quartier quartier);

    Quartier getQuartierById(String nom);

    void deleteQuartier(Quartier quartier);
    Long countQuartier();
}
