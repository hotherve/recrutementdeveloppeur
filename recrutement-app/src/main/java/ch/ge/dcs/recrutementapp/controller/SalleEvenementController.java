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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Le controlleur des evenement de salle
 */
@RestController
@RequestMapping("/api/v1")
public class SalleEvenementController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SalleEvenementController.class);

    @Autowired
    private SalleRepository salleRepository;


    @Autowired
    private SalleEvenementRepository salleEvenementRepository;

    @GetMapping("/salleEvent/{id}")
    public List<SalleEvenement> getAllForSalle(@PathVariable(value = "id") final Integer salleId) throws ResourceNotFoundException {
        if (LOGGER.isInfoEnabled()) {
            LOGGER.info("evenement de salles pour la salle " + salleId);
        }
        Salle salle = salleRepository.findById(salleId).orElseThrow(() -> new ResourceNotFoundException("La salle avec l'identifiant " + salleId + " n'existe pas"));
        return salleEvenementRepository.getBySalleEquals(salle);
    }

    // listeEvenementsdeSalle

    @GetMapping("/salleEvents/{id}")
    public List<SalleEvenement> getEventsForSalle(@PathVariable(value = "id") final Integer salleId) throws ResourceNotFoundException {
        if (LOGGER.isInfoEnabled()) {
            LOGGER.info("evenement de salles pour la salle " + salleId);
        }

        return salleRepository.listeEvenementsdeSalle(salleId);
    }

    @GetMapping("/salleEvents")
    public List<SalleEvenement> getLastEventForSalle() throws ResourceNotFoundException {
        if (LOGGER.isInfoEnabled()) {
            LOGGER.info("dernier evenement sur toutes les salles");
        }

        return salleEvenementRepository.getLastEventFromAllSalles();
    }

    @GetMapping("/salleEvenements")
    public List<SalleEvenementModel> getLastEvenementtForSalle() throws ResourceNotFoundException {
        if (LOGGER.isInfoEnabled()) {
            LOGGER.info("dernier evenement sur toutes les salles bien modelisées");
        }

        List<SalleEvenement> salleEvenementList = salleEvenementRepository.getLastEventFromAllSalles();
        List<SalleEvenementModel> salleEvenementModels = new ArrayList<>();
        for (SalleEvenement se : salleEvenementList) {
            salleEvenementModels.add(new SalleEvenementModel(EntityUtils.eventDateToString(se.getDateEvent()), se.getSalleEvent(), String.valueOf(se.getSalle().getId())));
        }
        return salleEvenementModels;
    }

    @PostMapping("/salleEvenements")
    public SalleEvenementModel createSalleEvent(@Valid @RequestBody SalleEvenementModel salleEvenementModel) throws ResourceNotFoundException {
        // check salle
        Salle salle = salleRepository.findById(Integer.parseInt(salleEvenementModel.getRoom_id())).orElseThrow(() -> new ResourceNotFoundException("La salle avec l'identifiant " + salleEvenementModel.getRoom_id() + " n'existe pas"));
        // check de la date
        LocalDateTime ldt = EntityUtils.eventStringToDate(salleEvenementModel.getTime());
        if(ldt == null) {
            throw new ResourceNotFoundException("La date n'est pas valide '"+salleEvenementModel.getTime()+"'");
        }
        if(ldt.isAfter(LocalDateTime.now())) {
            throw new ResourceNotFoundException("La date est future '"+salleEvenementModel.getTime()+"'");
        }
        // check de string
        if(!(SalleEvenement.LIBRE.equals(salleEvenementModel.getEvent()) || SalleEvenement.OCCUPE.equals(salleEvenementModel.getEvent()))) {
            throw new ResourceNotFoundException("Le nom de l'evenement n'a pas le bon modèle '"+salleEvenementModel.getTime()+"', ce doit être sous la forme 'motion:off' || 'motion:on'");
        }
        salleEvenementRepository.save(new SalleEvenement(salleEvenementModel.getEvent(), Date.from(ldt.atZone(ZoneId.systemDefault()).toInstant()),salle));
        return salleEvenementModel;
    }

}