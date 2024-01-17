package fr.uga.miage.m1.model.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Panier {
    @Id
    private Long idReservation;
    private Integer nbPlacesReserve;
    private Boolean valide;

    @ManyToOne
    @JoinColumn(name = "idFestivalier")
    private Festivalier festivalier;

}