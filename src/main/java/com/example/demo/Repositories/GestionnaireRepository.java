package com.example.demo.Repositories;
import com.example.demo.Entities.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface GestionnaireRepository  extends JpaRepository<Gestionnaire ,Integer> {
}
