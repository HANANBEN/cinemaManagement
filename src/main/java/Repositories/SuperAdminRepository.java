package Repositories;

import Entities.SuperAdmin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface SuperAdminRepository extends JpaRepository<SuperAdmin,Integer> {
}
