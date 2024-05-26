package com.example.demo.ServicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entities.Cinema;
import com.example.demo.entities.Salle;
import com.example.demo.repository.CinemaRepository;
import com.example.demo.repository.SalleRepository;
import com.example.demo.services.CinemaService;

import java.util.List;

@Service
public class CinemaServiceImpl implements CinemaService {
	private CinemaRepository cinemarep;

	public CinemaServiceImpl(CinemaRepository crep) {
		super();
		this.cinemarep = crep;
	}

	@Autowired
    private SalleRepository salleRepository; // Suppose que vous avez un repository pour Salle

    @Transactional
    public void deleteCinemaAndItsRooms(int cinemaId) {
        // Supprimer toutes les salles liées à ce cinéma
        List<Salle> salles = salleRepository.findByCinemaId(cinemaId);
        for (Salle salle : salles) {
            salleRepository.delete(salle);
        }
        // Supprimer le cinéma lui-même
        cinemarep.deleteById(cinemaId);
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
    public Integer countSallesInCinema(Integer cinemaId) {
        Cinema cinema = getCinemaById(cinemaId);
        if (cinema != null && cinema.getSalles() != null) {
            return cinema.getSalles().size();
        } else {
            return 0;
        }
    }
}
