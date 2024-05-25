package web.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import web.Entities.Categorie;

@RepositoryRestResource
public interface CategorieRepository  extends JpaRepository<Categorie,String> {
}
