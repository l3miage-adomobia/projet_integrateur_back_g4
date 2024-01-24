package fr.uga.miage.m1.model.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Etape {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idEtape;

    @NotNull
    private int tarif;

    @NotNull
    private int duree;

    @ManyToOne
    @JoinColumn(name = "FK_depart", referencedColumnName = "idArret")
    @NotNull
    private ArretCovoiturage depart;

    @ManyToOne
    @JoinColumn(name = "FK_offre", referencedColumnName = "idOffreDeCovoiturage")
    @NotNull
    private OffreCovoiturage offreCovoiturage;
}