package fr.uga.miage.m1.model.entities;

import jakarta.persistence.*;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class SousDomaine {
    @Id
    @NotNull
    private String nomSousDomaine;
    @JoinColumn(name = "FK_nomDomaine", referencedColumnName = "nomDomaine")
    @NotNull
    @ManyToOne
    private Domaine domaine;

}