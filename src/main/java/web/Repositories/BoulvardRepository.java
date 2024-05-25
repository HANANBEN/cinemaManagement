package web.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import web.Entities.Boulvard;

@RepositoryRestResource
public interface BoulvardRepository extends JpaRepository<Boulvard,String> {
}
