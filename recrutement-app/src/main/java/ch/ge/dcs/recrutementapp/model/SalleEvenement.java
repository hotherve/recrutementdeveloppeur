package ch.ge.dcs.recrutementapp.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "SALLE_EVENT")
public class SalleEvenement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String salleEvent;

    private Date dateEvent;

    @ManyToOne
    private Salle salle;


}
