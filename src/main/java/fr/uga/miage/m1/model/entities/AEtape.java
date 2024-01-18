package fr.uga.miage.m1.model.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class AEtape {
    @EmbeddedId
    private AEtapeId aEtapeId;

    @NotNull
    private String tarif;
    @NotNull
    private String duree;

    @ManyToOne
    @JoinColumn(name = "idArret", referencedColumnName = "idArret")
    @MapsId("idArret")
    @NotNull
    private ArretCovoiturage arretCovoiturage;

    @ManyToOne
    @JoinColumn(name = "idOffreDeCovoiturage", referencedColumnName = "idOffreDeCovoiturage")
    @MapsId("idOffreDeCovoiturage")
    @NotNull
    private OffreCovoiturage offreCovoiturage;
}