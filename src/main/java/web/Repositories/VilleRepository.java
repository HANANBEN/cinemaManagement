package web.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import web.Entities.Login;
import web.Entities.Ville;

@RepositoryRestResource
public interface VilleRepository  extends JpaRepository<Ville,String> {
    Ville findBynom(String nom);
}
