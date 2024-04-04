package Services.Impl;

import Entities.Boulvard;
import Repositories.BoulvardRepository;
import Services.BoulvardService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class BoulvardServiceImpl implements BoulvardService {
    private BoulvardRepository boulvardrep;
    @Override
    public List<Boulvard> getAllBoulvards() {
        return boulvardrep.findAll();
    }

    @Override
    public Boulvard saveBoulvard(Boulvard boulvard) {
        return boulvardrep.save(boulvard);
    }

    @Override
    public Boulvard getBoulvardById(String id) {
        return boulvardrep.findById(id).get();
    }

    @Override
    public Boulvard editCategorie(Boulvard boulvard) {
        return boulvardrep.save(boulvard);
    }

    @Override
    public Long countBoulvard() {
        return boulvardrep.count();
    }

    @Override
    public void deleteBoulvardById(String id) {
        boulvardrep.deleteById(id);
    }
}
