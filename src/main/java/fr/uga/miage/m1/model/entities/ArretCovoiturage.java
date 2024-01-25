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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idArret;
    @NotNull
    private String nomLieu;
    private String adresseLieu;
    @NotNull
    private Double longitude;
    @NotNull
    private Double latitude;

    @ManyToOne
    @JoinColumn(name = "FK_idLieu", referencedColumnName = "idLieu")
    @NotNull
    private Lieu lieu;

}
