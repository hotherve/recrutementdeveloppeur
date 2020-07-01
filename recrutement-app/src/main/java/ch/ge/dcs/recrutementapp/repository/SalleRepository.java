package ch.ge.dcs.recrutementapp.repository;

import ch.ge.dcs.recrutementapp.model.Salle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalleRepository extends JpaRepository<Salle, Integer> {
}
