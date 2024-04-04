package Services.Impl;

import Entities.Categorie;
import Repositories.CategorieRepository;
import Services.CategorieService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategorieServiceImpl implements CategorieService {
   private CategorieRepository categorierep;
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