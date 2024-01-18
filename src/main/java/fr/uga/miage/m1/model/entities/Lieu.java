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
public class Lieu {
    @Id
    @NotNull
    private Long codeInsee;
    @NotNull
    private int codePostal;
    @NotNull
    private String nomCommune;

    @NotNull
    private Double longitudeCommune;
    @NotNull
    private Double latitudeCommune;

    @ManyToOne
    @JoinColumn(name = "noDepartement", referencedColumnName = "noDepartement")
    @NotNull
    private Departement departement;

}