package Services;

import Entities.Film;
import Entities.SuperAdmin;

import java.util.List;

public interface FilmService {
    public List<Film> getAllFilms();
    public  Film saveFilm(Film film);
    public Film getFilmById(Integer id);
    public Film  editFilm(Film film);
    public Long countFilm();
    public void deleteFilmById(Integer id);
}
