package fr.uga.miage.m1.model.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class ArretCovoiturage {
    @Id
    private Long idArret;
    private String nomLieu;
    private String adresseLieu;
    private Double longitude;
    private Double latitude;

    @ManyToOne
    @JoinColumn(name = "typeLieu", referencedColumnName = "typeLieu")
    private TypeLieu typeLieuRelation;

    @ManyToOne
    @JoinColumn(name = "codeInsee", referencedColumnName = "codeInsee")
    private Lieu lieu;

    // Assume we have the AEtape entity mapped already
    @OneToMany(mappedBy = "arretCovoiturage")
    private List<AEtape> AEtapes;

    // Getters and setters
}
