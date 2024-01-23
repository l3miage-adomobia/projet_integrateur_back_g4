package fr.uga.miage.m1.model.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.Collection;

@Entity
@Getter
@Setter
public class Panier {
    @Id
    @NotNull
    private Long idPanier;
    @NotNull
    private Boolean valide;

    @NotEmpty
    @OneToMany
    private Collection<Reservation> reservations;

    @ManyToOne
    @JoinColumn(name = "FK_idFestivalier", referencedColumnName = "idUtilisateur")
    @NotNull
    private Utilisateur festivalier;



}