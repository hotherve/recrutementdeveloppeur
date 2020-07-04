package ch.ge.dcs.recrutementapp.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Pattern;
import java.util.Date;

/**
 * Entité représentant un évenement de salle dans de base de données
 */
@Entity
@Table(name = "SALLE_EVENT")
public class SalleEvenement {

    /**
     * constantes liées a l'evenement
     */
    public static final String LIBRE = "motion:off";
    public static final String OCCUPE = "motion:on";
    public static final String REGEX_PATTERN = "^motion:o(n|ff)$";

    /**
     * identifiant technique de l'event
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /**
     * corps de l'evenement, doit correspondre au pattern, une enumération aurait été possible aussi
     */
    @NotNull
    @Pattern(regexp = REGEX_PATTERN)
    private String salleEvent;

    /**
     * date de l'evenement
     */
    @NotNull
    @PastOrPresent
    private Date dateEvent;

    /**
     * la salle liée a l'evenement
     */
    @NotNull
    @ManyToOne
    private Salle salle;


    /**
     * constructeur vide obligatoire car autre constructeur
     */
    public SalleEvenement() {
    }

    /**
     * constructeur avec toutes données sauf identifiant automatiquement enrichi lors de la persistance
     */
    public SalleEvenement(String salleEvent, Date dateEvent, Salle salle) {
        this.salleEvent = salleEvent;
        this.dateEvent = dateEvent;
        this.salle = salle;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSalleEvent() {
        return salleEvent;
    }

    public void setSalleEvent(String salleEvent) {
        this.salleEvent = salleEvent;
    }

    public Date getDateEvent() {
        return dateEvent;
    }

    public void setDateEvent(Date dateEvent) {
        this.dateEvent = dateEvent;
    }

    public Salle getSalle() {
        return salle;
    }

    public void setSalle(Salle salle) {
        this.salle = salle;
    }

    /** champ utilitaire calculé */
    @Transient
    public boolean isOccupee() {
        return OCCUPE.equals(this.salleEvent);
    }
}
