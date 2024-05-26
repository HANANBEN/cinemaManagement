package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.demo.entities.Client;
import com.example.demo.entities.SuperAdmin;

@RepositoryRestResource
public interface ClientRepository extends JpaRepository<Client,Integer> {
	
}
