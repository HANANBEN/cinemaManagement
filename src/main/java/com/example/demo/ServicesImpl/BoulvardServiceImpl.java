package com.example.demo.ServicesImpl;

import org.springframework.stereotype.Service;

import com.example.demo.Entities.Boulvard;
import com.example.demo.Repositories.BoulvardRepository;
import com.example.demo.Services.BoulvardService;

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
