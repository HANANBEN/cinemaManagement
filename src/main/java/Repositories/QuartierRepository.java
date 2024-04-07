package Repositories;

import Entities.Quartier;
import Entities.Ville;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface QuartierRepository extends JpaRepository<Quartier,String> {
    Quartier findBynom(String nom);
}
