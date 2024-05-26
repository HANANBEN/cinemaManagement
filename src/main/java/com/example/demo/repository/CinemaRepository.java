package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Cinema;

@Repository
public interface CinemaRepository extends JpaRepository<Cinema, Integer> {
    @Query("SELECT c FROM Cinema c WHERE c.gestionnaire.idgestionnaire = :idGestionnaire")
    Cinema findByGestionnaireId(Integer idGestionnaire);
}
