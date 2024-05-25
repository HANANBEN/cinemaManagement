package web.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import web.Entities.Gestionnaire;


public interface GestionnaireRepository  extends JpaRepository<Gestionnaire ,Integer> {
}
