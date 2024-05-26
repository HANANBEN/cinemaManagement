package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.demo.entities.Seance;

@RepositoryRestResource
public interface SeanceRepository  extends JpaRepository<Seance,Integer> {
}
