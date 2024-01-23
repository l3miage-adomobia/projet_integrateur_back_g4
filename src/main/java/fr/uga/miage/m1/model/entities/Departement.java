package fr.uga.miage.m1.model.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Departement {
    @Id
    @NotNull
    private int noDepartement;
    @NotNull
    @Column(length = 50)
    private String nomDepartement;
    @ManyToOne
    @JoinColumn(name = "FK_nomRegion", referencedColumnName = "nomRegion")
    @NotNull
    private Region region;

}