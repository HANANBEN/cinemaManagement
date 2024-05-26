package com.example.demo.ServicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Place;
import com.example.demo.entities.Projectionfilm;
import com.example.demo.entities.Salle;
import com.example.demo.entities.Seance;
import com.example.demo.repository.SalleRepository;
import com.example.demo.repository.SeanceRepository;
import com.example.demo.services.SalleService;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
public class SalleServiceImpl implements SalleService {
    private SalleRepository sallerep;
    @Autowired
    private SeanceRepository srep;


	public SalleServiceImpl(SalleRepository sallerep, SeanceRepository srep) {
		super();
		this.sallerep = sallerep;
		this.srep = srep;
	}


	@Override
    public List<Salle> getAllSalles() {
        return sallerep.findAll();
    }

    @Override
    public Salle saveSalle(Salle salle) {
        return sallerep.save(salle);
    }

    @Override
    public Salle getSalleById(Integer id) {
        return sallerep.findById(id).get();
    }

    @Override
    public Salle editSalle(Salle salle) {
        return sallerep.save(salle);
    }

    @Override
    public Long countSalle() {
        return sallerep.count();
    }

    @Override
    public void deleteSalleById(Integer id) {
        sallerep.deleteById(id);

    }
    public double calculerTauxOccupationGlobalPourPeriode(LocalDate dateDebut, LocalDate dateFin) {
        List<Salle> salles = sallerep.findAll();

        int nombreTotalPlaces = 0;
        int nombreTotalPlacesOccupees = 0;

        for (Salle salle : salles) {
            // Obtenez toutes les séances pour cette salle dans la période spécifiée
            List<Seance> seances = srep.findBySalleAndHeuredebutBetween(salle, 
                                                                                    dateDebut.atStartOfDay(), 
                                                                                    dateFin.atTime(LocalTime.MAX));

            int nombrePlaces = salle.getNbrplace(); // Nombre total de places dans cette salle

            // Calculer le nombre total de places occupées dans cette salle pour la période spécifiée
            int nombrePlacesOccupees = seances.stream()
                                               .mapToInt(seance -> {
                                                   int placesOccupeesPourSeance = 0;
                                                   for (Place place : salle.getPlaces()) {
                                                       if (place.getIsdispo()) {
                                                           placesOccupeesPourSeance++;
                                                       }
                                                   }
                                                   return placesOccupeesPourSeance;
                                               })
                                               .sum();

            nombreTotalPlaces += nombrePlaces;
            nombreTotalPlacesOccupees += nombrePlacesOccupees;
        }

        // Calculer le taux d'occupation global pour la période spécifiée
        double tauxOccupationGlobal = (double) nombreTotalPlacesOccupees / nombreTotalPlaces * 100;

        return tauxOccupationGlobal;
    }

}
