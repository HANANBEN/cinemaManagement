package com.example.demo.Services;

import com.example.demo.Entities.*;

import java.util.List;

import com.example.demo.Entities.Avis;

public interface AvisService {
    public List<Avis> getAllAvis();
    public  Avis saveAvis(Avis avis );
    public Avis getAvisById(Integer id);
    public Avis  editAvis(Avis avis);
    public Long countAvis();
    public void deleteAvisById(Integer id);
}
