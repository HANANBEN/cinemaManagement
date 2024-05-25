package web.Repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import web.Entities.Projectionfilm;


public interface ProjectionfilmRepository extends JpaRepository<Projectionfilm, Integer> {
    @Query("SELECT p FROM Projectionfilm p WHERE p.dateprojection BETWEEN :startDate AND :endDate")
    List<Projectionfilm> findByDateProjectionBetween(@Param("startDate") Date startDate, @Param("endDate") Date endDate);
}
