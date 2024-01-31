package fr.uga.miage.m1.model.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
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
    private String nomFestival;
    @NotNull
    private int tarif;

    private String siteWeb;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @NotNull
    private LocalDate dateDebut;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @NotNull
    private LocalDate dateFin;
    @NotNull
    private String lieuPrincipal;

    @NotNull
    private int nombrePass;


    @ManyToOne
    @JoinColumn(name = "FK_idLieu", referencedColumnName = "idLieu")
    @NotNull
    private Lieu lieu;

    @ManyToOne
    @JoinColumn(name = "FK_idSousDomaine", referencedColumnName = "idSousDomaine")
    @NotNull
    private SousDomaine sousDomaine;


    @OneToMany(mappedBy ="festival")
    private List<OffreCovoiturage> covoiturages;
}
