package fr.uga.miage.m1.model.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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
    @Size(max = 36)
    private Long idFestival;
    @NotNull
    @Size(max = 50)
    private String nomFestival;

    @NotNull
    @Size(max = 8)
    private int tarif;

    @Size(max = 50)
    private String siteWeb;
    @JsonFormat(pattern="dd/MM/yyyy")
    @NotNull
    private LocalDate dateDebut;
    @JsonFormat(pattern="dd/MM/yyyy")
    @NotNull
    private LocalDate dateFin;
    @NotNull
    @Size(max = 50)
    private String lieuPrincipal;
    @NotNull
    private Integer nombrePass;

    @ManyToOne
    @JoinColumn(name = "codeInsee", referencedColumnName = "codeInsee")
    @NotNull
    private Lieu lieu;

    @ManyToOne
    @JoinColumn(name = "nomSousDomaine", referencedColumnName = "nomSousDomaine")
    @NotNull
    private SousDomaine sousDomaine;

}
