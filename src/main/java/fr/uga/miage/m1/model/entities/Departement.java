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
public class Departement {
    @Id
    @NotNull
    private String noDepartement;
    @NotNull
    private String nomDepartement;

    // Relation avec Region (clé étrangère nomRegion)
    @ManyToOne
    @JoinColumn(name = "nomRegion", referencedColumnName = "nomRegion")
    @NotNull
    private Region region;

}