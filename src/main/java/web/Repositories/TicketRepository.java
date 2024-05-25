package web.Repositories;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import web.Entities.Projectionfilm;
import web.Entities.Ticket;


public interface TicketRepository extends JpaRepository<Ticket, Integer> {
    @Query("SELECT t FROM Ticket t WHERE t.projectionfilm = :projection")
    List<Ticket> findByProjectionFilm(@Param("projection") Projectionfilm projection);
}
