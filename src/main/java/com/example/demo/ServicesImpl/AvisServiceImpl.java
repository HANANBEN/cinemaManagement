package com.example.demo.ServicesImpl;

import org.springframework.stereotype.Service;

import com.example.demo.Entities.Avis;
import com.example.demo.Repositories.AvisRepository;
import com.example.demo.Services.AvisService;

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
