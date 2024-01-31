package fr.uga.miage.m1.model.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    public Reservation(int nbPlaces, Etape trajet, Panier panier){
        this.nbPlaces = nbPlaces;
        this.trajet = trajet;
        this.panier = panier;
    }
}
