package web.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import web.Entities.Login;

@RepositoryRestResource
public interface LoginRepository  extends JpaRepository<Login, String> {
Login findByEmail(String email);

}
