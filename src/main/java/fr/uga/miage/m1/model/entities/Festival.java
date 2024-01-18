package fr.uga.miage.m1.model.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
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
    @NotNull
    private Long idFestival;
    @NotNull
    private String nomFestival;

    @NotNull
    private int tarif;

    private String siteWeb;
    @JsonFormat(pattern="dd/MM/yyyy")
    @NotNull
    private LocalDate dateDebut;
    @JsonFormat(pattern="dd/MM/yyyy")
    @NotNull
    private LocalDate dateFin;
    @NotNull
    private String lieuPrincipal;
    @NotNull
    private Integer nombrePass;

    @ManyToOne
    @JoinColumn(name = "codeInsee", referencedColumnName = "codeInsee")
    private Lieu lieu;

    @ManyToOne
    @JoinColumn(name = "nomSousDomaine", referencedColumnName = "nomSousDomaine")
    @NotNull
    private SousDomaine sousDomaine;

}
