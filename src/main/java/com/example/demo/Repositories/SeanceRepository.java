package com.example.demo.Repositories;

import com.example.demo.Entities.*;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface SeanceRepository  extends JpaRepository<Seance,Integer> {
    List<Seance> findByProjectionfilmDateprojection(Date date);

}
