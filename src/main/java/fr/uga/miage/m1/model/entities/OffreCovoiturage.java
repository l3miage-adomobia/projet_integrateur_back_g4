package fr.uga.miage.m1.model.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class OffreCovoiturage {
    @Id
    @NotNull
    @Size(max = 36)
    private Long idOffreDeCovoiturage;
    @NotNull
    private Integer nbPlacesOffertes;
    @NotNull
    @Size(max = 36)
    private String modeleVoiture;
    @NotNull
    @Size(max = 36)
    private String depart;
    @NotNull
    @Size(max = 36)
    private String arrive;

    @ManyToOne
    @JoinColumn(name = "idFestival", referencedColumnName = "idFestival")
    @NotNull
    @Size(max = 36)
    private Festival festival;

    @ManyToOne
    @JoinColumn(name = "idCovoitureur")
    @NotNull
    @Size(max = 36)
    private Covoitureur covoitureur;

    @OneToMany(mappedBy = "offreCovoiturage")
    @NotEmpty
    private List<AEtape> AEtapes;

}