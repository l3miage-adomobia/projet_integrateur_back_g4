package fr.uga.miage.m1.model.entities;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
@Entity
@Getter
@Setter
public class Region {
    @Id
    @NotNull
    private String nomRegion;

}