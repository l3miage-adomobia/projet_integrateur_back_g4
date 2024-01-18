package fr.uga.miage.m1.model.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "festivalier")
public class Festivalier extends Utilisateur {

    @Size(max = 36)
    private String nom;
    @Size(max = 36)
    private String prenom;
    @Size(max = 50)
    private String adresse;

}