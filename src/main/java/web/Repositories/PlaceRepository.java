package web.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import web.Entities.Place;

@RepositoryRestResource
public interface PlaceRepository  extends JpaRepository<Place,Integer> {
}
