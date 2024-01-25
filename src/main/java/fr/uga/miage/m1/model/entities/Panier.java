package fr.uga.miage.m1.model.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.Collection;
import java.util.List;

@Entity
@Getter
@Setter
public class Panier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPanier;

    @NotNull
    private Boolean valide;

    @NotEmpty
    @OneToMany(mappedBy ="panier")
    private List<Reservation> reservations;

    @ManyToOne
    @JoinColumn(name = "FK_idFestivalier", referencedColumnName = "idUtilisateur")
    @NotNull
    private Utilisateur festivalier;



}