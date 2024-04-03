package Repositories;

import Entities.Avis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface AvisRepository extends JpaRepository<Avis,Integer> {
}
