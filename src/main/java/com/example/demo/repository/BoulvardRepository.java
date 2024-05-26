package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.demo.entities.Boulvard;

@RepositoryRestResource
public interface BoulvardRepository extends JpaRepository<Boulvard,String> {
}
