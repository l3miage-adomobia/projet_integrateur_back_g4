package fr.uga.miage.m1.model.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Etape {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tarif;
    private String duree;

    @ManyToOne
    @JoinColumn(name = "idArret", referencedColumnName = "idArret")
    private ArretCovoiturage arretCovoiturage;

    @ManyToOne
    @JoinColumn(name = "idOffreDeCovoiturage", referencedColumnName = "idOffreDeCovoiturage")
    private OffreCovoiturage offreCovoiturage;
}