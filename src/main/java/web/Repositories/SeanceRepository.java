package web.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import web.Entities.Seance;

@RepositoryRestResource
public interface SeanceRepository  extends JpaRepository<Seance,Integer> {
}
