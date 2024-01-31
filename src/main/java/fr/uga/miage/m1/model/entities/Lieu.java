package fr.uga.miage.m1.model.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Lieu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLieu;

    @NotNull
    private Long codeInsee;
    @Column(nullable = true)
    private Integer codePostal;
    private String nomCommune;

    @NotNull
    private Double longitude;
    @NotNull
    private Double latitude;

    @ManyToOne
    @JoinColumn(name = "FK_idDepartement", referencedColumnName = "idDepartement")
    private Departement departement;

}