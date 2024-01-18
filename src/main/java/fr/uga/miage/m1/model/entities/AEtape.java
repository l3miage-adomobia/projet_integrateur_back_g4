package fr.uga.miage.m1.model.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class AEtape {
    @EmbeddedId
    @Size(max = 36)
    private AEtapeId aEtapeId;

    @NotNull
    @Size(max = 8)
    private String tarif;
    @NotNull
    @Size(max = 4)
    private String duree;

    @ManyToOne
    @JoinColumn(name = "idArret", referencedColumnName = "idArret")
    @MapsId("idArret")
    @NotNull
    @Size(max = 36)
    private ArretCovoiturage arretCovoiturage;

    @ManyToOne
    @JoinColumn(name = "idOffreDeCovoiturage", referencedColumnName = "idOffreDeCovoiturage")
    @MapsId("idOffreDeCovoiturage")
    @NotNull
    @Size(max = 36)
    private OffreCovoiturage offreCovoiturage;
}