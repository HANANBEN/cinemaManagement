package com.example.demo.services;

import java.util.List;

import com.example.demo.entities.Boulvard;
import com.example.demo.entities.Categorie;

public interface BoulvardService
{
    public List<Boulvard> getAllBoulvards();
    public  Boulvard  saveBoulvard(Boulvard boulvard);
    public Boulvard getBoulvardById(String id);
    public Boulvard editBoulvard(Boulvard boulvard);
    public Long countBoulvard();
    public void deleteBoulvardById(String id);
}
