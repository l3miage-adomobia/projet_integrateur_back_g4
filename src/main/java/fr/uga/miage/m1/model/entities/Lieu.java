package fr.uga.miage.m1.model.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Lieu {
    @Id
    @NotNull
    @Size(max = 10)
    private Long codeInsee;
    @NotNull
    private int codePostal;
    @NotNull
    @Size(max = 50)
    private String nomCommune;

    @NotNull
    @Min(-180)
    @Max(180)
    private Double longitudeCommune;
    @NotNull
    @Min(-90)
    @Max(90)
    private Double latitudeCommune;

    @ManyToOne
    @JoinColumn(name = "noDepartement", referencedColumnName = "noDepartement")
    @NotNull
    private Departement departement;

}