package Services;

import Entities.Boulvard;
import Entities.Categorie;

import java.util.List;

public interface BoulvardService
{
    public List<Boulvard> getAllBoulvards();
    public  Boulvard  saveBoulvard(Boulvard boulvard);
    public Boulvard getBoulvardById(String id);
    public Boulvard editBoulvard(Boulvard boulvard);
    public Long countBoulvard();
    public void deleteBoulvardById(String id);
}
