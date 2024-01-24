package fr.uga.miage.m1.model.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idReservation;

    @NotNull
    private int nbPlaces;

    @OneToOne
    @JoinColumn(name = "FK_idEtape", referencedColumnName = "idEtape")
    @NotNull
    private Etape trajet;

    @ManyToOne
    @JoinColumn(name = "FK_idPanier", referencedColumnName = "idPanier")
    @NotNull
    private Panier panier;

}
