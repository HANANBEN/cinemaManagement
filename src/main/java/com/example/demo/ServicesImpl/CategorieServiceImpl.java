package com.example.demo.ServicesImpl;

import com.example.demo.Entities.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repositories.CategorieRepository;
import com.example.demo.Services.CategorieService;

import java.util.List;

@Service
public class CategorieServiceImpl implements CategorieService {
   private CategorieRepository categorierep;

    public CategorieServiceImpl() {
	super();
}
@Autowired
	public CategorieServiceImpl(CategorieRepository categorierep) {
	super();
	this.categorierep = categorierep;
}

	@Override
    public List<Categorie> getAllCategories() {
        return categorierep.findAll();
    }

    @Override
    public Categorie saveCategorie(Categorie categorie) {
        return categorierep.save(categorie) ;
    }

    @Override
    public Categorie getCategorieById(String id) {
        return categorierep.findById(id).get();
    }

    @Override
    public Categorie editCategorie(Categorie categorie) {
        return categorierep.save(categorie);
    }

    @Override
    public Long countCategorie() {
        return categorierep.count();
    }

    @Override
    public void deleteCategorieById(String id) {
        categorierep.deleteById(id);
    }
}
