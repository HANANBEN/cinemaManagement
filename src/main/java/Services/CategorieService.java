package Services;

import Entities.Categorie;

import java.util.List;

public interface CategorieService {
    public List<Categorie> getAllCategories();
    public  Categorie  saveCategorie(Categorie categorie);
    public Categorie getCategorieById(String id);
    public Categorie editCategorie(Categorie categorie);
    public Long countCategorie();
    public void deleteCategorieById(String id);
}
