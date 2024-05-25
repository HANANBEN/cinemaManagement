package web.ServicesImpl;

import web.Entities.Seance;
import web.Repositories.FilmRepository;
import web.Repositories.SeanceRepository;
import web.Services.SeanceService;

import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class SeanceServiceImpl implements SeanceService {
    private SeanceRepository seancerep;
    @Override
    public List<Seance> getAllSeances() {
        return  seancerep.findAll();
    }

    @Override
    public Seance saveSeance(Seance seance) {
        return seancerep.save(seance);
    }

    @Override
    public Seance getSeanceById(Integer id) {
        return seancerep.findById(id).get();
    }

    @Override
    public Seance editSeance(Seance seance) {
        return seancerep.save(seance);
    }

    @Override
    public Long countSeance() {
        return seancerep.count();
    }

    @Override
    public void deleteSeanceById(Integer id) {
        seancerep.deleteById(id);
    }
}
