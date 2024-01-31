package fr.uga.miage.m1.model.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import net.minidev.json.annotate.JsonIgnore;

import java.util.Collection;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Panier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPanier;

    @NotNull
    private Boolean valide;


    @OneToMany(mappedBy ="panier")
    private List<Reservation> reservations;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "FK_idFestivalier", referencedColumnName = "idUtilisateur")
    @NotNull
    private Utilisateur festivalier;

}