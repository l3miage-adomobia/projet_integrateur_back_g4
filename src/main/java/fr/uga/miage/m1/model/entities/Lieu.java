package fr.uga.miage.m1.model.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Lieu {
    @Id
    @NotNull
    private Long codeInsee;
    @NotNull
    private int codePostal;
    @NotNull
    @Column(length = 36)
    private String nomCommune;

    @NotNull
    private Double longitudeCommune;
    @NotNull
    private Double latitudeCommune;

    @ManyToOne
    @JoinColumn(name = "FK_noDepartement", referencedColumnName = "noDepartement")
    @NotNull
    private Departement departement;

}