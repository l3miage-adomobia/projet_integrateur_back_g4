package fr.uga.miage.m1.model.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class ArretCovoiturage {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    private Long idArret;
    @NotNull
    @Column(length=36)
    private String nomLieu;
    @Column(length=50)
    private String adresseLieu;
    @NotNull
    private Double longitude;
    @NotNull
    private Double latitude;

    @ManyToOne
    @JoinColumn(name = "FK_codeInsee", referencedColumnName = "codeInsee")
    @NotNull
    private Lieu lieu;

}
