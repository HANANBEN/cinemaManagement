package web.ServicesImpl;

import web.Entities.Gestionnaire;
import web.Repositories.GestionnaireRepository;
import web.Services.GestionnaireService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
