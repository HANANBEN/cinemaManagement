package com.example.demo.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Ticket;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Integer> {


	    @Query("SELECT COUNT(t) FROM Ticket t WHERE t.projectionfilm.dateprojection >= :dateDebut AND t.projectionfilm.dateprojection <= :dateFin")
	    Long countTicketsBetweenDatesJPQL(@Param("dateDebut") Date dateDebut, @Param("dateFin") Date dateFin);
	}

