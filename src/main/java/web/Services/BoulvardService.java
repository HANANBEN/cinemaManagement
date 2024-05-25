package web.Services;

import java.util.List;

import web.Entities.Boulvard;
import web.Entities.Categorie;

public interface BoulvardService
{
    public List<Boulvard> getAllBoulvards();
    public  Boulvard  saveBoulvard(Boulvard boulvard);
    public Boulvard getBoulvardById(String id);
    public Boulvard editBoulvard(Boulvard boulvard);
    public Long countBoulvard();
    public void deleteBoulvardById(String id);
}
