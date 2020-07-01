package ch.ge.dcs.recrutementapp;

import ch.ge.dcs.recrutementapp.model.Salle;
import ch.ge.dcs.recrutementapp.repository.SalleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import ch.ge.dcs.recrutementapp.exception.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1")
public class SalleController {

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
    public Salle createEmployee(@Valid @RequestBody Salle salle) {
        return salleRepository.save(salle);
    }

}
