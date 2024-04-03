package Repositories;

import Entities.Projectionfilm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ProjectionfilmRepository  extends JpaRepository<Projectionfilm,Integer> {
}
