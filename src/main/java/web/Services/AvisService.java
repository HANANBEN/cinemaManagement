package web.Services;

import java.util.List;

import web.Entities.Avis;
import web.Entities.Salle;

public interface AvisService {
    public List<Avis> getAllAvis();
    public  Avis saveAvis(Avis avis );
    public Avis getAvisById(Integer id);
    public Avis  editAvis(Avis avis);
    public Long countAvis();
    public void deleteAvisById(Integer id);
}
