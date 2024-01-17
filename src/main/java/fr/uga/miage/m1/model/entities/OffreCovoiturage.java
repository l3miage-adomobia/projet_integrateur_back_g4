package fr.uga.miage.m1.model.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class OffreCovoiturage {
    @Id
    private Long idOffreDeCovoiturage;
    private Integer nbPlacesOffertes;
    private String modeleVoiture;
    private String depart;
    private String arrive;

    @ManyToOne
    @JoinColumn(name = "idFestival", referencedColumnName = "idFestival")
    private Festival festival;

    @ManyToOne
    @JoinColumn(name = "idCovoitureur")
    private Covoitureur covoitureur;

    @OneToMany(mappedBy = "offreCovoiturage")
    private List<Etape> etapes;

}