package com.example.demo.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.demo.entities.Salle;
import com.example.demo.entities.Seance;

@RepositoryRestResource
public interface SeanceRepository  extends JpaRepository<Seance,Integer> {
	 @Query("SELECT s FROM Seance s WHERE s.salle = :salle AND s.heuredebut BETWEEN :dateDebut AND :dateFin")
	    List<Seance> findBySalleAndHeuredebutBetween(Salle salle, LocalDateTime dateDebut, LocalDateTime dateFin);
}
