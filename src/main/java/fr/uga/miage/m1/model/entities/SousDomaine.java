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
public class SousDomaine {
    @Id
    private String nomSousDomaine;

    // Relation avec Domaine (clé étrangère nomDomaine)
    @ManyToOne
    @JoinColumn(name = "nomDomaine", referencedColumnName = "nomDomaine")
    private Domaine domaine;

}