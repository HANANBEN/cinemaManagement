package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.demo.entities.Login;

@RepositoryRestResource
public interface LoginRepository  extends JpaRepository<Login, String> {
Login findByEmail(String email);

}
