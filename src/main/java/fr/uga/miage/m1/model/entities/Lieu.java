package fr.uga.miage.m1.model.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Lieu {
    @Id
    private Long codeInsee;
    private String codePostal;
    private String nomCommune;
    private Double longitudeCommune;
    private Double latitudeCommune;

    @ManyToOne
    @JoinColumn(name = "noDepartement", referencedColumnName = "noDepartement")
    private Departement departement;

}