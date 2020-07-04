package ch.ge.dcs.recrutementapp.model;

import javax.persistence.*;

/**
 * Entité représentant la salle dans de base de données
 */

@Entity
@Table(name = "salle")
public class Salle {

    /**
     * identifiant salle
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /**
     * nom salle
     */
    @Column(name = "nom_salle")
    private String nomSalle;

    /**
     * constructeur vide obligatoire car autre constructeur
     */
    public Salle() {
    }

    /**
     * constructeur avec le nom
     */
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
