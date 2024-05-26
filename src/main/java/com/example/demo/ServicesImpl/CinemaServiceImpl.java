package com.example.demo.ServicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Cinema;
import com.example.demo.entities.Gestionnaire;
import com.example.demo.repository.CinemaRepository;
import com.example.demo.repository.GestionnaireRepository;
import com.example.demo.services.CinemaService;

import java.util.List;
import java.util.Optional;

@Service
public class CinemaServiceImpl implements CinemaService {
     private CinemaRepository cinemarep;
     private GestionnaireRepository gestionrep;
     
    public CinemaServiceImpl(CinemaRepository cinemarep) {
		super();
		this.cinemarep = cinemarep;
	}

	@Override
    public List<Cinema> getAllCinemas() {
        return cinemarep.findAll();
    }

    @Override
    public Cinema saveCinema(Cinema cinema) {
        return cinemarep.save(cinema);
    }

    @Override
    public Cinema getCinemaById(Integer id) {
        return cinemarep.findById(id).get();
    }

    @Override
    public Cinema editCinema(Cinema cinema) {
        return cinemarep.save(cinema);
    }

    @Override
    public Long countCinema() {
        return cinemarep.count();
    }

    @Override
    public void deleteCinemaById(Integer id) {
        cinemarep.deleteById(id);

    }
    @Override
    public Cinema getCinemaByGestionnaireId(Integer gestionnaireId) {
        Optional<Cinema> cinemaOptional = getAllCinemas().stream()
                .filter(cinema -> cinema.getGestionnaire() != null && cinema.getGestionnaire().getIdgestionnaire().equals(gestionnaireId))
                .findFirst();
        
        return cinemaOptional.orElse(null);
    }
    @Override
    public void updateCinemaById(Integer id) {
    		Cinema cinema = this.getCinemaByGestionnaireId(id);
    		cinema.setGestionnaire(new Gestionnaire());
    		cinemarep.save(cinema);
    		
    }
    
}
