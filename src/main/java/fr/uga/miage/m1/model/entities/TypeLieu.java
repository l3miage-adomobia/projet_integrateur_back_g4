package fr.uga.miage.m1.model.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class TypeLieu {
    @Id
    private String typeLieu;

    @OneToMany(mappedBy = "typeLieuRelation")
    private List<ArretCovoiturage> arretCovoiturages;

}