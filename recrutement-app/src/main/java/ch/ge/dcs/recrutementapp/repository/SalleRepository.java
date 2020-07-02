package ch.ge.dcs.recrutementapp.repository;

import ch.ge.dcs.recrutementapp.model.Salle;
import ch.ge.dcs.recrutementapp.model.SalleEvenement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SalleRepository extends JpaRepository<Salle, Integer> {

    @Query(value = "SELECT se FROM SalleEvenement se WHERE se.salle.id=?1")
    List<SalleEvenement> listeEvenementsdeSalle(int salleId);

}
