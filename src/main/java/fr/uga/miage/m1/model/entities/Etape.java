package fr.uga.miage.m1.model.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

@Entity
@Getter
@Setter
public class Etape {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEtape;

    @NotNull
    private int tarif;

    @NotNull
    private int duree;

    @NotNull
    private Date heureDepart;

    @ManyToOne
    @JoinColumn(name = "FK_depart", referencedColumnName = "idArret")
    @NotNull
    private ArretCovoiturage depart;

    @ManyToOne
    @JoinColumn(name = "FK_offre", referencedColumnName = "idOffreDeCovoiturage")
    @NotNull
    private OffreCovoiturage offreCovoiturage;


}