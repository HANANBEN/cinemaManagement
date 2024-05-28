package com.example.demo.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.demo.entities.*;

@RepositoryRestResource
public interface ProjectionfilmRepository  extends JpaRepository<Projectionfilm,Integer> {
	
	
	 List<Projectionfilm> findByFilmTitre(String titre);
	    List<Projectionfilm> findByDateprojection(Date dateprojection);
	    List<Projectionfilm> findByFilmTitreAndDateprojection(String titre, Date dateprojection);
}
