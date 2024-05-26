package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.demo.entities.Quartier;
import com.example.demo.entities.Ville;

@RepositoryRestResource
public interface QuartierRepository extends JpaRepository<Quartier,String> {
    Quartier findBynom(String nom);
}
