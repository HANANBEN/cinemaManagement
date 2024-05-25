package web.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import web.Entities.Gestionnaire;
import web.Entities.Salle;

@Service
public interface GestionnaireService {
    public List<Gestionnaire> getAllGestionnaires();
    public  Gestionnaire saveGestionnaire(Gestionnaire gestionnaire);
    public Gestionnaire getGestionnaireById(Integer  id);
    public Long countGestionnaire();
    public void deleteGestionnaireById(Integer id);
	Gestionnaire editGestionnaire(Gestionnaire gestionnaire);
}
