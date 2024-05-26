package com.example.demo.ServicesImpl;

import org.springframework.stereotype.Service;

import com.example.demo.entities.Boulvard;
import com.example.demo.repository.BoulvardRepository;
import com.example.demo.services.BoulvardService;

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
    public Boulvard editBoulvard(Boulvard boulvard) {
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
