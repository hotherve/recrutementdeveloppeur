package ch.ge.dcs.recrutementapp.controller;

import ch.ge.dcs.recrutementapp.exception.ResourceNotFoundException;
import ch.ge.dcs.recrutementapp.model.Salle;
import ch.ge.dcs.recrutementapp.repository.SalleRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Le controlleur pour les salles
 */

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1")
public class SalleController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SalleController.class);

    @Autowired
    private SalleRepository salleRepository;

    @GetMapping("/salles")
    public List<Salle> getAllSalles() {
        return salleRepository.findAll();
    }

    @GetMapping("/salle/{id}")
    public ResponseEntity<Salle> getSalleById(@PathVariable(value = "id") final Integer salleId) throws ResourceNotFoundException {
        Salle salle = salleRepository.findById(salleId).orElseThrow(() -> new ResourceNotFoundException("La salle avec l'identifiant " + salleId + " n'existe pas"));
        return ResponseEntity.ok().body(salle);
    }

    @PostMapping("/salles")
    public Salle createSalle(@Valid @RequestBody Salle salle) {
        return salleRepository.save(salle);
    }

    @PutMapping("/salles/{id}")
    public ResponseEntity<Salle> updateSalle(@PathVariable(value = "id") Integer salleId, @Valid @RequestBody Salle salleDetail) throws ResourceNotFoundException {
        Salle salle = salleRepository.findById(salleId).orElseThrow(() -> new ResourceNotFoundException("La salle avec l'identifiant " + salleId + " n'existe pas"));
        salle.setNomSalle(salleDetail.getNomSalle());

        final Salle salle1 = salleRepository.save(salle);
        return ResponseEntity.ok(salle1);
    }

    @DeleteMapping("/salles/{id}")
    public Map<String, Boolean> deleteSalle(@PathVariable(value = "id") final Integer salleId) throws ResourceNotFoundException {
        Salle salle = salleRepository.findById(salleId).orElseThrow(() -> new ResourceNotFoundException("La salle avec l'identifiant " + salleId + " n'existe pas"));
        Map<String, Boolean> response = new HashMap<>();

        try {
            salleRepository.delete(salle);
            response.put("deleted Salle :" + salleId, Boolean.TRUE);
        } catch (Exception e) {
            response.put("Salle non effacée :" + salleId + " erreur : " + e.getMessage(), Boolean.FALSE);
            LOGGER.error("Erreur effacement salle " + salleId + " pour la raison suivante : " + e, e);
        }
        return response;
    }

}
