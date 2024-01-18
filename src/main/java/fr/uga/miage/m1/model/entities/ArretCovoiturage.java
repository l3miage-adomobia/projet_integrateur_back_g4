package fr.uga.miage.m1.model.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class ArretCovoiturage {
    @Id
    @NotNull
    @Size(max = 36)
    private Long idArret;
    @NotNull
    @Size(max = 50)
    private String nomLieu;
    @Size(max = 50)
    private String adresseLieu;
    @NotNull
    @Min(-180)
    @Max(180)
    private Double longitude;

    @NotNull
    @Min(-90)
    @Max(90)
    private Double latitude;

    @ManyToOne
    @JoinColumn(name = "idTypeLieu", referencedColumnName = "idTypeLieu")
    @NotNull
    @Size(max = 36)
    private TypeLieu typeLieuRelation;

    @ManyToOne
    @JoinColumn(name = "codeInsee", referencedColumnName = "codeInsee")
    @NotNull
    @Size(max = 10)
    private Lieu lieu;

    // Assume we have the AEtape entity mapped already
    @OneToMany(mappedBy = "arretCovoiturage")
    @NotNull
    private List<AEtape> AEtapes;

    // Getters and setters
}
