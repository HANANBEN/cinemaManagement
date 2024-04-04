package Services;

import Entities.Film;
import Entities.Seance;

import java.util.List;

public interface SeanceService {
    public List<Seance> getAllSeances();
    public Seance saveSeance(Seance seance);
    public Seance getSeanceById(Integer id);
    public Seance  editSeance(Seance seance);
    public Long countSeance();
    public void deleteSeanceById(Integer id);
}
