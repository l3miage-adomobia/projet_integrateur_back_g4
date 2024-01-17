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
    private String typeLieu;
    private String adresseLieu;
    private Double longitude;
    private Double latitude;

    @ManyToOne
    @JoinColumn(name = "typeLieu_1", referencedColumnName = "typeLieu")
    private TypeLieu typeLieuRelation;

    @ManyToOne
    @JoinColumn(name = "codeInsee", referencedColumnName = "codeInsee")
    private Lieu lieu;

    // Assume we have the Etape entity mapped already
    @OneToMany(mappedBy = "arretCovoiturage")
    private List<Etape> etapes;

    // Getters and setters
}
