package ch.ge.dcs.recrutementapp.listener;

import ch.ge.dcs.recrutementapp.RecrutementAppApplication;
import ch.ge.dcs.recrutementapp.model.Salle;
import ch.ge.dcs.recrutementapp.model.SalleEvenement;
import ch.ge.dcs.recrutementapp.repository.SalleEvenementRepository;
import ch.ge.dcs.recrutementapp.repository.SalleRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import javax.validation.Valid;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.TemporalField;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Classe contenant les listener nécessaires pour l'application
 */
@Component
public class AtStartup {
    private static final Logger LOGGER = LoggerFactory.getLogger(RecrutementAppApplication.class);

    @Autowired
    private SalleRepository salleRepository;

    @Autowired
    private SalleEvenementRepository salleEvenementRepository;

    /**
     * Listener déclenché lorsque l'application a fini d'être chargée
     */
    @EventListener(ApplicationReadyEvent.class)
    public void remplissageEventSalle() {
        LOGGER.info("remplissage des salles avec listener sur démarrage");
        List<Salle> salles = salleRepository.findAll();
        salles.stream().forEach(salle -> this.rempliSallesEvenement(salle));
    }


    /**
     * Methode de remplissage d'evenements pour les salles
     *
     * @param salle la salle qui recoit les evenements
     */
    private void rempliSallesEvenement(Salle salle) {
        LocalDate today = LocalDate.now();
        Boolean occupe = Boolean.TRUE;
        LocalDate simulatedDate;
        List<SalleEvenement> salleEvenementList = new ArrayList<>();
        // pour les dix derniers jours double boucle sur les jours puis les heures
        for (int i = 10; i >= 0; i--) {
            simulatedDate = today.minusDays(i);
            // zappe samedi et dimanche
            if(simulatedDate.getDayOfWeek().equals(DayOfWeek.SATURDAY) || simulatedDate.getDayOfWeek().equals(DayOfWeek.SUNDAY)) {
                LOGGER.info("Samedi ou dimanche");
                continue;
            }
            // chaque heure entre 8 et 18 heures je défini un envoi de capteur pour avoir un échantillon
            for (int hour = 8; hour < 19; hour++) {
                LocalDateTime localDateTime = simulatedDate.atTime(hour, 0);
                Date from = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
                // pas de date future
                if(from.after(new Date())) {
                    break;
                }
                SalleEvenement se = new SalleEvenement(occupe ? SalleEvenement.OCCUPE : SalleEvenement.LIBRE, from, salle);
                salleEvenementList.add(se);
                occupe = !occupe;
            }

            LOGGER.info("simulated : " + simulatedDate);
        }
        // enregistre la liste
        salleEvenementRepository.saveAll(salleEvenementList);
    }
}
