package fr.uga.miage.m1.model.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "reservation")
@Getter
@Setter
public class Reservation {
    @EmbeddedId
    @NotNull
    @Size(max = 36)
    private ReservationId reservationId;

    @ManyToOne
    @JoinColumn(name = "idOffreDeCovoiturage", referencedColumnName = "idOffreDeCovoiturage")
    @MapsId("idOffreDeCovoiturage")
    @NotNull
    @Size(max = 36)
    private OffreCovoiturage offreCovoiturage;

    @ManyToOne
    @JoinColumn(name = "idPanier", referencedColumnName = "idPanier")
    @MapsId("idPanier")
    @NotNull
    @Size(max = 36)
    private Panier panier;

    @ManyToOne
    @JoinColumn(name = "idArret", referencedColumnName = "idArret")
    @MapsId("idArret")
    @Size(max = 36)
    private ArretCovoiturage arretCovoiturage;

    private Integer nbPlaces;

}
