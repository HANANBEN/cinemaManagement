package com.example.demo.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.demo.entities.Salle;


public interface SalleRepository extends JpaRepository<Salle,Integer> {
	@Query("SELECT s FROM Salle s WHERE s.cinema.id = ?1")
    List<Salle> findByCinemaId(int cinemaId);
}
