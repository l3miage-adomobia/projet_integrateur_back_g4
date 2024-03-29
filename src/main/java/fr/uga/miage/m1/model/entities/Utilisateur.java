package fr.uga.miage.m1.model.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@Inheritance(strategy = InheritanceType.JOINED)
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUtilisateur;

    private String nom;
    @Email
    @Column(unique = true)
    private String email;
    @NotNull
    private String typeUtilisateur;
    private String mdp;
    @OneToMany(mappedBy ="festivalier")
    private List<Panier> paniers;
}
