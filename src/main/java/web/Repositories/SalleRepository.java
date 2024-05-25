package web.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import web.Entities.Salle;

@RepositoryRestResource
public interface SalleRepository extends JpaRepository<Salle,Integer> {
}
