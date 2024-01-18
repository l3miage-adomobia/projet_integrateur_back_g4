package fr.uga.miage.m1.model.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Panier {
    @Id
    @NotNull
    private Long idPanier;
    @NotNull
    private Integer nbPlacesReserve;
    @NotNull
    private Boolean valide;

    @ManyToOne
    @JoinColumn(name = "idFestivalier")
    @NotNull
    private Festivalier festivalier;

}