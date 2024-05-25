package web.ServicesImpl;

import web.Entities.Film;
import web.Repositories.FilmRepository;
import web.Services.FilmService;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmServiceImpl implements FilmService {
    private FilmRepository filmrep;
    @Override
    public List<Film> getAllFilms() {
        return  filmrep.findAll();
    }

    @Override
    public Film saveFilm(Film film) {
        return filmrep.save(film);
    }

    @Override
    public Film getFilmById(Integer id) {
        return filmrep.findById(id).get();
    }

    @Override
    public Film editFilm(Film film) {
        return filmrep.save(film);
    }

    @Override
    public Long countFilm() {
        return filmrep.count();
    }

    @Override
    public void deleteFilmById(Integer id) {
              filmrep.deleteById(id);
    }
}
