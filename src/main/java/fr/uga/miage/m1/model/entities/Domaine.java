package fr.uga.miage.m1.model.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Domaine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDomaine;

    @NotNull
    private String nomDomaine;

}
