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
public class OffreCovoiturage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idOffreDeCovoiturage;

    @NotNull
    private int nbPlacesOffertes;

    @NotNull
    private String modeleVoiture;

    @NotEmpty
    @OneToMany(mappedBy = "offreCovoiturage")
    private List<Etape> etapes;

    @ManyToOne
    @JoinColumn(name = "FK_idFestival", referencedColumnName = "idFestival")
    @NotNull
    private Festival festival;

    @ManyToOne
    @JoinColumn(name = "FK_idUtilisateur", referencedColumnName = "idUtilisateur")
    @NotNull
    private Utilisateur covoitureur;



}