package Repositories;

import Entities.Gestionnaire;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GestionnaireRepository  extends JpaRepository<Gestionnaire ,Integer> {
}
