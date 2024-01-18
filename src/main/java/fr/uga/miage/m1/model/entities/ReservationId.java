package fr.uga.miage.m1.model.entities;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;

@Embeddable
public class ReservationId implements Serializable{
    @NotNull
    private Long idOffreDeCovoiturage;

    @NotNull
    private Long idPanier;

    @NotNull
    private Long idArret;

}
