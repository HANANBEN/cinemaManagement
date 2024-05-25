package web.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import web.Entities.Avis;

@RepositoryRestResource
public interface AvisRepository extends JpaRepository<Avis,Integer> {
}
