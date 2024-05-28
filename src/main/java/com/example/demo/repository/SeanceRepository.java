package com.example.demo.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.demo.entities.*;

@RepositoryRestResource
public interface SeanceRepository  extends JpaRepository<Seance,Integer> {
    List<Seance> findByProjectionfilmDateprojection(Date date);
    List<Seance> findByProjectionfilm(Projectionfilm projfilm);
}
