package ch.ge.dcs.recrutementapp.controller;

import ch.ge.dcs.recrutementapp.exception.ResourceNotFoundException;
import ch.ge.dcs.recrutementapp.model.Salle;
import ch.ge.dcs.recrutementapp.model.SalleEvenement;
import ch.ge.dcs.recrutementapp.model.SalleEvenementModel;
import ch.ge.dcs.recrutementapp.repository.SalleEvenementRepository;
import ch.ge.dcs.recrutementapp.repository.SalleRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

/**
 * Le controlleur des evenement de salle
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1")
public class SalleEvenementController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SalleEvenementController.class);

    @Autowired
    private SalleRepository salleRepository;


    @Autowired
    private SalleEvenementRepository salleEvenementRepository;

    @GetMapping("/salleEvents/{id}")
    public List<SalleEvenement> getAllForSalle(@PathVariable(value = "id") final Integer salleId) throws ResourceNotFoundException {
        if (LOGGER.isInfoEnabled()) {
            LOGGER.info("evenement de salles pour la salle " + salleId);
        }
        Salle salle = salleRepository.findById(salleId).orElseThrow(() -> new ResourceNotFoundException("La salle avec l'identifiant " + salleId + " n'existe pas"));
        return salleEvenementRepository.findAllBySalleEqualsOrderByDateEventDesc(salle);
    }

    /**
     * Les derniers évènements de toutes les salles
     *
     * @return Liste des derniers évènement de toute les salles
     * @throws ResourceNotFoundException
     */
    @GetMapping("/salleEvents")
    public List<SalleEvenement> getLastEventForSalle() throws ResourceNotFoundException {
        if (LOGGER.isInfoEnabled()) {
            LOGGER.info("dernier évènement sur toutes les salles");
        }
        return salleEvenementRepository.getLastEventFromAllSalles();
    }

    /**
     * Reception du message d'un capteur
     * Avant l'insertion voici les règles de validité :
     * - L'identifiant de salle existe
     * - Validation de la date au format 'yyyy-MM-dd'T'HH:mm:ss'
     * - La date ne doit pas être future
     * - Le contenu de l'event est 'motion:off' ou 'motion:on'
     *
     * @param salleEvenementModel Le modèle JSON d'un capteur
     * @return le salle event model posté
     * @throws ResourceNotFoundException en cas de non validité avec message d'erreur
     */
    @PostMapping("/salleEvenements")
    public SalleEvenementModel createSalleEvent(@Valid @RequestBody SalleEvenementModel salleEvenementModel) throws ResourceNotFoundException {
        // check salle
        Salle salle = salleRepository.findById(Integer.parseInt(salleEvenementModel.getRoom_id())).orElseThrow(() -> new ResourceNotFoundException("La salle avec l'identifiant " + salleEvenementModel.getRoom_id() + " n'existe pas"));
        // check de la date
        LocalDateTime ldt = EntityUtils.eventStringToDate(salleEvenementModel.getTime());
        if (ldt == null) {
            throw new ResourceNotFoundException("La date n'est pas valide '" + salleEvenementModel.getTime() + "'");
        }
        if (ldt.isAfter(LocalDateTime.now())) {
            throw new ResourceNotFoundException("La date est future '" + salleEvenementModel.getTime() + "'");
        }
        // check de string
        if (!(SalleEvenement.LIBRE.equals(salleEvenementModel.getEvent()) || SalleEvenement.OCCUPE.equals(salleEvenementModel.getEvent()))) {
            throw new ResourceNotFoundException("Le nom de l'evenement n'a pas le bon modèle '" + salleEvenementModel.getTime() + "', ce doit être sous la forme 'motion:off' || 'motion:on'");
        }
        salleEvenementRepository.save(new SalleEvenement(salleEvenementModel.getEvent(), Date.from(ldt.atZone(ZoneId.systemDefault()).toInstant()), salle));
        return salleEvenementModel;
    }

}