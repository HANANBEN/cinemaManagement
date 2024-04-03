package Services.Impl;

import Entities.Avis;
import Repositories.AvisRepository;
import Services.AvisService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AvisServiceImpl  implements AvisService {
    private AvisRepository avisrep;
    @Override
    public List<Avis> getAllAvis() {
        return avisrep.findAll();
    }

    @Override
    public Avis saveAvis(Avis avis) {
        return  avisrep.save(avis);
    }

    @Override
    public Avis getAvisById(Integer id) {
        return avisrep.findById(id).get();
    }

    @Override
    public Avis editAvis(Avis avis) {
        return  avisrep.save(avis);
    }

    @Override
    public Long countAvis() {
        return avisrep.count();
    }

    @Override
    public void deleteAvisById(Integer id) {
        avisrep.deleteById(id);

    }
}
