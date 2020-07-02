package ch.ge.dcs.recrutementapp.model;

import javax.persistence.*;

@Entity
@Table(name = "salle")
public class Salle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nom_salle")
    private String nomSalle;

    public Salle() {
    }

    public Salle(String nom_salle) {
        this.nomSalle = nom_salle;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomSalle() {
        return nomSalle;
    }

    public void setNomSalle(String nom_salle) {
        this.nomSalle = nom_salle;
    }

    @Override
    public String toString() {
        return "Salle{" +
                "id=" + id +
                ", nom_salle='" + nomSalle + '\'' +
                '}';
    }
}
