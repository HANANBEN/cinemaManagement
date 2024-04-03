package Repositories;

import Entities.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface LoginRepository  extends JpaRepository<Login, String> {
Login findByEmail(String email);

}
