package com.example.demo.ServicesImpl;

import com.example.demo.Entities.*;

import org.springframework.stereotype.Service;

import com.example.demo.Repositories.SalleRepository;
import com.example.demo.Services.SalleService;

import java.util.List;

@Service
public class SalleServiceImpl implements SalleService {
    private SalleRepository sallerep;
    @Override
    public List<Salle> getAllSalles() {
        return sallerep.findAll();
    }

    @Override
    public Salle saveSalle(Salle salle) {
        return sallerep.save(salle);
    }

    @Override
    public Salle getSalleById(Integer id) {
        return sallerep.findById(id).get();
    }

    @Override
    public Salle editSalle(Salle salle) {
        return sallerep.save(salle);
    }

    @Override
    public Long countSalle() {
        return sallerep.count();
    }

    @Override
    public void deleteSalleById(Integer id) {
        sallerep.deleteById(id);

    }
}
