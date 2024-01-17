package fr.uga.miage.m1.model.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "reservation")
@Getter
@Setter
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idReservation;

    private Integer nbPlaces;

    @ManyToOne
    @JoinColumn(name = "idOffreDeCovoiturage", referencedColumnName = "idOffreDeCovoiturage")
    private OffreCovoiturage offreCovoiturage;

    @ManyToOne
    @JoinColumn(name = "idPanier", referencedColumnName = "idReservation")
    private Panier panier;

    @ManyToOne
    @JoinColumn(name = "idArretCovoiturage", referencedColumnName = "idArret")
    private ArretCovoiturage arretCovoiturage;

}
