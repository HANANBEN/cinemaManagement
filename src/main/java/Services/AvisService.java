package Services;

import Entities.Avis;
import Entities.Salle;

import java.util.List;

public interface AvisService {
    public List<Avis> getAllAvis();
    public  Avis saveAvis(Avis avis );
    public Avis getAvisById(Integer id);
    public Avis  editAvis(Avis avis);
    public Long countAvis();
    public void deleteAvisById(Integer id);
}
