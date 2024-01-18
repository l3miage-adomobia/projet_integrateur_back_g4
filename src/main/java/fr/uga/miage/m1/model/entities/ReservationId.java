package fr.uga.miage.m1.model.entities;

import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class ReservationId implements Serializable{
    private Long idOffreDeCovoiturage;

    private Long idPanier;

    private Long idArret;

}
