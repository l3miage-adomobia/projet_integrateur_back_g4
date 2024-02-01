package fr.uga.miage.m1.model.entities;

import jakarta.persistence.*;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class SousDomaine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSousDomaine;

    private String nomSousDomaine;

    @NotNull
    private String  nomDomaine;

}