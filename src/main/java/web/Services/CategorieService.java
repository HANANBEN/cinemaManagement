package web.Services;

import java.util.List;

import web.Entities.Categorie;

public interface CategorieService {
    public List<Categorie> getAllCategories();
    public  Categorie  saveCategorie(Categorie categorie);
    public Categorie getCategorieById(String id);
    public Categorie editCategorie(Categorie categorie);
    public Long countCategorie();
    public void deleteCategorieById(String id);
}
