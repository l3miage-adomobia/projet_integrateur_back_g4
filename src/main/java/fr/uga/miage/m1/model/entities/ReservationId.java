package fr.uga.miage.m1.model.entities;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serializable;

@Embeddable
public class ReservationId implements Serializable{
    @NotNull
    @Size(max = 36)
    private Long idOffreDeCovoiturage;

    @NotNull
    @Size(max = 36)
    private Long idPanier;

    @NotNull
    @Size(max = 36)
    private Long idArret;

}
