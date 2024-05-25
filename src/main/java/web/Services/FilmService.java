package web.Services;

import java.util.List;

import web.Entities.Film;
import web.Entities.SuperAdmin;

public interface FilmService {
    public List<Film> getAllFilms();
    public  Film saveFilm(Film film);
    public Film getFilmById(Integer id);
    public Film  editFilm(Film film);
    public Long countFilm();
    public void deleteFilmById(Integer id);
}
