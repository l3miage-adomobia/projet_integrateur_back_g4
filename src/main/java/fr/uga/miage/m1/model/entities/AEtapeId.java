package fr.uga.miage.m1.model.entities;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;

import java.io.Serializable;

@Embeddable
public class AEtapeId implements Serializable {
    private Long idArret;
    private Long idOffreDeCovoiturage;

}
