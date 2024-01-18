package fr.uga.miage.m1.model.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class ArretCovoiturage {
    @Id
    @NotNull
    private Long idArret;
    @NotNull
    private String nomLieu;
    private String adresseLieu;
    @NotNull
    private Double longitude;
    @NotNull
    private Double latitude;

    @ManyToOne
    @JoinColumn(name = "typeLieu", referencedColumnName = "typeLieu")
    @NotNull
    private TypeLieu typeLieuRelation;

    @ManyToOne
    @JoinColumn(name = "codeInsee", referencedColumnName = "codeInsee")
    @NotNull
    private Lieu lieu;

    // Assume we have the AEtape entity mapped already
    @OneToMany(mappedBy = "arretCovoiturage")
    @NotNull
    private List<AEtape> AEtapes;

    // Getters and setters
}
