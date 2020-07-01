package ch.ge.dcs.recrutementapp.model;

import javax.persistence.*;

@Entity
@Table(name = "salle")
public class Salle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nom_salle;

    public Salle() {
    }

    public Salle(String nom_salle) {
        this.nom_salle = nom_salle;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom_salle() {
        return nom_salle;
    }

    public void setNom_salle(String nom_salle) {
        this.nom_salle = nom_salle;
    }

    @Override
    public String toString() {
        return "Salle{" +
                "id=" + id +
                ", nom_salle='" + nom_salle + '\'' +
                '}';
    }
}
