package web.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import web.Entities.Quartier;
import web.Entities.Ville;

@RepositoryRestResource
public interface QuartierRepository extends JpaRepository<Quartier,String> {
    Quartier findBynom(String nom);
}
