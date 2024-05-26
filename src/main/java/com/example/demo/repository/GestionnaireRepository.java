package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.demo.entities.Gestionnaire;


public interface GestionnaireRepository  extends JpaRepository<Gestionnaire ,Integer> {
	List<Gestionnaire> findByNomContainingIgnoreCase(String nom);
	}
