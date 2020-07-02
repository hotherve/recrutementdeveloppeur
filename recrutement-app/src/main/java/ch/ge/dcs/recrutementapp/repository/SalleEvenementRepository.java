package ch.ge.dcs.recrutementapp.repository;

import ch.ge.dcs.recrutementapp.model.Salle;
import ch.ge.dcs.recrutementapp.model.SalleEvenement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SalleEvenementRepository extends JpaRepository<SalleEvenement, Integer> {

    List<SalleEvenement> getBySalleEquals(Salle salle);

    @Query(value = "SELECT distinct se FROM SalleEvenement se WHERE (se.dateEvent, se.salle.id) in (SELECT MAX(sse.dateEvent), sse.salle.id FROM SalleEvenement sse GROUP BY sse.salle.id)")
    List<SalleEvenement> getLastEventFromAllSalles();
}
