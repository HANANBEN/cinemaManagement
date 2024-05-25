package web.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import web.Entities.Client;
import web.Entities.SuperAdmin;

@RepositoryRestResource
public interface ClientRepository extends JpaRepository<Client,Integer> {
}
