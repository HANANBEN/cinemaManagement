package Repositories;

import Entities.Quartier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface QuartierRepository extends JpaRepository<Quartier,String> {
}
