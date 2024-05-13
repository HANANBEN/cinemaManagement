package com.example.demo.Repositories;

import com.example.demo.Entities.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmRepository extends JpaRepository<Film ,Integer> {
    Film findByTitre(String titre);

}
