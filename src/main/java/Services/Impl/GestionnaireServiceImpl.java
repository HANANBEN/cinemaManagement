package Services.Impl;

import Entities.Gestionnaire;
import Repositories.GestionnaireRepository;
import Services.GestionnaireService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GestionnaireServiceImpl implements GestionnaireService {
    private GestionnaireRepository gestionnairerep;
    @Override
    public List<Gestionnaire> getAllGestionnaires() {
        return gestionnairerep.findAll();
    }

    @Override
    public Gestionnaire saveGestionnaire(Gestionnaire gestionnaire) {
        return gestionnairerep.save(gestionnaire);
    }

    @Override
    public Gestionnaire getGestionnaireById(Integer  id) {
        return gestionnairerep.findById(id).get();
    }

    @Override
    public Gestionnaire editSalle(Gestionnaire gestionnaire) {
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
