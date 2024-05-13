package com.example.demo.Services;
import com.example.demo.Entities.*;

import java.util.List;

import com.example.demo.Entities.Boulvard;

public interface BoulvardService
{
    public List<Boulvard> getAllBoulvards();
    public  Boulvard  saveBoulvard(Boulvard boulvard);
    public Boulvard getBoulvardById(String id);
    public Boulvard editBoulvard(Boulvard boulvard);
    public Long countBoulvard();
    public void deleteBoulvardById(String id);
}
