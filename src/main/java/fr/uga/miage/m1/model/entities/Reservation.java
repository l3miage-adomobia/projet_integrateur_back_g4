package fr.uga.miage.m1.model.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "reservation")
@Getter
@Setter
public class Reservation {
    @EmbeddedId
    private ReservationId reservationId;

    @ManyToOne
    @JoinColumn(name = "idOffreDeCovoiturage", referencedColumnName = "idOffreDeCovoiturage")
    @MapsId("idOffreDeCovoiturage")
    private OffreCovoiturage offreCovoiturage;

    @ManyToOne
    @JoinColumn(name = "idPanier", referencedColumnName = "idPanier")
    @MapsId("idPanier")
    private Panier panier;

    @ManyToOne
    @JoinColumn(name = "idArret", referencedColumnName = "idArret")
    @MapsId("idArret")
    private ArretCovoiturage arretCovoiturage;

    private Integer nbPlaces;

}
