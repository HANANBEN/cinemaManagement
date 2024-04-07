package Services.Impl;

import Entities.Ville;
import Repositories.VilleRepository;
import Services.VilleService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class VilleServiceImpl implements VilleService {

    VilleRepository villerep;

    @Override
    public List<Ville> getAllVilles() {
        return villerep.findAll();
    }

    @Override
    public Ville saveVille(Ville ville) {
        return villerep.save(ville) ;
    }

    @Override
    public Ville editVille(Ville ville) {
        return villerep.save(ville);
    }

    @Override
    public Ville getVilleById(String  nom) {
        return villerep.findBynom(nom);
    }

    @Override
    public void deleteVille(Ville ville) {
        villerep.delete(ville);
    }

    @Override
    public Long countVille() {
        return villerep.count();
    }
}
