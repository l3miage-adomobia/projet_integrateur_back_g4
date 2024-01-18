package fr.uga.miage.m1.model.entities;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import jakarta.validation.constraints.Size;

import java.io.Serializable;

@Embeddable
public class AEtapeId implements Serializable {
    @Size(max = 36)
    private Long idArret;
    @Size(max = 36)
    private Long idOffreDeCovoiturage;

}
