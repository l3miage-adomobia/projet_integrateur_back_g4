package fr.uga.miage.m1.model.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

@Entity
@Getter
@Setter
public class Festival {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFestival;
    @NotNull
    @Column(length = 36)
    private String nomFestival;
    @NotNull
    private int tarif;

    @Column(length = 50)
    private String siteWeb;
    @JsonFormat(pattern="dd/MM/yyyy")
    @NotNull
    private LocalDate dateDebut;
    @JsonFormat(pattern="dd/MM/yyyy")
    @NotNull
    private LocalDate dateFin;
    @NotNull
    @Column(length = 36)
    private String lieuPrincipal;
    @NotNull
    private int nombrePass;

    @ManyToOne
    @JoinColumn(name = "FK_codeInsee", referencedColumnName = "codeInsee")
    @NotNull
    private Lieu lieu;

    @ManyToOne
    @JoinColumn(name = "FK_nomSousDomaine", referencedColumnName = "nomSousDomaine")
    @NotNull
    private SousDomaine sousDomaine;

    @OneToMany(mappedBy ="festival")
    private Collection<OffreCovoiturage> covoiturages;
}
