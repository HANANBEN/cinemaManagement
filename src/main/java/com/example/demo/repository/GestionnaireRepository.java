package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Gestionnaire;


public interface GestionnaireRepository  extends JpaRepository<Gestionnaire ,Integer> {
}
