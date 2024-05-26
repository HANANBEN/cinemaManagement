package com.example.demo.services;

import java.util.List;

import com.example.demo.entities.*;

public interface AvisService {
    public List<Avis> getAllAvis();
    public  Avis saveAvis(Avis avis );
    public Avis getAvisById(Integer id);
    public Avis  editAvis(Avis avis);
    public Long countAvis();
    public void deleteAvisById(Integer id);
}
