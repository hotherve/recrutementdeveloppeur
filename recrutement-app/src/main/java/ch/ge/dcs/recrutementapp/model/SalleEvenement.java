package ch.ge.dcs.recrutementapp.model;

import javax.persistence.*;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Pattern;
import java.util.Date;

@Entity
@Table(name = "SALLE_EVENT")
public class SalleEvenement {

    public static final String LIBRE = "motion:off";
    public static final String OCCUPE = "motion:on";
    public static final String REGEX_PATTERN = "^motion:o(n|ff)$";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @Pattern(regexp = REGEX_PATTERN)
    private String salleEvent;

    @NotNull
    @PastOrPresent
    private Date dateEvent;

    @ManyToOne
    private Salle salle;


    public SalleEvenement() {
    }

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
}
