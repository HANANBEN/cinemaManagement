package com.example.demo.ServicesImpl;

import org.springframework.stereotype.Service;

import com.example.demo.entities.Seance;
import com.example.demo.repository.FilmRepository;
import com.example.demo.repository.SeanceRepository;
import com.example.demo.services.SeanceService;

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
