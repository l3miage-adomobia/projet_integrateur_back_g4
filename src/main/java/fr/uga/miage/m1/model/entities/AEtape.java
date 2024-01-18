package fr.uga.miage.m1.model.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class AEtape {
    @EmbeddedId
    private AEtapeId aEtapeId;

    private String tarif;
    private String duree;

    @ManyToOne
    @JoinColumn(name = "idArret", referencedColumnName = "idArret")
    @MapsId("idArret")
    private ArretCovoiturage arretCovoiturage;

    @ManyToOne
    @JoinColumn(name = "idOffreDeCovoiturage", referencedColumnName = "idOffreDeCovoiturage")
    @MapsId("idOffreDeCovoiturage")
    private OffreCovoiturage offreCovoiturage;
}