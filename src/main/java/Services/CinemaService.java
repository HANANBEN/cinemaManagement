package Services;

import Entities.Cinema;
import Entities.SuperAdmin;

import java.util.List;

public interface CinemaService {
    public List<Cinema> getAllCinemas();
    public  Cinema saveCinema(Cinema cinema);
    public Cinema getCinemaById(Integer id);
    public Cinema editCinema(Cinema cinema);
    public Long countCinema();
    public void deleteCinemaById(Integer id);
}
