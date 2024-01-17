package fr.uga.miage.m1.model.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
public class Festival {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFestival;
    private String nomFestival;
    private String tarif;
    private String siteWeb;
    private LocalDate dateDebut;
    private LocalDate dateFin;
    private String lieuPrincipal;
    private Integer nombrePass;

    @ManyToOne
    @JoinColumn(name = "codeInsee", referencedColumnName = "codeInsee")
    private Lieu lieu;

    @ManyToOne
    @JoinColumn(name = "nomSousDomaine", referencedColumnName = "nomSousDomaine")
    private SousDomaine sousDomaine;

}
