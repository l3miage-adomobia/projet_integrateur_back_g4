package fr.uga.miage.m1.model.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class OffreCovoiturage {
    @Id
    @NotNull
    private Long idOffreDeCovoiturage;
    @NotNull
    private Integer nbPlacesOffertes;
    @NotNull
    private String modeleVoiture;
    @NotNull
    private String depart;
    @NotNull
    private String arrive;

    @ManyToOne
    @JoinColumn(name = "idFestival", referencedColumnName = "idFestival")
    @NotNull
    private Festival festival;

    @ManyToOne
    @JoinColumn(name = "idCovoitureur")
    @NotNull
    private Covoitureur covoitureur;

    @OneToMany(mappedBy = "offreCovoiturage")
    @NotEmpty
    private List<AEtape> AEtapes;

}