package web.Services;

import java.util.List;

import web.Entities.Film;
import web.Entities.Seance;

public interface SeanceService {
    public List<Seance> getAllSeances();
    public Seance saveSeance(Seance seance);
    public Seance getSeanceById(Integer id);
    public Seance  editSeance(Seance seance);
    public Long countSeance();
    public void deleteSeanceById(Integer id);
}
