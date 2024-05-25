package web.Services;

import java.util.List;

import web.Entities.Cinema;
import web.Entities.SuperAdmin;

public interface CinemaService {
    public List<Cinema> getAllCinemas();
    public  Cinema saveCinema(Cinema cinema);
    public Cinema getCinemaById(Integer id);
    public Cinema editCinema(Cinema cinema);
    public Long countCinema();
    public void deleteCinemaById(Integer id);
	Cinema getCinemaByGestionnaireId(Integer gestionnaireId);
	void updateCinemaById(Integer id);
}
