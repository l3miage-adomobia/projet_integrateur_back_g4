package fr.uga.miage.m1.model.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class TypeLieu {
    @Id
    @NotNull
    @Size(max = 50)
    private String typeLieu;

    @OneToMany(mappedBy = "typeLieuRelation")
    private List<ArretCovoiturage> arretCovoiturages;

}