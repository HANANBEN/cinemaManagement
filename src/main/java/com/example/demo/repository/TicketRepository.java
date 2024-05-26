package com.example.demo.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.demo.entities.Projectionfilm;
import com.example.demo.entities.Ticket;


public interface TicketRepository extends JpaRepository<Ticket, Integer> {
    @Query("SELECT t FROM Ticket t WHERE t.projectionfilm = :projection")
    List<Ticket> findByProjectionFilm(@Param("projection") Projectionfilm projection);
}
